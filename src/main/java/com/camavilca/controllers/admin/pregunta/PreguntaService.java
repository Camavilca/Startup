package com.camavilca.controllers.admin.pregunta;

import com.camavilca.model.admin.Pregunta;
import java.util.List;

public interface PreguntaService {

    List<Pregunta> all();

    void save(Pregunta pregunta);

    void delete(Pregunta pregunta);

}
