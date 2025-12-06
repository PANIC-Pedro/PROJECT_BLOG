package br.edu.unipaulistana.backend.Blog.Infrastructure.dtos;

import br.edu.unipaulistana.backend.Blog.domainmodel.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDTO {
    private long id ;

    @NotBlank(message = "O nome é obrigatorio")
    @Size(max = 100 , message = "O nome contem no máximo 100 caracteres")
    private String name;

    public static TagDTO fromEntity(Tag tag){
        if(tag == null){
            return null;
        }
        TagDTO dto = new TagDTO();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }
    public static Tag toEntity (TagDTO dto){
        if(dto == null ){
            return null;
        }
        Tag tag = new Tag();
        tag.setId(dto.getId());
        tag.setName(dto.getName());
        return tag;

    }

}
