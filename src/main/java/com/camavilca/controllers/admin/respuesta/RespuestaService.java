package com.camavilca.controllers.admin.respuesta;

import com.camavilca.model.admin.Respuesta;
import java.util.List;

public interface RespuestaService {

    void delete(Respuesta respuesta);

    void save(Respuesta respuesta);

    List<Respuesta> all();

}
