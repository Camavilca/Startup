package com.camavilca.dao.admin.hibernate;

import com.camavilca.dao.admin.UbicacionTrabajoDAO;
import com.camavilca.model.admin.UbicacionTrabajo;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class UbicacionTrabajoDAOH extends AbstractEasyDAO<UbicacionTrabajo> implements UbicacionTrabajoDAO {

    public UbicacionTrabajoDAOH() {
        super();
        setClazz(UbicacionTrabajo.class);
    }
}
