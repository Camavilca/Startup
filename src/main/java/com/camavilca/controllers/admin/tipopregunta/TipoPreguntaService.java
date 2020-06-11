package com.camavilca.controllers.admin.tipopregunta;

import com.camavilca.model.admin.TipoPregunta;
import java.util.List;

public interface TipoPreguntaService {

    List<TipoPregunta> all();

    TipoPregunta delete(TipoPregunta tipopregunta);

    TipoPregunta save(TipoPregunta tipopregunta);

}
