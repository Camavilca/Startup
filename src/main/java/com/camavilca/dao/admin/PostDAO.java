package com.camavilca.dao.admin;

import com.camavilca.model.admin.Post;
import java.util.List;
import pe.albatross.octavia.easydao.EasyDAO;

public interface PostDAO extends EasyDAO<Post> {

    List<Post> fullAll();

}
