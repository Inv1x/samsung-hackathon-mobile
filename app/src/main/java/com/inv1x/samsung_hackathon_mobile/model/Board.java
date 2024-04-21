package com.inv1x.samsung_hackathon_mobile.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
    private long id;
    private String title;
    private User owner;
    private Set<User> collaborators;
    private Set<BoardColumn> columns;
}
