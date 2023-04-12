package edu.comillas.icai.gitt.pat.spring.mvc.rest;

import edu.comillas.icai.gitt.pat.spring.mvc.seguridad.ConfiguracionSeguridad;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ControladorRest.class)
@Import(ConfiguracionSeguridad.class)
class ControladorRestIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    void creaContadorOkTest() throws Exception {
        String contador = "{\"nombre\":\"visitas\",\"valor\":0}";
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/contadores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contador))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(contador));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void creaContadorIncorrectoTest() throws Exception {
        String contador = "{\"nombre\":\"\",\"valor\":0}";
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/contadores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contador))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(
                        "[{\"error\":\"must not be blank\",\"campo\":\"nombre\",\"valor\":\"\"}]"
                ));
    }
}