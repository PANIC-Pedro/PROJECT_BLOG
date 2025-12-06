/*package br.edu.unipaulistana.backend.Blog.controller;

import br.edu.unipaulistana.backend.Blog.Controller.TagController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TagControllerIntegrationTest {
    @Autowired
    private TagController tagController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Fluxo completo: POST -> GET ALL -> GET-BY-ID -> PUT -> PATH -> GET -> ERROR404")
    public void fullFlow() throws Exception{
        long id = new Random().nextLong();
        var bodyCreate = new Tag(id, "Neymar", null);
        var postResult = mockMvc.perform(
               post("/api/tags")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(objectMapper.writeValueAsString(bodyCreate)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id",is(id)))
                .andExpect(jsonPath("$.name", is("Neymar")))
                .andReturn();
        var created = objectMapper.readValue(postResult.getResponse().getContentAsByteArray(), Tag.class),
        var returnedId = created.getId();
    }






}
*/