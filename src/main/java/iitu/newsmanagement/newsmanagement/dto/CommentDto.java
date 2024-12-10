package iitu.newsmanagement.newsmanagement.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Integer id;
    private String content;
    private Integer blogId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}