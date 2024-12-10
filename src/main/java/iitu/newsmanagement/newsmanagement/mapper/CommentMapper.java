package iitu.newsmanagement.newsmanagement.mapper;

import iitu.newsmanagement.newsmanagement.dto.CommentDto;
import iitu.newsmanagement.newsmanagement.entity.Blog;
import iitu.newsmanagement.newsmanagement.entity.Comment;
import iitu.newsmanagement.newsmanagement.repository.BlogRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    // Mapping from Comment entity to CommentDto
    @Mapping(source = "blog.id", target = "blogId")
    CommentDto commentToCommentDto(Comment comment);

    // Mapping from CommentDto to Comment entity, using mapToBlog to resolve the blog
    @Mapping(target = "blog", expression = "java(mapToBlog(commentDto, blogRepository))")
    Comment commentDtoToComment(CommentDto commentDto, BlogRepository blogRepository);

    // Custom method to map blogId to Blog entity
    default Blog mapToBlog(CommentDto commentDto, BlogRepository blogRepository) {
        return blogRepository.findById(commentDto.getBlogId()).orElse(null); // or handle appropriately
    }
}
