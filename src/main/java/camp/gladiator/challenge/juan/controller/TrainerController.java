package camp.gladiator.challenge.juan.controller;

import camp.gladiator.challenge.juan.model.Trainer;
import camp.gladiator.challenge.juan.service.TrainerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/trainer")
@Api(tags = "Trainer controller", value = "TrainerController")
public class TrainerController {

    private final TrainerService trainerService;
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping(value = "find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find a Trainer")
    public ResponseEntity<Trainer> findTrainer (@PathVariable("id") Long id){
        Trainer trainer = trainerService.findTrainerById(id);
        return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Trainer")
    public ResponseEntity<Trainer> addTrainer (@RequestBody Trainer trainer){
        Trainer trainerAux = trainerService.addTrainer(trainer);
        return new ResponseEntity<Trainer>(trainerAux, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Trainer>> findAllTrainers () {
        List<Trainer> trainers = trainerService.findAllTrainer();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }
}
