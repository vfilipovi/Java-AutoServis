package hr.tvz.zuti.autoservis.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class MjestoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createNewMjesto() throws Exception {

        String TEST_NAZIV_MJESTA = "Testno mjesto";

        Mjesto mjesto = new Mjesto();
        mjesto.setNazivMjesta(TEST_NAZIV_MJESTA);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(mjesto);

        this.mockMvc.perform(
                post("/api/v1/mjesta")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nazivMjesta").value(TEST_NAZIV_MJESTA));
    }

    @Test
    void getMjestoById() throws Exception {
        int TEST_ID = 1;
        String TEST_NAZIV_MJESTA = "Zagreb";

        this.mockMvc.perform(
                get("/api/v1/mjesta/{mjestoId}", TEST_ID)
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(TEST_ID))
                .andExpect(jsonPath("$.nazivMjesta").value(TEST_NAZIV_MJESTA));
    }

    @Test
    void getAllMjesta() throws Exception {
        this.mockMvc.perform(
                get("/api/v1/mjesta")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4))); // 5 + 1 SA NOVIM KVAROM
    }

    @Test
    void updateMjestoById() throws Exception {
        int TEST_ID = 3;
        String TEST_UPDATE_NAZIV_MJESTA = "Split update test";

        Mjesto updatedMjesto = new Mjesto();
        updatedMjesto.setNazivMjesta(TEST_UPDATE_NAZIV_MJESTA);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(updatedMjesto);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/v1/mjesta/{mjestoId}", TEST_ID)
                .with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                )
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(TEST_ID))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nazivMjesta").value(TEST_UPDATE_NAZIV_MJESTA));
    }

    @Test
    void deleteMjestoById() throws Exception {
        int TEST_ID = 5;

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/mjesta/{mjestoId}", TEST_ID)
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isNoContent());
    }
}
