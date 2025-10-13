package com.foursale.testetecnico.victor.ms_product.boundary.auth;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum Roles {
    ADMIN("admin"),
    USER("user");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> toStringList() {
        return Arrays.stream(Roles.values())
                .map(Roles::getName)
                .toList();
    }

    public static boolean hasName(String value) {
        return Arrays.stream(Roles.values())
                .anyMatch(name -> name.equals(value));
    }

    public static boolean hasAdminName(String name) {
        if (StringUtils.isBlank(name)) return false;
        return ADMIN.name.equals(name.toLowerCase());
    }
}

