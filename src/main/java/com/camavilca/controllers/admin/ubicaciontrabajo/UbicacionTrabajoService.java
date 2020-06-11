package com.camavilca.controllers.admin.ubicaciontrabajo;

import com.camavilca.model.admin.UbicacionTrabajo;
import java.util.List;

public interface UbicacionTrabajoService {

    List<UbicacionTrabajo> all();

    UbicacionTrabajo save(UbicacionTrabajo ubicacionTrabajo);

    UbicacionTrabajo delete(UbicacionTrabajo ubicacionTrabajo);

}
