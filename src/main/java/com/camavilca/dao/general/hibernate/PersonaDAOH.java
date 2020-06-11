package com.camavilca.dao.general.hibernate;

import com.camavilca.dao.general.PersonaDAO;
import com.camavilca.model.general.Persona;
import com.camavilca.model.general.TipoPersonal;
import com.camavilca.zelper.enums.TipoPersonalEnum;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.Octavia;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class PersonaDAOH extends AbstractEasyDAO<Persona> implements PersonaDAO {

    public PersonaDAOH() {
        super();
        setClazz(Persona.class);
    }

}
