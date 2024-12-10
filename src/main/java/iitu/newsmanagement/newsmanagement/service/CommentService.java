package iitu.newsmanagement.newsmanagement.service;

import iitu.newsmanagement.newsmanagement.dto.CommentDto;
import iitu.newsmanagement.newsmanagement.entity.Comment;
import iitu.newsmanagement.newsmanagement.exception.ResourceNotFoundException;
import iitu.newsmanagement.newsmanagement.mapper.CommentMapper;
import iitu.newsmanagement.newsmanagement.repository.BlogRepository;
import iitu.newsmanagement.newsmanagement.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public Comment addComment(CommentDto commentDto) {
        log.info("Adding new comment for blog ID: {}", commentDto.getBlogId());
        blogRepository.findById(commentDto.getBlogId())
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found for ID: " + commentDto.getBlogId()));

        Comment comment = CommentMapper.INSTANCE.commentDtoToComment(commentDto, blogRepository);
        return commentRepository.save(comment);
    }

    public CommentDto getCommentById(Integer id) {
        log.info("Fetching comment by ID: {}", id);
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for ID: " + id));
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    public List<CommentDto> getCommentByBlogId(Integer blogId) {
        log.info("Fetching comments for blog ID: {}", blogId);
        return commentRepository.findByBlogId(blogId)
                .stream()
                .map(CommentMapper.INSTANCE::commentToCommentDto)
                .collect(Collectors.toList());
    }

    public Comment updateComment(CommentDto commentDto) {
        log.info("Updating comment ID: {}", commentDto.getId());
        Comment existingComment = commentRepository.findById(commentDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for ID: " + commentDto.getId()));

        existingComment.setContent(commentDto.getContent());
        return commentRepository.save(existingComment);
    }

    public void deleteComment(Integer id) {
        log.info("Deleting comment by ID: {}", id);
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comment not found for ID: " + id);
        }
        commentRepository.deleteById(id);
    }


    public List<Comment> getSortedComments(String sortBy, String direction) {
        log.info("Fetching comments sorted by {} in {} order.", sortBy, direction);

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return commentRepository.findAll(sort);
    }

}
