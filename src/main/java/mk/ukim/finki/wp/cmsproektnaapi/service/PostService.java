package mk.ukim.finki.wp.cmsproektnaapi.service;

import mk.ukim.finki.wp.cmsproektnaapi.exceptions.PostNotFoundException;
import mk.ukim.finki.wp.cmsproektnaapi.persistence.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post addNew(Post post);
    Long deletePostById(Long id);
    Post updatePost(Post newPost) throws PostNotFoundException;
}
