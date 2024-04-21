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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Board> getBoards() {
        return boards;
    }

    public void setBoards(Set<Board> boards) {
        this.boards = boards;
    }

    public Set<ColumnTask> getTasks() {
        return tasks;
    }

    public void setTasks(Set<ColumnTask> tasks) {
        this.tasks = tasks;
    }
}
