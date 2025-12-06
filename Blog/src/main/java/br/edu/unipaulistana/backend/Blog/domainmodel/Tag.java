package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false)
    private @Getter @Setter long id;

    @Column(name = "NAME",nullable = false)
    private @Getter @Setter String name;

    @ManyToMany
    private @Getter @Setter Set<Post> posts;

}
