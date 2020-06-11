package com.camavilca.controllers.security;

import com.camavilca.model.admin.AreaTrabajo;
import com.camavilca.model.security.Usuario;
import static com.camavilca.zelper.constant.Constantine.CREATE;
import static com.camavilca.zelper.constant.Constantine.UPDATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.albatross.zelpers.miscelanea.ExceptionHandler;
import pe.albatross.zelpers.miscelanea.JsonResponse;
import pe.albatross.zelpers.miscelanea.PhobosException;

@RestController
@RequestMapping("api/auth")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @ResponseBody
    @RequestMapping("signin")
    public JsonResponse signin(@RequestBody Usuario usuario) {
        JsonResponse response = new JsonResponse();
        try {
            Usuario usuarioLogin = service.findByUsername(usuario.getUsername());
            if (null != usuarioLogin.getId()) {
                response.setSuccess(Boolean.FALSE);
                response.setMessage("Su usuario o correo no coinciden");
            } else {
                response.setMessage("Bienvenido" + usuarioLogin.getUsername());
                response.setSuccess(Boolean.TRUE);
                response.setData(usuarioLogin);
            }
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("signup")
    public JsonResponse signup(@RequestBody AreaTrabajo area) {
        JsonResponse response = new JsonResponse();
        try {
            if (area.getId() == null) {
                response.setMessage(CREATE);
            } else {
                response.setMessage(UPDATE);
            }
//            AreaTrabajo newArea = service.save(area);
            response.setSuccess(Boolean.TRUE);
//            response.setData(newArea);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }
}
