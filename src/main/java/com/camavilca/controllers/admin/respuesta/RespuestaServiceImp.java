package com.camavilca.controllers.admin.respuesta;

import com.camavilca.dao.admin.RespuestaDAO;
import com.camavilca.model.admin.Respuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RespuestaServiceImp implements RespuestaService {

    @Autowired
    RespuestaDAO respuestaDAO;

    @Override
    public void delete(Respuesta respuesta) {
        respuestaDAO.delete(respuesta);
    }

    @Override
    @Transactional
    public void save(Respuesta respuesta) {
        respuestaDAO.save(respuesta);
    }

    @Override
    @Transactional
    public List<Respuesta> all() {
        return respuestaDAO.all();
    }

}
