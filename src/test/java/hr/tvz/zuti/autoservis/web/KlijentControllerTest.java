package hr.tvz.zuti.autoservis.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class KlijentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createNewKlijent() throws Exception {

        String TEST_IME = "Testno ime";
        String TEST_PREZIME = "Testno prezime";
        String TEST_OIB = "01234567899";
        String TEST_BROJ_MOB = "0123456789";
        String TEST_EMAIL = "test@email.com";

        String TEST_NAZIV_MJESTA = "Zagreb";
        int TEST_MJESTO_ID = 1;

        Mjesto mjesto = new Mjesto();
        mjesto.setId(TEST_MJESTO_ID);
        mjesto.setNazivMjesta(TEST_NAZIV_MJESTA);

        Klijent klijent = new Klijent();
        klijent.setIme(TEST_IME);
        klijent.setPrezime(TEST_PREZIME);
        klijent.setOib(TEST_OIB);
        klijent.setBrojMob(TEST_BROJ_MOB);
        klijent.setEmail(TEST_EMAIL);
        klijent.setMjesto(mjesto);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(klijent);

        this.mockMvc.perform(
                post("/api/v1/klijenti")
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
                .andExpect(jsonPath("$.ime").value(TEST_IME))
                .andExpect(jsonPath("$.prezime").value(TEST_PREZIME))
                .andExpect(jsonPath("$.oib").value(TEST_OIB))
                .andExpect(jsonPath("$.brojMob").value(TEST_BROJ_MOB))
                .andExpect(jsonPath("$.email").value(TEST_EMAIL))
                .andExpect(jsonPath("$.mjesto.id").value(TEST_MJESTO_ID))
                .andExpect(jsonPath("$.mjesto.nazivMjesta").value(TEST_NAZIV_MJESTA));
    }

    @Test
    void getKlijentById() throws Exception {
        int TEST_ID = 1;
        String TEST_IME = "Filip";
        String TEST_PREZIME = "Vučemilovič-Grgić";
        String TEST_OIB = "01234567890";
        String TEST_BROJ_MOB = "0123456789";
        String TEST_EMAIL = "fvucemilo@tvz.hr";
        String TEST_NAZIV_MJESTA = "Zagreb";
        int TEST_MJESTO_ID = 1;

        this.mockMvc.perform(
                get("/api/v1/klijenti/{klijentId}", TEST_ID)
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
                .andExpect(jsonPath("$.ime").value(TEST_IME))
                .andExpect(jsonPath("$.prezime").value(TEST_PREZIME))
                .andExpect(jsonPath("$.oib").value(TEST_OIB))
                .andExpect(jsonPath("$.brojMob").value(TEST_BROJ_MOB))
                .andExpect(jsonPath("$.email").value(TEST_EMAIL))
                .andExpect(jsonPath("$.mjesto.id").value(TEST_MJESTO_ID))
                .andExpect(jsonPath("$.mjesto.nazivMjesta").value(TEST_NAZIV_MJESTA));
    }

    @Test
    void getAllKlijenti() throws Exception {
        this.mockMvc.perform(
                get("/api/v1/klijenti")
                        .characterEncoding("utf-8")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(5))); // 5 + 1 SA NOVIM KVAROM
    }

    @Test
    void updateKvarById() throws Exception {
        int TEST_UPDATE_ID = 1;
        String TEST_UPDATE_IME = "Testno ime update";
        String TEST_UPDATE_PREZIME = "Testno prezime update";
        String TEST_UPDATE_OIB = "01234567000";
        String TEST_UPDATE_BROJ_MOB = "0123456789";
        String TEST_UPDATE_EMAIL = "test2@email.com";

        String TEST_UPDATE_NAZIV_MJESTA = "Zagreb";
        int TEST_UPDATE_MJESTO_ID = 1;

        Mjesto mjesto = new Mjesto();
        mjesto.setId(TEST_UPDATE_MJESTO_ID);
        mjesto.setNazivMjesta(TEST_UPDATE_NAZIV_MJESTA);

        Klijent klijent = new Klijent();
        klijent.setIme(TEST_UPDATE_IME);
        klijent.setPrezime(TEST_UPDATE_PREZIME);
        klijent.setOib(TEST_UPDATE_OIB);
        klijent.setBrojMob(TEST_UPDATE_BROJ_MOB);
        klijent.setEmail(TEST_UPDATE_EMAIL);
        klijent.setMjesto(mjesto);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(klijent);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/v1/klijenti/{klijentId}", TEST_UPDATE_ID)
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
                .andExpect(jsonPath("$.id").value(TEST_UPDATE_ID))
                .andExpect(jsonPath("$.ime").value(TEST_UPDATE_IME))
                .andExpect(jsonPath("$.prezime").value(TEST_UPDATE_PREZIME))
                .andExpect(jsonPath("$.oib").value(TEST_UPDATE_OIB))
                .andExpect(jsonPath("$.brojMob").value(TEST_UPDATE_BROJ_MOB))
                .andExpect(jsonPath("$.email").value(TEST_UPDATE_EMAIL))
                .andExpect(jsonPath("$.mjesto.id").value(TEST_UPDATE_MJESTO_ID))
                .andExpect(jsonPath("$.mjesto.nazivMjesta").value(TEST_UPDATE_NAZIV_MJESTA));
    }

    @Test
    void deleteKlijentById() throws Exception {
        int TEST_ID = 6;

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/klijenti/{klijentId}", TEST_ID)
                .with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                )
                .with(csrf())
        )
                .andExpect(status().isNoContent());
    }
}
