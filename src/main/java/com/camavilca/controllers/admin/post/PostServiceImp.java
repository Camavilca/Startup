package com.camavilca.controllers.admin.post;

import com.camavilca.dao.admin.PostDAO;
import com.camavilca.model.admin.Post;
import com.camavilca.model.security.Usuario;
import com.camavilca.zelper.enums.EstadoEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostServiceImp implements PostService {

    @Autowired
    PostDAO postDAO;

    @Override
    public List<Post> all() {
        return postDAO.fullAll();
    }

    @Override
    @Transactional
    public Post save(Post post) {
        Post newpost = new Post();
        newpost.setDescripcion(post.getDescripcion());
        newpost.setEstadoEnum(EstadoEnum.ACT);
        newpost.setFechaInicio(post.getFechaInicio());
        newpost.setFechaFin(post.getFechaFin());
        newpost.setTitulo(post.getTitulo());
        newpost.setUrl(post.getUrl());
        newpost.setUsuario(new Usuario(1));
        newpost.setAreaTrabajo(post.getAreaTrabajo());
        newpost.setUbicacionTrabajo(post.getUbicacionTrabajo());
        postDAO.save(newpost);
        return post;
    }

    @Override
    @Transactional
    public Post update(Post post) {
        postDAO.update(post);
        return post;
    }

    @Override
    @Transactional
    public Post delete(Post post) {
        postDAO.delete(post);
        return post;
    }

}
