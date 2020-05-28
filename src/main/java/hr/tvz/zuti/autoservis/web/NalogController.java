package hr.tvz.zuti.autoservis.web;

import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
import hr.tvz.zuti.autoservis.services.NalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/nalozi")
public class NalogController {

    @Autowired
    private NalogService nalogService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Secured("ROLE_ADMIN")
    @PostMapping("")
    public ResponseEntity<?> createNewNalog(@Valid @RequestBody Nalog _nalog, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Nalog nalog = nalogService.saveOrUpdateNalog(_nalog);
        return new ResponseEntity<>(nalog, HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{nalogId}")
    public ResponseEntity<Optional<Nalog>> getNalogById(@PathVariable Integer nalogId) {

        Optional<Nalog> nalog = nalogService.findNalogById(nalogId);

        return new ResponseEntity<>(nalog, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<Nalog> getAllNalozi() { return nalogService.findAllNalozi(); }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{nalogId}")
    public ResponseEntity<?> updateNalogById(@Valid @RequestBody Nalog _nalog, @PathVariable Integer nalogId, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Optional<Nalog> updatedNalog = nalogService.findNalogById(nalogId).map(nalog -> {
            nalog.setRegistracijaVozila(_nalog.getRegistracijaVozila());
            nalog.setPrioritet(_nalog.getPrioritet());
            nalog.setDatumPreuzimanja(_nalog.getDatumPreuzimanja());
            nalog.setDatumIzdavanja(_nalog.getDatumIzdavanja());

            return nalogService.saveOrUpdateNalog(nalog);
        });

        return new ResponseEntity<>(updatedNalog, HttpStatus.OK);
    }
}