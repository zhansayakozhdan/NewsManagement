package iitu.newsmanagement.newsmanagement.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDto {
    private Integer id;
    private String title;
    private String content;
    private Integer authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
