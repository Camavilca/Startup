package com.camavilca.controllers.admin.empresa;

import com.camavilca.model.general.Empresa;
import java.util.List;

public interface EmpresaService {

    List<Empresa> all();

    Empresa save(Empresa empresa);

    Empresa delete(Empresa empresa);

}
