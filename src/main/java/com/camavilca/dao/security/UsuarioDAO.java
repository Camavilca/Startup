package com.camavilca.dao.security;

import com.camavilca.model.security.Usuario;
import pe.albatross.octavia.easydao.EasyDAO;

public interface UsuarioDAO extends EasyDAO<Usuario> {

    Usuario findByUsername(String username);

}
