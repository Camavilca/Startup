package com.camavilca.controllers.admin.empresa;

import com.camavilca.dao.admin.EmpresaDAO;
import com.camavilca.model.general.Empresa;
import com.camavilca.zelper.constant.Constantine;
import com.camavilca.zelper.enums.EstadoEnum;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.albatross.zelpers.miscelanea.PhobosException;

@Service
@Transactional(readOnly = true)
public class EmpresaServiceImp implements EmpresaService {

    @Autowired
    EmpresaDAO empresaDAO;

    @Override
    public List<Empresa> all() {
        return empresaDAO.all();
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        if (empresa.getId() == null) {
            Empresa newempresa = new Empresa();
            newempresa.setDescripcion(empresa.getDescripcion());
            newempresa.setEstadoEnum(EstadoEnum.ACT);
            newempresa.setFechaRegistro(new Date());
            newempresa.setNombre(empresa.getNombre());
            empresaDAO.save(newempresa);
        } else {
            empresaDAO.update(empresa);
        }
        return empresa;
    }

    @Override
    @Transactional
    public Empresa delete(Empresa empresa) {
        empresaDAO.delete(empresa);
        return empresa;
    }

}
