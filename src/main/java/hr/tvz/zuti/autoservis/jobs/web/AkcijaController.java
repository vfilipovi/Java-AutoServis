package hr.tvz.zuti.autoservis.jobs.web;

import hr.tvz.zuti.autoservis.jobs.service.AkcijaService;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/akcija")
public class AkcijaController {

    @Autowired
    private AkcijaService akcijaService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @CrossOrigin
    @GetMapping("")
    public Map<String, String> getAkcija() {

        String akcija = akcijaService.getNewAkcija();

        return Collections.singletonMap("akcija", akcija);
    }
}
