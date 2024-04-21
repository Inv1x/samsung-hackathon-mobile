package com.inv1x.samsung_hackathon_mobile.model;

import android.widget.EditText;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthDto {
    private int id;
    private String email;
    private String password;
}
