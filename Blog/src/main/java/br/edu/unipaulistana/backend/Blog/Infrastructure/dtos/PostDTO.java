package br.edu.unipaulistana.backend.Blog.Infrastructure.dtos;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private  long id;

    @NotBlank(message = "Titulo é Obrigatorio")
    @Size(max = 100 , message = "O titulo deve conter no máximo 100 caracteres")
    private String title;

    @NotBlank(message = "Content é Obrigatorio")
    @Size(max = 100 , message = "O content deve conter no máximo 100 caracteres")
    private String content;

    //metodos de conversao(static)

    public static PostDTO fromEntity (Post post){
        if (post == null){
            return null;
        }
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }
    public static Post toEntity(PostDTO dto){
        if (dto == null){
            return null;
        }
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return post;
    }

}
