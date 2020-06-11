package com.camavilca.controllers.admin.empresa;

import com.camavilca.model.general.Empresa;
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
@RequestMapping("admin/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @ResponseBody
    @RequestMapping("all")
    public JsonResponse all() {
        JsonResponse response = new JsonResponse();
        JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        ArrayNode arrayNode = new ArrayNode(jsonFactory);
        try {
            List<Empresa> empresas = service.all();
            for (Empresa empresa : empresas) {
                ObjectNode node = JsonHelper.createJson(empresa, jsonFactory, new String[]{"*"});
                arrayNode.add(node);
            }
            response.setData(arrayNode);
            response.setTotal(empresas.size());
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
    public JsonResponse save(@RequestBody Empresa empresa) {
        JsonResponse response = new JsonResponse();
        try {
            if (empresa.getId() == null) {
                response.setMessage(CREATE);
            } else {
                response.setMessage(UPDATE);
            }
            Empresa newEmpresa = service.save(empresa);
            response.setSuccess(Boolean.TRUE);
            response.setData(newEmpresa);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JsonResponse delete(@RequestBody Empresa empresa) {
        JsonResponse response = new JsonResponse();
        try {
            Empresa delEmpresa = service.delete(empresa);
            response.setMessage(DELETE);
            response.setSuccess(Boolean.TRUE);
            response.setData(delEmpresa);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

}
