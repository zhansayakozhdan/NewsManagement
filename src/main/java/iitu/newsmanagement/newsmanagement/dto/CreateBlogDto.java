package iitu.newsmanagement.newsmanagement.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBlogDto {
    private String title;
    private String content;
    private Integer authorId;
}
