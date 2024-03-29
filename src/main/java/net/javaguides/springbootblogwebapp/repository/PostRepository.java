package net.javaguides.springbootblogwebapp.repository;

import net.javaguides.springbootblogwebapp.dto.PostDto;
import net.javaguides.springbootblogwebapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByUrl(String url);

    @Query("SELECT p from Post p where " +
            "p.title LIKE CONCAT('%',:query,'%') OR " +
            "p.shortDescription LIKE CONCAT('%',:query,'%')"

    )
    List<Post> searchPosts(String query);
}
