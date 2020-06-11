package com.camavilca.controllers.admin.ubicaciontrabajo;

import com.camavilca.model.admin.TipoPregunta;
import com.camavilca.model.admin.UbicacionTrabajo;
import static com.camavilca.zelper.constant.Constantine.CREATE;
import static com.camavilca.zelper.constant.Constantine.DELETE;
import static com.camavilca.zelper.constant.Constantine.UPDATE;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.albatross.zelpers.miscelanea.ExceptionHandler;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.JsonResponse;
import pe.albatross.zelpers.miscelanea.PhobosException;

@Controller
@CrossOrigin
@RequestMapping("admin/ubicaciontrabajo")
public class UbicacionTrabajoController {

    @Autowired
    UbicacionTrabajoService service;

    @ResponseBody
    @RequestMapping("all")
    public JsonResponse all() {
        JsonResponse response = new JsonResponse();
        JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        ArrayNode arrayNode = new ArrayNode(jsonFactory);
        try {
            List<UbicacionTrabajo> ubicaciones = service.all();
            for (UbicacionTrabajo ubicacionTrabajo : ubicaciones) {
                ObjectNode node = JsonHelper.createJson(ubicacionTrabajo, jsonFactory, new String[]{"*"});
                arrayNode.add(node);
            }
            response.setData(arrayNode);
            response.setTotal(ubicaciones.size());
            response.setSuccess(Boolean.TRUE);
        } catch (PhobosException e) {
            ExceptionHandler.handlePhobosEx(e, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("save")
    public JsonResponse save(@RequestBody UbicacionTrabajo ubicacionTrabajo) {
        JsonResponse response = new JsonResponse();
        try {
            if (ubicacionTrabajo.getId() == null) {
                response.setMessage(CREATE);
            } else {
                response.setMessage(UPDATE);
            }
            UbicacionTrabajo newubicacion = service.save(ubicacionTrabajo);
            response.setSuccess(Boolean.TRUE);
            response.setData(newubicacion);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JsonResponse delete(@RequestBody UbicacionTrabajo ubicacionTrabajo) {
        JsonResponse response = new JsonResponse();
        try {
            UbicacionTrabajo delUbicacion = service.delete(ubicacionTrabajo);
            System.out.println(delUbicacion);
            response.setMessage(DELETE);
            response.setSuccess(Boolean.TRUE);
            response.setData(delUbicacion);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

}
