package iitu.newsmanagement.newsmanagement.mapper;

import iitu.newsmanagement.newsmanagement.dto.AuthorDto;
import iitu.newsmanagement.newsmanagement.dto.TagDto;
import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Tag;
import org.mapstruct.factory.Mappers;

public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    // Convert Author entity to AuthorDto
    TagDto tagToTagDto(Tag tag);

    // Convert AuthorDto to Author entity
    Tag tagDtoToTag(TagDto tagDto);
}
