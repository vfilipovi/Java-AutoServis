package hr.tvz.zuti.autoservis.web;


import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.services.KvarService;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/kvarovi")
public class KvarController {

    @Autowired
    private KvarService kvarService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewKvar(@Valid @RequestBody Kvar _kvar, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Kvar kvar = kvarService.saveOrUpdateKvar(_kvar);
        return new ResponseEntity<>(kvar, HttpStatus.CREATED);
    }

    @GetMapping("/{kvarId}")
    public ResponseEntity<?> getKvarById(@PathVariable Integer kvarId) {

        Optional<Kvar> kvar = kvarService.findKvarById(kvarId);

        return new ResponseEntity<>(kvar, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<Kvar> getAllKvarovi() {
        return kvarService.findAllKvarovi();
    }

    @DeleteMapping("/{kvarId}")
    public ResponseEntity<?> deleteKvar(@PathVariable Integer kvarId) {

        kvarService.deleteKvarById(kvarId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}