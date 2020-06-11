package com.camavilca.dao.admin.hibernate;

import com.camavilca.dao.admin.RespuestaDAO;
import com.camavilca.model.admin.Respuesta;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class RespuestaDAOH extends AbstractEasyDAO<Respuesta> implements RespuestaDAO {

    public RespuestaDAOH() {
        super();
        setClazz(Respuesta.class);
    }
}
