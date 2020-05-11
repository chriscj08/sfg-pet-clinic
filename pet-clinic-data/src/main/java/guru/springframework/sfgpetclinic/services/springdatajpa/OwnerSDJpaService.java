package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.Repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.Repositories.PetRepository;
import guru.springframework.sfgpetclinic.Repositories.PetType;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetType petType;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetType petType) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petType = petType;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findByID(Long aLong) {
        return ownerRepository.findById((aLong)).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
