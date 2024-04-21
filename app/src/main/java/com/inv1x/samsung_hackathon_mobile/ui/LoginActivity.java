package com.inv1x.samsung_hackathon_mobile.ui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.ui.AppBarConfiguration;


import com.google.android.material.textfield.TextInputLayout;
import com.inv1x.samsung_hackathon_mobile.BoardActivity;
import com.inv1x.samsung_hackathon_mobile.R;
import com.inv1x.samsung_hackathon_mobile.api.IUserAPI;
import com.inv1x.samsung_hackathon_mobile.ui.RegistrationActivity;
import com.inv1x.samsung_hackathon_mobile.api.UserAPI;
import com.inv1x.samsung_hackathon_mobile.model.User;
import com.inv1x.samsung_hackathon_mobile.model.UserAuthDto;

import java.util.concurrent.CompletableFuture;

import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    public static int counter = 0;
    private UserAPI userAPI = new UserAPI();

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginBtn = findViewById(R.id.loginButton);
        Button registerBtn = findViewById(R.id.registerButton);
        TextInputLayout loginInput = findViewById(R.id.loginInput);
        TextInputLayout passwordInput = findViewById(R.id.passwordInput);

        // действие на кнопку "регистрация"
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginInput.getEditText().getText().toString().isEmpty()
                        || passwordInput.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserAuthDto userAuthDto = new UserAuthDto(counter++, loginInput.getEditText().getText().toString()
                            , passwordInput.getEditText().getText().toString());
                    try {
                        CompletableFuture.supplyAsync(() -> userAPI.loginUser(userAuthDto))
                                .thenAccept(user -> {
                                    if (user != null) {
                                        Intent intent = new Intent(LoginActivity.this, BoardActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Пользователь не существует! Зарегистрируйтесь", Toast.LENGTH_SHORT).show());
                                    }
                                });
                    } catch (RuntimeException e) {
                        Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // действие на кнопку "уже есть есть аккаунт"
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}