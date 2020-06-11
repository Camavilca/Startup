package com.camavilca.dao.admin.hibernate;

import com.camavilca.dao.admin.AreaTrabajoDAO;
import com.camavilca.model.admin.AreaTrabajo;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class AreaTrabajoDAOH extends AbstractEasyDAO<AreaTrabajo> implements AreaTrabajoDAO {

    public AreaTrabajoDAOH() {
        super();
        setClazz(AreaTrabajo.class);
    }
}
