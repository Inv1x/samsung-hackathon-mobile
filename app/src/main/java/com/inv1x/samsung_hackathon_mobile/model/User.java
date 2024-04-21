package com.inv1x.samsung_hackathon_mobile.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String username;
    private String email;
    private Set<Board> boards;

    private Set<ColumnTask> tasks;

}
