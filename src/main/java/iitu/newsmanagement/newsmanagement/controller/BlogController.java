package iitu.newsmanagement.newsmanagement.controller;


import iitu.newsmanagement.newsmanagement.dto.BlogDto;
import iitu.newsmanagement.newsmanagement.dto.CreateBlogDto;
import iitu.newsmanagement.newsmanagement.entity.Blog;
import iitu.newsmanagement.newsmanagement.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public List<BlogDto> getAllNews() {
        return blogService.getAllBlogs();
    }

    @GetMapping("{id}")
    public Blog getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id);
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
}
