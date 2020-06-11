package com.camavilca.dao.general.hibernate;

import com.camavilca.dao.general.UbicacionDAO;
import com.camavilca.model.general.Ubicacion;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class UbicacionDAOH extends AbstractEasyDAO<Ubicacion> implements UbicacionDAO {

    public UbicacionDAOH() {
        super();
        setClazz(Ubicacion.class);
    }

}
