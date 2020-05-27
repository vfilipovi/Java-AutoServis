package hr.tvz.zuti.autoservis.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.zuti.autoservis.domain.Kvar;
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

@SpringBootTest
@AutoConfigureMockMvc
public class KvarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createNewKvar() throws Exception {

        String TEST_NAZIV_KVARA = "Promjena mjenjaca";
        String TEST_OPIS_KVARA = "Kvar mjenjaca";

        Kvar kvar = new Kvar();
        kvar.setNazivKvara(TEST_NAZIV_KVARA);
        kvar.setOpisKvara(TEST_OPIS_KVARA);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(kvar);

        this.mockMvc.perform(
                post("/api/v1/kvarovi")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8")
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nazivKvara").value(TEST_NAZIV_KVARA))
                .andExpect(jsonPath("$.opisKvara").value(TEST_OPIS_KVARA));
    }

    @Test
    void getKvarById() throws Exception {
        int TEST_ID = 2;
        String TEST_NAZIV_KVARA = "Zamjena ulja Peugeot";
        String TEST_OPIS_KVARA = "brzi serivs ulja Peugeot";

        this.mockMvc.perform(
                get("/api/v1/kvarovi/{kvarId}", TEST_ID)
                        .characterEncoding("utf-8")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(TEST_ID))
                .andExpect(jsonPath("$.nazivKvara").value(TEST_NAZIV_KVARA))
                .andExpect(jsonPath("$.opisKvara").value(TEST_OPIS_KVARA));
    }

    @Test
    void getAllKvarovi() throws Exception {
        this.mockMvc.perform(
                get("/api/v1/kvarovi")
                        .characterEncoding("utf-8")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(7))); // 6 + 1 SA NOVIM KVAROM
    }

    @Test
    void updateKvarById() throws Exception
    {
        int TEST_ID = 1;
        String TEST_UPDATE_NAZIV_KVARA = "Zamjena turbo motora";
        String TEST_UPDATE_OPIS_KVARA = "Opsežan popravak";

        Kvar updatedKvar = new Kvar();
        updatedKvar.setNazivKvara(TEST_UPDATE_NAZIV_KVARA);
        updatedKvar.setOpisKvara(TEST_UPDATE_OPIS_KVARA);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(updatedKvar);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/v1/kvarovi/{kvarId}", TEST_ID)
                .with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                )
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(TEST_ID))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nazivKvara").value(TEST_UPDATE_NAZIV_KVARA))
                .andExpect(MockMvcResultMatchers.jsonPath("$.opisKvara").value(TEST_UPDATE_OPIS_KVARA));
    }
}
