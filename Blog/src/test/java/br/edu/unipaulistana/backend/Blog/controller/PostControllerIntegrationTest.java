package br.edu.unipaulistana.backend.Blog.controller;

/*
import br.edu.unipaulistana.backend.Blog.Controller.PostController;
import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest("(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)")
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private PostController postController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("FLUXO COMPLETO: POST -> GET ALL -> GET-BY-ID -> PUT -> PATH -> PATH -> GET ->ERROR404 ")
     public void fullFlow() throws Exception{
     long id = Random().nextLong;
        var bodyCreate = new Post(id,"HARRY POTTER", "MAGIA","Neymar",null);
        var postResult = mockMvc.perform(
                post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bodyCreate)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id"), is(id)))
                .andExpect(jsonPath("$.title", is("HARRY POTTER")))
                .andReturn();

        var created = objectMapper.readValue(postResult.getResponse().getContentAsByteArray(), Post.class);
        var returnedID = created.getId();
    }

}
*/