package com.camavilca.dao.security.hibernate;

import com.camavilca.dao.security.UsuarioDAO;
import com.camavilca.model.security.Usuario;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.Octavia;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
@Transactional
public class UsuarioDAOH extends AbstractEasyDAO<Usuario> implements UsuarioDAO {

    public UsuarioDAOH() {
        super();
        setClazz(Usuario.class);
    }

    @Override
    public Usuario findByUsername(String username) {
        Octavia sql = new Octavia()
                .from(Usuario.class, "u")
                .beginBlock()
                .__().filter("email", username)
                .__().filter("username", username)
                .endBlock()
                .join("persona p");
        return find(sql);
    }
}
