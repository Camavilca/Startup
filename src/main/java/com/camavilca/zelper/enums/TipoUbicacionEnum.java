package com.camavilca.zelper.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoUbicacionEnum {

    PAIS("Pais"), DEPA("Departamento"), PROV("Provincia"), DIST("Distrito");

    private final String value;
    private static final Map<String, TipoUbicacionEnum> lookup = new HashMap<>();

    static {
        for (TipoUbicacionEnum pag : TipoUbicacionEnum.values()) {
            lookup.put(pag.getValue(), pag);
        }
    }

    private TipoUbicacionEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static TipoUbicacionEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoUbicacionEnum pag : TipoUbicacionEnum.values()) {
            if (pag.name().equalsIgnoreCase(nombre)) {
                return pag.getValue();
            }
        }
        return nombre;
    }

}
