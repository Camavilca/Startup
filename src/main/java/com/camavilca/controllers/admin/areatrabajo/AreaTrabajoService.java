package com.camavilca.controllers.admin.areatrabajo;

import com.camavilca.model.admin.AreaTrabajo;
import java.util.List;

public interface AreaTrabajoService {

    void delete(AreaTrabajo area);

    AreaTrabajo save(AreaTrabajo area);

    List<AreaTrabajo> all();

}
