package com.camavilca.dao.admin.hibernate;

import com.camavilca.dao.admin.TipoPreguntaDAO;
import com.camavilca.model.admin.TipoPregunta;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class TipoPreguntaDAOH extends AbstractEasyDAO<TipoPregunta> implements TipoPreguntaDAO {

    public TipoPreguntaDAOH() {
        super();
        setClazz(TipoPregunta.class);
    }
}
