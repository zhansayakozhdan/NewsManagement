package iitu.newsmanagement.newsmanagement.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorBlogCountDto {
    private String authorName;
    private Long blogCount;
}
