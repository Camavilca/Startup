package com.camavilca.controllers.admin.post;

import com.camavilca.model.admin.Post;
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
@RequestMapping("admin/post")
public class PostController {

    @Autowired
    PostService service;

    @ResponseBody
    @RequestMapping("all")
    public JsonResponse all() {
        JsonResponse response = new JsonResponse();
        JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
        ArrayNode arrayNode = new ArrayNode(jsonFactory);
        try {
            List<Post> posts = service.all();
            for (Post post : posts) {
                ObjectNode node = JsonHelper.createJson(post, jsonFactory, new String[]{"*", "estadoEnum.*", "areaTrabajo.*", "ubicacionTrabajo.*"});
                arrayNode.add(node);
            }
            response.setData(arrayNode);
            response.setTotal(posts.size());
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
    public JsonResponse save(@RequestBody Post post) {
        JsonResponse response = new JsonResponse();
        try {
            response.setMessage(CREATE);
            Post newPost = service.save(post);
            response.setSuccess(Boolean.TRUE);
            response.setData(newPost);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("update")
    public JsonResponse update(@RequestBody Post post) {
        JsonResponse response = new JsonResponse();
        try {
            response.setMessage(UPDATE);
            Post updaPost = service.update(post);
            response.setSuccess(Boolean.TRUE);
            response.setData(updaPost);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("delete")
    public JsonResponse delete(@RequestBody Post post) {
        JsonResponse response = new JsonResponse();
        try {
            Post delPost = service.delete(post);
            response.setMessage(DELETE);
            response.setSuccess(Boolean.TRUE);
            response.setData(delPost);
        } catch (PhobosException ex) {
            ExceptionHandler.handleException(ex, response);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, response);
        }
        return response;
    }

}
