package iitu.newsmanagement.newsmanagement.repository;

import iitu.newsmanagement.newsmanagement.entity.Blog;
import iitu.newsmanagement.newsmanagement.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findByBlogsId(Integer blogId);

    @Query("SELECT t FROM Tag t "
            + "WHERE t.name ilike concat('%', :search, '%')")
    List<Tag> searchTagsByName(String search);
}
