package com.camavilca.zelper.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPersonalEnum {

    EMP("empleado"), ASP("aspirante");

    private final String value;
    private static final Map<String, TipoPersonalEnum> lookup = new HashMap<>();

    static {
        for (TipoPersonalEnum pag : TipoPersonalEnum.values()) {
            lookup.put(pag.getValue(), pag);
        }
    }

    private TipoPersonalEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static TipoPersonalEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoPersonalEnum pag : TipoPersonalEnum.values()) {
            if (pag.name().equalsIgnoreCase(nombre)) {
                return pag.getValue();
            }
        }
        return nombre;
    }

}
