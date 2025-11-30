package dev.bruno.PersonRegistry.repositorys;

import dev.bruno.PersonRegistry.model.AdressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<AdressModel, Long> {
}
