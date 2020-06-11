package com.camavilca.dao.admin.hibernate;

import com.camavilca.dao.admin.PostDAO;
import com.camavilca.model.admin.Post;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.Octavia;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class PostDAOH extends AbstractEasyDAO<Post> implements PostDAO {

    public PostDAOH() {
        super();
        setClazz(Post.class);
    }

    @Override
    public List<Post> fullAll() {
        Octavia sql = Octavia.query()
                .from(Post.class, "p")
                .join("areaTrabajo at", "ubicacionTrabajo ut");
        return all(sql);
    }

}
