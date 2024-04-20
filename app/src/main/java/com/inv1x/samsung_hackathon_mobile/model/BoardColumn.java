package com.inv1x.samsung_hackathon_mobile.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardColumn {
    private long id;

    private String heading;

    private Set<ColumnTask> columnTasks;

    private Board board;
}
