package iitu.newsmanagement.newsmanagement.service;

import iitu.newsmanagement.newsmanagement.dto.AuthorBlogCountDto;
import iitu.newsmanagement.newsmanagement.dto.AuthorDto;
import iitu.newsmanagement.newsmanagement.dto.BlogDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Blog;
import iitu.newsmanagement.newsmanagement.exception.ResourceNotFoundException;
import iitu.newsmanagement.newsmanagement.mapper.BlogMapper;
import iitu.newsmanagement.newsmanagement.repository.AuthorRepository;
import iitu.newsmanagement.newsmanagement.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;  // Injecting AuthorMapper

    public List<AuthorDto> findAll() {
        log.info("Fetching all authors");
        return authorRepository.findAll().stream()
                .map(authorMapper::authorToAuthorDto)  // Using the mapper to convert to AuthorDto
                .collect(Collectors.toList());
    }


    public AuthorDto getAuthorDtoById(Integer id) {
        log.info("Fetching author dto by ID: {}", id);
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for ID: " + id));
        return authorMapper.authorToAuthorDto(author);  // Using the mapper to convert to AuthorDto
    }

    public Author getAuthorById(Integer id) {
        log.info("Fetching author by ID: {}", id);
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for ID: " + id));
    }


    public AuthorDto addAuthor(AuthorDto authorDto) {
        log.info("Adding new author: {}", authorDto.getFullName());
        Author author = authorMapper.authorDtoToAuthor(authorDto);  // Convert DTO to entity
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.authorToAuthorDto(savedAuthor);  // Convert entity to DTO
    }


    public AuthorDto updateAuthor(AuthorDto authorDto) {
        log.info("Updating author with ID: {}", authorDto.getId());
        if (!authorRepository.existsById(authorDto.getId())) {
            throw new ResourceNotFoundException("Author not found for ID: " + authorDto.getId());
        }
        Author author = authorMapper.authorDtoToAuthor(authorDto);  // Convert DTO to entity
        Author updatedAuthor = authorRepository.save(author);
        return authorMapper.authorToAuthorDto(updatedAuthor);  // Convert entity to DTO
    }


    public void deleteAuthor(Integer id) {
        log.info("Deleting author with ID: {}", id);
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found for ID: " + id);
        }
        authorRepository.deleteById(id);
    }

    public List<AuthorBlogCountDto> getAuthorsWithBlogCounts() {
        log.info("Fetching authors with their blog counts.");
        return authorRepository.findAuthorsWithBlogCounts();
    }


    //searching
    public List<Author> searchAuthorsByName(String query) {
        log.info("Searching for authors with query {}", query);
        List<Author> authors = authorRepository.searchAuthorsByName(query);
        return authors;
    }
}
