package com.camavilca.controllers.admin.tipopregunta;

import com.camavilca.dao.admin.TipoPreguntaDAO;
import com.camavilca.model.admin.TipoPregunta;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TipoPreguntaServiceImp implements TipoPreguntaService {
    
    @Autowired
    TipoPreguntaDAO tipoPreguntaDAO;
    
    @Override
    public List<TipoPregunta> all() {
        return tipoPreguntaDAO.all();
    }
    
    @Override
    @Transactional
    public TipoPregunta delete(TipoPregunta tipopregunta) {
        tipoPreguntaDAO.delete(tipopregunta);
        return tipopregunta;
    }
    
    @Override
    @Transactional
    public TipoPregunta save(TipoPregunta tipopregunta) {
        if (tipopregunta.getId() == null) {
            tipopregunta.setFechaRegistro(new Date());
            tipoPreguntaDAO.save(tipopregunta);
        } else {
            tipoPreguntaDAO.update(tipopregunta);
        }
        return tipopregunta;
    }
    
}
