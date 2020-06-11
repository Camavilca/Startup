package com.camavilca.dao.security.hibernate;

import com.camavilca.dao.security.RoleDAO;
import com.camavilca.model.security.Role;
import com.camavilca.zelper.enums.RoleNameEnum;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.Octavia;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class RoleDAOH extends AbstractEasyDAO<Role> implements RoleDAO {

    public RoleDAOH() {
        super();
        setClazz(Role.class);
    }

    @Override
    public Role findByName(RoleNameEnum role) {
        Octavia sql = Octavia.query()
                .from(Role.class, "r")
                .filter("name", role);
        return find(sql);
    }

}
