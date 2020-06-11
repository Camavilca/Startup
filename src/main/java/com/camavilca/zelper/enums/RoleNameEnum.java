package com.camavilca.zelper.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleNameEnum {

    ROLE_USER("usuario"), ROLE_ADMIN("administrador");

    private final String value;
    private static final Map<String, RoleNameEnum> lookup = new HashMap<>();

    static {
        for (RoleNameEnum pag : RoleNameEnum.values()) {
            lookup.put(pag.getValue(), pag);
        }
    }

    private RoleNameEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static RoleNameEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (RoleNameEnum pag : RoleNameEnum.values()) {
            if (pag.name().equalsIgnoreCase(nombre)) {
                return pag.getValue();
            }
        }
        return nombre;
    }
}
