package project_stacks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import project_stacks.model.Troops;
import project_stacks.repository.TroopsRepository;
import project_stacks.service.TroopsService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/troops")
public class TroopsController {

    private final TroopsService troopsService;

    public TroopsController(TroopsService troopsService) {
        this.troopsService = troopsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Troops> findById(@PathVariable Long id) {
        var troop = troopsService.findById(id);
        return ResponseEntity.ok(troop);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Troops> create(@RequestBody Troops troopToCreate) {
        var troopCreated = troopsService.create(troopToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(troopCreated.getId()).toUri();
        return ResponseEntity.created(location).body(troopCreated);
    }

    @Autowired
    private TroopsRepository troopsRepository;
//
//    @PostMapping
//    public Troops createTroops(@RequestBody Troops troops) {
//        return troopsRepository.save(troops);
//    }
//
    @GetMapping
    public List<Troops> getAllTroops() {
        return troopsRepository.findAll();
    }
//
//    @GetMapping("/{id}")
//    public Troops getTroopsById(@PathVariable Long id) {
//        return troopsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Troops not found"));
//    }
//
    @PutMapping("/{id}")
    public Troops updateTroops(@PathVariable Long id, @RequestBody Troops troops) {
        troops.setId(id);
        return troopsRepository.save(troops);
    }

    @DeleteMapping("/{id}")
    public void deleteTroops(@PathVariable Long id) {
        troopsRepository.deleteById(id);
    }
}
