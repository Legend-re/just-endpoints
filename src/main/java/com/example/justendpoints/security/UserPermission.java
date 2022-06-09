package com.example.justendpoints.security;

import lombok.Getter;

@Getter

public enum UserPermission {
    READ("read"),
    WRITE("write");

    private final String Permission;

    UserPermission(String permission) {
        Permission = permission;
    }
}
