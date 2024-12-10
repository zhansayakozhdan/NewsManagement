package iitu.newsmanagement.newsmanagement.repository;

import iitu.newsmanagement.newsmanagement.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("SELECT b FROM Blog b "
            + "WHERE b.title ilike concat('%', :search, '%') "
            + "OR b.content ilike concat('%', :search, '%') "
            + "OR b.author.fullName ilike concat('%', :search, '%') ")
    List<Blog> searchBlogs(String search);


}
