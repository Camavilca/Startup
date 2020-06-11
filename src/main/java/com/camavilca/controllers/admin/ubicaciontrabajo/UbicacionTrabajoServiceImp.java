package com.camavilca.controllers.admin.ubicaciontrabajo;

import com.camavilca.dao.admin.UbicacionTrabajoDAO;
import com.camavilca.model.admin.UbicacionTrabajo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UbicacionTrabajoServiceImp implements UbicacionTrabajoService {

    @Autowired
    UbicacionTrabajoDAO ubicacionTrabajoDAO;

    @Override
    public List<UbicacionTrabajo> all() {
        return ubicacionTrabajoDAO.all();
    }

    @Override
    @Transactional
    public UbicacionTrabajo save(UbicacionTrabajo ubicacionTrabajo) {
        if (ubicacionTrabajo.getId() == null) {
            ubicacionTrabajoDAO.save(ubicacionTrabajo);
        } else {
            ubicacionTrabajoDAO.update(ubicacionTrabajo);
        }
        return ubicacionTrabajo;
    }

    @Override
    @Transactional
    public UbicacionTrabajo delete(UbicacionTrabajo ubicacionTrabajo) {
        ubicacionTrabajoDAO.delete(ubicacionTrabajo);
        return ubicacionTrabajo;
    }

}
