package com.camavilca.zelper.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoSexoEnum {

    MAS("masculino"), FEM("femenino");

    private final String value;
    private static final Map<String, TipoSexoEnum> lookup = new HashMap<>();

    static {
        for (TipoSexoEnum pag : TipoSexoEnum.values()) {
            lookup.put(pag.getValue(), pag);
        }
    }

    private TipoSexoEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static TipoSexoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoSexoEnum pag : TipoSexoEnum.values()) {
            if (pag.name().equalsIgnoreCase(nombre)) {
                return pag.getValue();
            }
        }
        return nombre;
    }

}
