package iitu.newsmanagement.newsmanagement.controller;

import iitu.newsmanagement.newsmanagement.dto.AuthorBlogCountDto;
import iitu.newsmanagement.newsmanagement.dto.AuthorDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Tag;
import iitu.newsmanagement.newsmanagement.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer id) {
        AuthorDto authorDto = authorService.getAuthorDtoById(id);
        return new ResponseEntity<>(authorDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto createdAuthor = authorService.addAuthor(authorDto);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Integer id, @RequestBody AuthorDto authorDto) {
        authorDto.setId(id);
        AuthorDto updatedAuthor = authorService.updateAuthor(authorDto);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/blog-counts")
    public ResponseEntity<List<AuthorBlogCountDto>> getAuthorsWithBlogCounts() {
        List<AuthorBlogCountDto> authorsWithBlogCounts = authorService.getAuthorsWithBlogCounts();
        return ResponseEntity.ok(authorsWithBlogCounts);
    }


    //searching...
    @GetMapping("/search")
    public List<Author> searchAuthorsByName(@RequestParam("query") String query) {
        return authorService.searchAuthorsByName(query);
    }
}
