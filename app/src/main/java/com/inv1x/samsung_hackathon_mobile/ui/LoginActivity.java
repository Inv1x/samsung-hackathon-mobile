package com.inv1x.samsung_hackathon_mobile.ui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.inv1x.samsung_hackathon_mobile.BoardActivity;
import com.inv1x.samsung_hackathon_mobile.R;
import com.inv1x.samsung_hackathon_mobile.api.UserAPI;
import com.inv1x.samsung_hackathon_mobile.databinding.ActivityLoginBinding;
import com.inv1x.samsung_hackathon_mobile.model.User;
import com.inv1x.samsung_hackathon_mobile.model.UserAuthDto;

import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private UserAPI userAPI;

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
                if (loginInput.toString().isEmpty() || passwordInput.toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserAuthDto userAuthDto = new UserAuthDto(loginInput.getEditText(), passwordInput.getEditText());
                    try {
                        User user = userAPI.loginUser(userAuthDto);
                        if (user != null) {
                            Intent intent = new Intent(LoginActivity.this, BoardActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Пользователь не существует! Зарегистрируйтесь", Toast.LENGTH_SHORT).show();
                        }
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
            }
        });
    }
}