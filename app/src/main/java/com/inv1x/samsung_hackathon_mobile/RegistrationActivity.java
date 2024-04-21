package com.inv1x.samsung_hackathon_mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.inv1x.samsung_hackathon_mobile.api.BoardAPI;
import com.inv1x.samsung_hackathon_mobile.api.UserAPI;
import com.inv1x.samsung_hackathon_mobile.data.model.UserAthRegister;
import com.inv1x.samsung_hackathon_mobile.model.User;

import java.util.List;


public class RegistrationActivity extends AppCompatActivity {
    public static UserAPI userAPI;
    public static String UserEmail;
    public static BoardAPI boardAPI;
    public static EditText UserloginText;
    public static EditText UseremailText;
    public static EditText UserpasswordText;
    public static Button Registerbutton;
    public static Button buttonforjoin;
    public User user;
    public String email, login,password;
    public List<User> userlist;
    private Context context = new RegistrationActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        buttonforjoin = findViewById(R.id.registerButton);
        userAPI = new UserAPI();
        buttonforjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, loginActivity.class);
                startActivity(intent);
            }
        });

        UseremailText = findViewById(R.id.emailInput);
        UserloginText = findViewById(R.id.loginInput);
        UserpasswordText = findViewById(R.id.passwordInput);
        Registerbutton = findViewById(R.id.registerButton);
        UserAthRegister userAthRegister = new UserAthRegister(UseremailText.toString(), UserpasswordText.toString(), UserloginText.toString());

        Registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAPI.registerUser(userAthRegister);

                Intent intent= new Intent(context, BoardActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkUserData() {
        // TODO implement ASAP!
        return false;
    }
}
