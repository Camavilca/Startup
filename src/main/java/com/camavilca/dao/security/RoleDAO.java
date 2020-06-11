package com.camavilca.dao.security;

import com.camavilca.model.security.Role;
import com.camavilca.zelper.enums.RoleNameEnum;
import pe.albatross.octavia.easydao.EasyDAO;

public interface RoleDAO extends EasyDAO<Role> {

    Role findByName(RoleNameEnum role);

}
