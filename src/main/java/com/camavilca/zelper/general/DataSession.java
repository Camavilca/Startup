package com.camavilca.zelper.general;

import com.camavilca.model.general.Persona;
import com.camavilca.model.security.Usuario;
import java.io.Serializable;

public class DataSession implements Serializable {

    private Persona persona;
    private Usuario usuario;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
