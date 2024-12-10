package iitu.newsmanagement.newsmanagement.repository;

import iitu.newsmanagement.newsmanagement.dto.AuthorBlogCountDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("SELECT new iitu.newsmanagement.newsmanagement.dto.AuthorBlogCountDto(a.fullName, COUNT(b)) " +
            "FROM Author a LEFT JOIN Blog b ON a.id = b.author.id " +
            "GROUP BY a.id, a.fullName")
    List<AuthorBlogCountDto> findAuthorsWithBlogCounts();

    @Query("SELECT a FROM Author a "
            + "WHERE a.fullName ilike concat('%', :search, '%') ")
    List<Author> searchAuthorsByName(String search);
}
