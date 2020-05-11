package guru.springframework.sfgpetclinic.Repositories;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetType extends CrudRepository <Pet, Long>{
}
