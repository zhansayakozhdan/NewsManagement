package iitu.newsmanagement.newsmanagement.mapper;

import iitu.newsmanagement.newsmanagement.dto.AuthorDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    // Convert Author entity to AuthorDto
    AuthorDto authorToAuthorDto(Author author);

    // Convert AuthorDto to Author entity
    Author authorDtoToAuthor(AuthorDto authorDto);
}
