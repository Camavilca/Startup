package com.camavilca.controllers.admin.tipopregunta;

import com.camavilca.model.admin.TipoPregunta;
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
import pe.albatross.zelpers.miscelanea.ObjectUtil;
import pe.albatross.zelpers.miscelanea.PhobosException;

@Controller
@CrossOrigin
@RequestMapping("admin/tipopregunta")
public class TipoPreguntaController {

    @Autowired
    TipoPreguntaService service;

    @ResponseBody
    @RequestMapping("all")
    public JsonResponse all() {
        JsonResponse response = new JsonResponse();
        JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        ArrayNode arrayNode = new ArrayNode(jsonFactory);
        try {
            List<TipoPregunta> tipopreguntas = service.all();
            for (TipoPregunta tipopregunta : tipopreguntas) {
                ObjectNode node = JsonHelper.createJson(tipopregunta, jsonFactory, new String[]{"*"});
                arrayNode.add(node);
            }
            response.setData(arrayNode);
            response.setTotal(tipopreguntas.size());
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
    public JsonResponse save(@RequestBody TipoPregunta tipopregunta) {
        JsonResponse response = new JsonResponse();
        try {
            if (tipopregunta.getId() == null) {
                response.setMessage(CREATE);
            } else {
                response.setMessage(UPDATE);
            }
            TipoPregunta newtipo = service.save(tipopregunta);
            response.setSuccess(Boolean.TRUE);
            response.setData(newtipo);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JsonResponse delete(@RequestBody TipoPregunta tipopregunta) {
        JsonResponse response = new JsonResponse();
        ObjectUtil.printAttr(tipopregunta);
        try {
            TipoPregunta deltipo = service.delete(tipopregunta);
            response.setMessage(DELETE);
            response.setSuccess(Boolean.TRUE);
            response.setData(deltipo);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

}
