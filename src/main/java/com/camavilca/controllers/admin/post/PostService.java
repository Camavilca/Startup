package com.camavilca.controllers.admin.post;

import com.camavilca.model.admin.Post;
import java.util.List;

public interface PostService {

    List<Post> all();

    Post save(Post post);

    Post update(Post post);

    Post delete(Post post);

}
