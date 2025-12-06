package br.edu.unipaulistana.backend.Blog.controller;

//import br.edu.unipaulistana.backend.Blog.Controller.UserController;
//import br.edu.unipaulistana.backend.Blog.domainmodel.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;

//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.util.UUID;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class UserControllerIntegrationTest {
  //  @Autowired
    //private UserController userController;

    //@Autowired
   //private MockMvc mockMvc;

    //@Autowired
    //private ObjectMapper objectMapper;

    //@Test
    //@DisplayName("Fluxo completo: POST-> GET ALL -> GET-BY-ID -> PUT -> PATH-> GET->ERROR404")
    //public void fullFlow() throws Exception {
      //  UUID id = UUID.randomUUID();
        //var bodyCreate = new User(id,"Neymar","neymarJR@gmail.com","neymarJR11",null,null);
        //var postResult = mockMvc.perform(
          //      post("/api/users")
            //            .contentType(MediaType.APPLICATION_JSON)
              //          .content(objectMapper.writeValueAsString(bodyCreate)))
                //        .andExpect(status().isCreated())
                  //      .andExpect(jsonPath("$.id",is(id)))
                    //    .andExpect(jsonPath("$.name",is("Neymar")))
                      //  .andReturn();

        //var created = objectMapper.readValue(postResult.getResponse().getContentAsByteArray(), User.class);
        //var returnedID = created.getId();




  // }

//}
