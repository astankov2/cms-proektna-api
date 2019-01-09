package mk.ukim.finki.wp.cmsproektnaapi.web.rest;

import mk.ukim.finki.wp.cmsproektnaapi.exceptions.PostNotFoundException;
import mk.ukim.finki.wp.cmsproektnaapi.persistence.Post;
import mk.ukim.finki.wp.cmsproektnaapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostResource {
    PostService postService;

    @Autowired
    PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(value = "/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping(value = "/")
    public Post createPost(@RequestBody Post post) {
        return postService.addNew(post);
    }

    @PatchMapping(value = "/")
    public Post updatePost(@RequestBody Post post) throws PostNotFoundException {
        return postService.updatePost(post);
    }

    @DeleteMapping(value = "/{id}")
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePostById(id);
    }
}
