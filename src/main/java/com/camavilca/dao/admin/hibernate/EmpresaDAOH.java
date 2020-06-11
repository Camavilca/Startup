package com.camavilca.dao.admin.hibernate;

import com.camavilca.dao.admin.EmpresaDAO;
import com.camavilca.model.general.Empresa;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class EmpresaDAOH extends AbstractEasyDAO<Empresa> implements EmpresaDAO {

    public EmpresaDAOH() {
        super();
        setClazz(Empresa.class);
    }
}
