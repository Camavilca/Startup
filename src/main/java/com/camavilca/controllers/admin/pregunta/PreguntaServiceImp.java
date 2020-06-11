package com.camavilca.controllers.admin.pregunta;

import com.camavilca.dao.admin.PreguntaDAO;
import com.camavilca.model.admin.Pregunta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PreguntaServiceImp implements PreguntaService {

    @Autowired
    PreguntaDAO preguntaDAO;

    @Override
    public List<Pregunta> all() {
        return preguntaDAO.all();
    }

    @Override
    @Transactional
    public void save(Pregunta pregunta) {
        if (pregunta.getId() == null) {
            preguntaDAO.save(pregunta);
        } else {
            preguntaDAO.update(pregunta);
        }
    }

    @Override
    @Transactional
    public void delete(Pregunta pregunta) {
        preguntaDAO.delete(pregunta);
    }

}
