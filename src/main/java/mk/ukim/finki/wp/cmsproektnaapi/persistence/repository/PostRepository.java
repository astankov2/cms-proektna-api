package mk.ukim.finki.wp.cmsproektnaapi.persistence.repository;

import mk.ukim.finki.wp.cmsproektnaapi.persistence.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByDateDesc();
    Post getPostById(Long id);
    Long deletePostById(Long id);
}
