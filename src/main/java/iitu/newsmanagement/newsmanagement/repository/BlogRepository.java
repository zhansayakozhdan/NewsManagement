package iitu.newsmanagement.newsmanagement.repository;

import iitu.newsmanagement.newsmanagement.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
