package iitu.newsmanagement.newsmanagement.controller;


import iitu.newsmanagement.newsmanagement.dto.BlogDto;
import iitu.newsmanagement.newsmanagement.dto.CommentDto;
import iitu.newsmanagement.newsmanagement.dto.CreateBlogDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Blog;
import iitu.newsmanagement.newsmanagement.entity.Tag;
import iitu.newsmanagement.newsmanagement.service.BlogService;
import iitu.newsmanagement.newsmanagement.service.CommentService;
import iitu.newsmanagement.newsmanagement.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class BlogController {
    private final BlogService blogService;
    private final CommentService commentService;
    private final TagService tagService;

    @GetMapping
    public List<BlogDto> getAllNews() {
        return blogService.getAllBlogs();
    }

    @GetMapping("{id}")
    public Blog getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id);
    }

    @GetMapping("/{blogId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByBlogId(@PathVariable Integer blogId) {
        List<CommentDto> comments = commentService.getCommentByBlogId(blogId);
        return new ResponseEntity<>(comments, HttpStatus.OK);  // Return the list of comments with HTTP 200 OK
    }

    @GetMapping("/{blogId}/tags")
    public ResponseEntity<List<Tag>> getTagsByBlogId(@PathVariable Integer blogId) {
        List<Tag> tags = tagService.getTagsByBlogId(blogId);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/{blogId}/author")
    public ResponseEntity<Author> getAuthorsByBlogId(@PathVariable Integer blogId) {
        Author author = blogService.getAuthorByBlogId(blogId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public BlogDto createBlog(@RequestBody CreateBlogDto createBlogDto) {
        return blogService.createBlog(createBlogDto);
    }

    @PutMapping
    public BlogDto updateBlog(@RequestBody Blog blog) {
        return blogService.updateBlog(blog);
    }

    @DeleteMapping
    public void deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
    }


    //searching...
    @GetMapping("/search")
    public List<BlogDto> searchBlogs(@RequestParam("query") String query) {
        return blogService.searchBlogs(query);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Blog>> getSortedBlogs(
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        List<Blog> blogs = blogService.getBlogsSorted(sortBy, direction);
        return ResponseEntity.ok(blogs);
    }

}
