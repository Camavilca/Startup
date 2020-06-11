package com.camavilca.zelper.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoEnum {

    ACT("activo"), INA("inactivo");

    private final String value;
    private static final Map<String, EstadoEnum> lookup = new HashMap<>();

    static {
        for (EstadoEnum pag : EstadoEnum.values()) {
            lookup.put(pag.getValue(), pag);
        }
    }

    private EstadoEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static EstadoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoEnum pag : EstadoEnum.values()) {
            if (pag.name().equalsIgnoreCase(nombre)) {
                return pag.getValue();
            }
        }
        return nombre;
    }

}
