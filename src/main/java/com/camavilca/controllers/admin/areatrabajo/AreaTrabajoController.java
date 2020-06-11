package com.camavilca.controllers.admin.areatrabajo;

import com.camavilca.model.admin.AreaTrabajo;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.albatross.zelpers.miscelanea.ExceptionHandler;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.albatross.zelpers.miscelanea.JsonResponse;
import pe.albatross.zelpers.miscelanea.ObjectUtil;
import pe.albatross.zelpers.miscelanea.PhobosException;

@Controller
@CrossOrigin
@RequestMapping("admin/areatrabajo")
public class AreaTrabajoController {

    @Autowired
    AreaTrabajoService service;

    @ResponseBody
    @RequestMapping("all")
    public JsonResponse all() {
        JsonResponse response = new JsonResponse();
        JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        ArrayNode arrayNode = new ArrayNode(jsonFactory);
        try {
            List<AreaTrabajo> areas = service.all();
            for (AreaTrabajo area : areas) {
                ObjectNode node = JsonHelper.createJson(area, jsonFactory, new String[]{"*"});
                arrayNode.add(node);
            }
            response.setData(arrayNode);
            response.setTotal(areas.size());
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
    public JsonResponse save(@RequestBody AreaTrabajo area) {
        JsonResponse response = new JsonResponse();
        try {
            if (area.getId() == null) {
                response.setMessage(CREATE);
            } else {
                response.setMessage(UPDATE);
            }
            AreaTrabajo newArea = service.save(area);
            response.setSuccess(Boolean.TRUE);
            response.setData(newArea);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JsonResponse delete(@RequestBody AreaTrabajo area) {
        ObjectUtil.printAttr(area);
        JsonResponse response = new JsonResponse();
        try {
            service.delete(area);
            response.setMessage(DELETE);
            response.setSuccess(Boolean.TRUE);
            response.setData(area);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

}
