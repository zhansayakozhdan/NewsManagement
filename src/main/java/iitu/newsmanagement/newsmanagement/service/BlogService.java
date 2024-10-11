package iitu.newsmanagement.newsmanagement.service;

import iitu.newsmanagement.newsmanagement.dto.BlogDto;
import iitu.newsmanagement.newsmanagement.dto.CreateBlogDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Blog;
import iitu.newsmanagement.newsmanagement.mapper.BlogMapper;
import iitu.newsmanagement.newsmanagement.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {
    private final BlogRepository blogRepository;
    private final AuthorService authorService;

    public List<BlogDto> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        List<BlogDto> blogDtoList = new ArrayList<>();

        for(Blog blog : blogs) {
            BlogDto blogDto = new BlogDto();
            blogDto.setId(blog.getId());
            blogDto.setTitle(blog.getTitle());
            blogDto.setContent(blog.getContent());
            blogDto.setAuthorId(blog.getAuthor().getId());
            blogDtoList.add(blogDto);
        }
        return blogDtoList;
    }

    public Blog getBlogById(Integer id) {
        Blog blog = blogRepository.findById(id).orElseThrow();
        return blog;
    }

    public BlogDto createBlog(CreateBlogDto createBlogDto) {
        Author author = authorService.getAuthorById(createBlogDto.getAuthorId());
        Blog blog = new Blog();
        blog.setTitle(createBlogDto.getTitle());
        blog.setContent(createBlogDto.getContent());
        blog.setAuthor(author);

        Blog savedBlog = blogRepository.save(blog);
        return BlogMapper.INSTANCE.blogToBlogDto(savedBlog);
    }

    public BlogDto updateBlog(Blog blog) {
        Blog saved = blogRepository.findById(blog.getId()).orElseThrow();
        Blog updatedBlog = blogRepository.save(blog);
        return BlogMapper.INSTANCE.blogToBlogDto(updatedBlog);
    }

    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }
}
