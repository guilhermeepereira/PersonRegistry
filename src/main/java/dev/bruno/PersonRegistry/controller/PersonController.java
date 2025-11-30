package dev.bruno.PersonRegistry.controller;

import dev.bruno.PersonRegistry.model.PersonModel;
import dev.bruno.PersonRegistry.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/findall")
    public ResponseEntity<List<PersonModel>> findAll() {
        return personService.findAll().isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/list")
    public ResponseEntity<PersonModel> findById(Long id) {
        return personService.findById(id) == null ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PersonModel> createPerson(@RequestBody PersonModel newPerson) {
        personService.createPerson(newPerson);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if(personService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
         personService.deleteById(id);
         return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonModel> updatePerson(@PathVariable Long id, @RequestBody PersonModel personModel) {
        return personService.findById(id) == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(personService.alterPerson(id, personModel));
    }
}
