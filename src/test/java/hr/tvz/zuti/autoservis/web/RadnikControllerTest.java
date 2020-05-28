package hr.tvz.zuti.autoservis.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.domain.enumerations.VrstaRadnogOdnosa;
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
public class RadnikControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void newRadnik() throws Exception {

        String TEST_IME = "Ime";
        String TEST_PREZIME = "Prezime";
        String TEST_OIB = "32766533683";
        Double TEST_IZNO = 3000.00;
        Double TEST_KOEF = 5.00;
        String TEST_SRO = "ZAPOSLEN";
        String TEST_VRO = "NEODREDENO";
        String TEST_MJESTO = "Zagreb";
        int TEST_MJESTO_ID = 1;

        Mjesto mjesto = new Mjesto();
        mjesto.setId(TEST_MJESTO_ID);
        mjesto.setNazivMjesta(TEST_MJESTO);

        Radnik radnik = new Radnik();
        radnik.setIme(TEST_IME);
        radnik.setPrezime(TEST_PREZIME);
        radnik.setOib(TEST_OIB);
        radnik.setIznosOsnovice(TEST_IZNO);
        radnik.setKoefPlace(TEST_KOEF);
      //  radnik.setStatusRadnogOdnosa(TEST_SRO);
        // radnik.setVrstaRadnogOdnosa(TEST_VRO);
        radnik.setMjesto(mjesto);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(radnik);

        this.mockMvc.perform(
                post("/api/v1/radnici")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(json)
                        .characterEncoding("utf-8")
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.ime").value(TEST_IME))
                .andExpect(jsonPath("$.prezime").value(TEST_PREZIME))
                .andExpect(jsonPath("$.oib").value(TEST_OIB))
                .andExpect(jsonPath("$.iznos").value(TEST_IZNO))
                .andExpect(jsonPath("$.koef").value(TEST_KOEF))
              //  .andExpect(jsonPath("$.status").value(TEST_SRO))
              //  .andExpect(jsonPath("$.vrsta").value(TEST_VRO))
                .andExpect(jsonPath("$.mjestoId").value(TEST_MJESTO_ID))
                .andExpect(jsonPath("$.mjesto").value(TEST_MJESTO));
    }

    @Test
    void getRadnikById() throws Exception {
        int TEST_ID = 1;
        String TEST_IME = "Tom";
        String TEST_PREZIME = "Hardy";
        String TEST_OIB = "32766533683";
        Double TEST_IZNO = 3500.00;
        Double TEST_KOEF = 5.00;
        String TEST_SRO = "ZAPOSLEN";
        String TEST_VRO = "NEODREDENO";
        String TEST_MJESTO = "Zagreb";
        int TEST_MJESTO_ID = 1;

        this.mockMvc.perform(
                get("/api/v1/radnici/{radnikId}",TEST_ID)
                        .characterEncoding("utf-8")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.ime").value(TEST_IME))
                .andExpect(jsonPath("$.prezime").value(TEST_PREZIME))
                .andExpect(jsonPath("$.oib").value(TEST_OIB))
                .andExpect(jsonPath("$.iznos").value(TEST_IZNO))
                .andExpect(jsonPath("$.koef").value(TEST_KOEF))
                .andExpect(jsonPath("$.status").value(TEST_SRO))
                .andExpect(jsonPath("$.vrsta").value(TEST_VRO))
                .andExpect(jsonPath("$.mjestoId").value(TEST_MJESTO_ID))
                .andExpect(jsonPath("$.mjesto").value(TEST_MJESTO));
    }

    @Test
    void getAllRadnici() throws Exception{
        this.mockMvc.perform(
                get("/api/v1/radnici")
                        .characterEncoding("utf-8")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(5)));
    }

    @Test
    void deleteRadniciById() throws Exception {
        int TEST_ID = 2;

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/radnici/{radnikId}", TEST_ID)
                .with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                )
                .with(csrf())
        )
                .andExpect(status().isNoContent());
    }}
