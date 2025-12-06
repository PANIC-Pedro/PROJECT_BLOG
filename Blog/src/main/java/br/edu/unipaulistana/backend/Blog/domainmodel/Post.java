package br.edu.unipaulistana.backend.Blog.domainmodel;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="ID", nullable = false)
    private @Getter @Setter long id ;

    @Column(name="TITLE", nullable = false)
    private @Getter @Setter String title;

    @Column(name="CONTENT", nullable = false)
    private @Getter @Setter String content;

    @ManyToOne
    private @Getter @Setter User user;

    @ManyToMany
    private @Getter @Setter Set<Tag> tag;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
