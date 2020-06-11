package com.camavilca.controllers.admin.pregunta;

import com.camavilca.model.admin.Pregunta;
import static com.camavilca.zelper.constant.Constantine.CREATE;
import static com.camavilca.zelper.constant.Constantine.DELETE;
import static com.camavilca.zelper.constant.Constantine.UPDATE;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.albatross.zelpers.miscelanea.ExceptionHandler;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.JsonResponse;
import pe.albatross.zelpers.miscelanea.PhobosException;

@Controller
@RequestMapping("admin/pregunta")
public class PreguntaController {

    @Autowired
    PreguntaService service;

    @ResponseBody
    @RequestMapping("all")
    public JsonResponse all() {
        JsonResponse response = new JsonResponse();
        JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        ArrayNode arrayNode = new ArrayNode(jsonFactory);
        try {
            List<Pregunta> preguntas = service.all();
            for (Pregunta pregunta : preguntas) {
                ObjectNode node = JsonHelper.createJson(pregunta, jsonFactory, new String[]{"*"});
                arrayNode.add(node);
            }
            response.setData(arrayNode);
            response.setTotal(preguntas.size());
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
    public JsonResponse save(@RequestBody Pregunta pregunta) {
        JsonResponse response = new JsonResponse();
        try {
            if (pregunta.getId() == null) {
                response.setMessage(CREATE);
            } else {
                response.setMessage(UPDATE);
            }
            response.setSuccess(Boolean.TRUE);
            service.save(pregunta);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JsonResponse delete(@RequestBody Pregunta pregunta) {
        JsonResponse response = new JsonResponse();
        try {
            service.delete(pregunta);
            response.setMessage(DELETE);
            response.setSuccess(Boolean.TRUE);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

}
