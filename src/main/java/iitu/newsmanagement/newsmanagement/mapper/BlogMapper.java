package iitu.newsmanagement.newsmanagement.mapper;

import iitu.newsmanagement.newsmanagement.dto.BlogDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Blog;
import iitu.newsmanagement.newsmanagement.repository.AuthorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogMapper {
    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    @Mapping(source = "author.id", target = "authorId")
    BlogDto blogToBlogDto(Blog blog);

    @Mapping(target = "author", expression = "java(mapToAuthor(blogDto, authorRepository))")
    Blog blogDtoToBlog(BlogDto blogDto, AuthorRepository authorRepository);

    default Author mapToAuthor(BlogDto blogDto, AuthorRepository authorRepository) {
        return authorRepository.findById(blogDto.getAuthorId()).orElse(null);
    }
}
