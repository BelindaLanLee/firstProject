package jp.co.brightstar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.mapper.PetMapper;
import jp.co.brightstar.model.Pet;

@Service
public class PetService {
	@Autowired
	private PetMapper mapper;

	public void insertPet(Pet pet) {
		mapper.insertPet(pet);
	}

	public List<Pet> searchPet() {
		return mapper.searchPet();
	}

	public void petReset(Pet pet) {
		mapper.petReset(pet);
	}

	public Pet getPetById(String id) {
		return mapper.getPetById(id);
	}

	public void deletePet(String id) {
		mapper.deletePet(id);
	}

}
