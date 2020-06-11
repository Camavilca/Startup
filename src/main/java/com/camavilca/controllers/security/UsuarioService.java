package com.camavilca.controllers.security;

import com.camavilca.model.security.Usuario;
import com.camavilca.model.security.request.SignUpForm;

public interface UsuarioService {

    void save(SignUpForm user);

    Usuario findByUsername(String username);

}
