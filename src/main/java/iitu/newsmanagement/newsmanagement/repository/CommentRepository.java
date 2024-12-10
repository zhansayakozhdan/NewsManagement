package iitu.newsmanagement.newsmanagement.repository;

import iitu.newsmanagement.newsmanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

//    @Query("SELECT c FROM Comment c WHERE c.blog.id = :blogId")
//    List<Comment> findAllCommentsByBlog(Integer blogId);

    List<Comment> findByBlogId(Integer blogId);
}
