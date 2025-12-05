package dev.bruno.PersonRegistry.repositorys;

import dev.bruno.PersonRegistry.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
