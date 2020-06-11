package com.camavilca.dao.general.hibernate;

import com.camavilca.dao.general.TipoPersonalDAO;
import com.camavilca.model.general.TipoPersonal;
import com.camavilca.zelper.enums.TipoPersonalEnum;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.Octavia;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class TipoPersonalDAOH extends AbstractEasyDAO<TipoPersonal> implements TipoPersonalDAO {

    public TipoPersonalDAOH() {
        super();
        setClazz(TipoPersonal.class);
    }

    @Override
    public TipoPersonal findByCodigo(TipoPersonalEnum codigo) {

        System.out.println("NOMBRE::::::: CODIGO:::::" + codigo);

        Octavia sql = Octavia.query()
                .from(TipoPersonal.class, "tp")
                .filter("codigo", codigo);
        return find(sql);
    }
}
