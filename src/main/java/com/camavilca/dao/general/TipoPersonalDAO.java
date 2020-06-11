package com.camavilca.dao.general;

import com.camavilca.model.general.TipoPersonal;
import com.camavilca.zelper.enums.TipoPersonalEnum;
import pe.albatross.octavia.easydao.EasyDAO;

public interface TipoPersonalDAO extends EasyDAO<TipoPersonal> {

    TipoPersonal findByCodigo(TipoPersonalEnum codigo);

}
