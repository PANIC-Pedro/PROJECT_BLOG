package br.edu.unipaulistana.backend.Blog.Infrastructure.dtos;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
   private long id ;

   @NotBlank(message = "É obrigatorio ter uma biografia")
    @Size(max = 500 , message = "A biografia contem no máximo 500 caracteres")
    private String bio;

   @NotBlank(message = "É obrigatorio ter uma foto")
    private String pictureURL;

   public static ProfileDTO fromEntity(Profile profile){
       if (profile == null ){
           return null;
       }
       ProfileDTO dto = new ProfileDTO();
       dto.setId(profile.getId());
       dto.setBio(profile.getBio());
       dto.setPictureURL(profile.getPictureURL());
       return dto;
   }
   public static Profile toEntity(ProfileDTO dto){
       if(dto == null ){
           return null;
       }
       Profile profile = new Profile();
       profile.setId(dto.getId());
       profile.setBio(dto.getBio());
       profile.setPictureURL(dto.getPictureURL());
       return profile;
   }

}
