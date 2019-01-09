package mk.ukim.finki.wp.cmsproektnaapi.service.impl;

import mk.ukim.finki.wp.cmsproektnaapi.exceptions.PostNotFoundException;
import mk.ukim.finki.wp.cmsproektnaapi.persistence.Post;
import mk.ukim.finki.wp.cmsproektnaapi.persistence.repository.PostRepository;
import mk.ukim.finki.wp.cmsproektnaapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() { return postRepository.findAllByOrderByDateDesc(); }

    @Override
    public Post getPostById(Long id) {
        return postRepository.getPostById(id);
    }

    @Override
    public Post addNew(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Long deletePostById(Long id) {
        return postRepository.deletePostById(id);
    }

    @Override
    public Post updatePost(Post newPost) throws PostNotFoundException {
        Post post = postRepository.getOne(newPost.id);
        if (post == null) {
            throw new PostNotFoundException();
        }

        return postRepository.save(newPost);
    }
}
