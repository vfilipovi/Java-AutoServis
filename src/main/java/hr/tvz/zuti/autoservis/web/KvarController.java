package hr.tvz.zuti.autoservis.web;


import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.services.KvarService;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
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
@RequestMapping("/api/v1/kvarovi")
public class KvarController {

    @Autowired
    private KvarService kvarService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Secured("ROLE_ADMIN")
    @PostMapping("")
    public ResponseEntity<?> createNewKvar(@Valid @RequestBody Kvar _kvar, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Kvar kvar = kvarService.saveOrUpdateKvar(_kvar);
        return new ResponseEntity<>(kvar, HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{kvarId}")
    public ResponseEntity<?> getKvarById(@PathVariable Integer kvarId) {

        Optional<Kvar> kvar = kvarService.findKvarById(kvarId);

        return new ResponseEntity<>(kvar, HttpStatus.OK);
    }

    @GetMapping(params = "nazivKvara")
    public ResponseEntity<?> getKvarByNaziv(@RequestParam String nazivKvara) {

        Optional<Kvar> kvar = kvarService.findByNaziv(nazivKvara);

        return new ResponseEntity<>(kvar, HttpStatus.OK);
    }


    @GetMapping("")
    public Iterable<Kvar> getAllKvarovi() {
        return kvarService.findAllKvarovi();
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{kvarId}")
    public ResponseEntity<?> updateKvarById(@Valid @RequestBody Kvar _kvar, @PathVariable Integer kvarId, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Optional<Kvar> updatedKvar = kvarService.findKvarById(kvarId).map(kvar -> {
            kvar.setNazivKvara(_kvar.getNazivKvara());
            kvar.setOpisKvara(_kvar.getOpisKvara());

            return kvarService.saveOrUpdateKvar(kvar);
        });

        return new ResponseEntity<>(updatedKvar, HttpStatus.OK);
    }



}