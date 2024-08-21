package jp.co.brightstar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.brightstar.model.Pet;
//import jp.co.brightstar.model.PetCondition;
//import jp.co.brightstar.model.PetCondition;

@Mapper
public interface PetMapper {

	List<Pet> searchPet();

	void insertPet(Pet pet);

	void petReset(Pet pet);

	void deletePet(String id);

	Pet getPetById(String id);

}
