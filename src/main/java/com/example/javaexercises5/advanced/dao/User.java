package com.example.javaexercises5.advanced.dao;

import java.time.LocalDateTime;

public class User implements Model {
    private Long id;
    private String username;
    private LocalDateTime created;
    private int groupId;

    public User(Long id, String username, LocalDateTime created, int groupId) {
        this.id = id;
        this.username = username;
        this.created = created;
        this.groupId = groupId;
    }

    public User(String username, LocalDateTime created, int groupId) {
        this(null, username, created, groupId);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public User setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public User setGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %s, %s]", getId(), getGroupId(), getCreated(), getGroupId());
    }
}
