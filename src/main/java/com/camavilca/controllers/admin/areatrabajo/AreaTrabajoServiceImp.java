package com.camavilca.controllers.admin.areatrabajo;

import com.camavilca.dao.admin.AreaTrabajoDAO;
import com.camavilca.model.admin.AreaTrabajo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AreaTrabajoServiceImp implements AreaTrabajoService {
    
    @Autowired
    AreaTrabajoDAO areaTrabajoDAO;
    
    @Override
    @Transactional
    public void delete(AreaTrabajo area) {
        areaTrabajoDAO.delete(area);
    }
    
    @Override
    @Transactional
    public AreaTrabajo save(AreaTrabajo area) {
        if (area.getId() == null) {
            areaTrabajoDAO.save(area);
        } else {
            areaTrabajoDAO.update(area);
        }
        return area;
    }
    
    @Override
    public List<AreaTrabajo> all() {
        return areaTrabajoDAO.all();
    }
    
}
