package com.inv1x.samsung_hackathon_mobile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.inv1x.samsung_hackathon_mobile.BoardListActivity;
import com.inv1x.samsung_hackathon_mobile.R;
import com.inv1x.samsung_hackathon_mobile.api.IUserAPI;
import com.inv1x.samsung_hackathon_mobile.api.UserAPI;
import com.inv1x.samsung_hackathon_mobile.model.UserAuthDto;
import com.inv1x.samsung_hackathon_mobile.model.UserRegisterDto;

import java.util.concurrent.CompletableFuture;

public class RegistrationActivity extends AppCompatActivity {
    public static int counter = 0;
    private UserAPI userAPI = new UserAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button registerBtn = findViewById(R.id.registerButton);
        Button loginBtn = findViewById(R.id.loginButton);
        TextInputLayout emailInput = findViewById(R.id.emailInput);
        TextInputLayout usernameInput = findViewById(R.id.loginInput);
        TextInputLayout passwordInput = findViewById(R.id.passwordInput);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameInput.getEditText().getText().toString().isEmpty()
                        || passwordInput.getEditText().getText().toString().isEmpty()
                        || emailInput.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserRegisterDto userRegisterDto = new UserRegisterDto(
                            counter++
                            , usernameInput.getEditText().getText().toString()
                            , emailInput.getEditText().getText().toString()
                            , passwordInput.getEditText().getText().toString());
                    try {
                        CompletableFuture.supplyAsync(() -> userAPI.registerUser(userRegisterDto))
                                .thenAccept(user -> {
                                    if (user != null) {
                                        Log.d("RegistrationActivity", "User registered");
                                        runOnUiThread(() -> {
                                            Intent intent = new Intent(RegistrationActivity.this, BoardListActivity.class);
                                            startActivity(intent);
                                            finish();
                                        });
                                    } else {
                                        Log.e("RegistrationActivity", "User not registered");
                                        runOnUiThread(() -> Toast.makeText(RegistrationActivity.this, "Пользователь не существует! Зарегистрируйтесь", Toast.LENGTH_SHORT).show());
                                    }
                                });
                    } catch (RuntimeException e) {
                        Toast.makeText(RegistrationActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}