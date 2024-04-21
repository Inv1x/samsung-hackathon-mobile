package com.inv1x.samsung_hackathon_mobile.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColumnTask {
    private long id;
    private String description;
    private User assignedTo;
    private long columnId;
}
