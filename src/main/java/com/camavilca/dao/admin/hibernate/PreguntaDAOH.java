package com.camavilca.dao.admin.hibernate;

import com.camavilca.dao.admin.PreguntaDAO;
import com.camavilca.model.admin.Post;
import com.camavilca.model.admin.Pregunta;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class PreguntaDAOH extends AbstractEasyDAO<Pregunta> implements PreguntaDAO {

    public PreguntaDAOH() {
        super();
        setClazz(Pregunta.class);
    }
}
