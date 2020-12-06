package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class PetAdoptationService {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Transactional
	public void adoptAPet() {
		Owner owner = saveOwner();
		savePet(owner);
	}

	public Owner saveOwner() {
		Owner owner = getOwner();
		ownerRepository.save(owner);
		return owner;
	}

	public void savePet(Owner owner) {

		Pet pet = getPet(owner);
		petRepository.save(pet);
	}

	private Pet getPet(Owner owner) {
		Pet pet = new Pet();
		pet.setName("Zorba");
		pet.setBirthDate(LocalDate.now());
		pet.setOwner(owner);
		PetType petType = new PetType();
		petType.setId(1);
		pet.setType(petType);
		return pet;
	}

	private Owner getOwner() {
		Owner owner = new Owner();
		owner.setFirstName("Yusuf Aslan");
		owner.setLastName("Çalışkan");
		owner.setAddress("a");
		owner.setCity("a");
		owner.setTelephone("1");
		return owner;
	}

}
