package iitu.newsmanagement.newsmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "TAGS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TAGS_BLOGS",  // Name of the join table
            joinColumns = @JoinColumn(name = "TAG_ID"),  // Column in the join table referencing the TAGS table
            inverseJoinColumns = @JoinColumn(name = "BLOG_ID")  // Column in the join table referencing the BLOGS table
    )
    private List<Blog> blogs;
}
