package dev.bruno.PersonRegistry.mappers.person;

import dev.bruno.PersonRegistry.dtos.person.UpdatePersonDTO;
import dev.bruno.PersonRegistry.model.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class UpdatePersonMapper {

    public PersonModel entityToDto(UpdatePersonDTO updatePersonDTO) {
        return new PersonModel(
                updatePersonDTO.name(),
                updatePersonDTO.adressModel()
        );
    }

    public void merge(PersonModel personModel, UpdatePersonDTO updatePersonDTO) {
        if (updatePersonDTO.name() != null) {
            personModel.setName(updatePersonDTO.name());
        }
        if (updatePersonDTO.adressModel() != null) {
            personModel.setAdress(updatePersonDTO.adressModel());
        }
    }

    public UpdatePersonDTO dtoToEntity(PersonModel personModel) {
        return new UpdatePersonDTO(
                personModel.getName(),
                personModel.getAdressModel()
        );
    }
}
