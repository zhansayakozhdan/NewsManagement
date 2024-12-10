package iitu.newsmanagement.newsmanagement.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private Integer id;
    private String fullName;
}
