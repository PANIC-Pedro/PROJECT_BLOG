package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    private @Getter @Setter long id ;

    @Column(name="BIO", nullable = false)
    private @Getter @Setter String bio;

    @Column(name="PICTUREURL", nullable = false)
    private @Getter @Setter String pictureURL;

    @OneToOne
    private @Getter @Setter User user;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
