package iitu.newsmanagement.newsmanagement.controller;

import iitu.newsmanagement.newsmanagement.dto.CommentDto;
import iitu.newsmanagement.newsmanagement.entity.Comment;
import iitu.newsmanagement.newsmanagement.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Integer id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public Comment addComment(@RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Integer id, @RequestBody CommentDto commentDto) {
        commentDto.setId(id);
        return commentService.updateComment(commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }

    @GetMapping("/by-blog/{blogId}")
    public ResponseEntity<List<CommentDto>> getCommentsByBlogId(@PathVariable Integer blogId) {
        List<CommentDto> comments = commentService.getCommentByBlogId(blogId);
        return new ResponseEntity<>(comments, HttpStatus.OK);  // Return the list of comments with HTTP 200 OK
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Comment>> getSortedComments(
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        List<Comment> comments = commentService.getSortedComments(sortBy, direction);
        return ResponseEntity.ok(comments);
    }
}
