package iitu.newsmanagement.newsmanagement.service;

import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).orElseThrow();
    }
}
