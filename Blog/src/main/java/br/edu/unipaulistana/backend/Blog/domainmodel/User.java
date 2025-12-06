package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_users", indexes = {@Index(name="IDX_EMAIL_PASSWORD" ,columnList = "email,password"),
@Index(name="IDX_EMAIL",columnList = "email"),
@Index(name = "IDX_PASSWORD",columnList = "password")
})
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false)
    private @Getter @Setter UUID id;

    @Column(name = "NAME", nullable = false)
    private @Getter @Setter String name;

    @Column(name = "EMAIL", nullable = false,length = 60)
    private @Getter @Setter String email;

    @Column(name = "PASSWORD", nullable = false, length = 70)
    private @Getter @Setter String password;

    @ManyToMany
    private @Getter @Setter Set<Role> roles;

    @OneToOne
    private @Getter @Setter Profile profile;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name ;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
