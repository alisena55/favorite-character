package com.csc340.character_api.characters;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FictionalCharacterService {
  
  private final FictionalCharacterRepository repository;
  
  public FictionalCharacterService(FictionalCharacterRepository repository) {
	this.repository = repository;
  }
  
  public List<FictionalCharacter> search(String name, String universe) {
	boolean hasName = name != null && !name.isBlank();
	boolean hasUniverse = universe != null && !universe.isBlank();
	
	if (hasName && hasUniverse) {
	  return repository.findByNameContainingIgnoreCaseAndUniverseIgnoreCase(name.trim(), universe.trim());
	}
	if (hasName) {
	  return repository.findByNameContainingIgnoreCase(name.trim());
	}
	if (hasUniverse) {
	  return repository.findByUniverseIgnoreCase(universe.trim());
	}
	return repository.findAll();
  }
  
  public FictionalCharacter findById(Long id) {
	return repository.findById(id)
			.orElseThrow(() -> new CharacterNotFoundException(id));
  }
  
  public FictionalCharacter create(FictionalCharacter character) {
	return repository.save(character);
  }
  
  public FictionalCharacter update(Long id, FictionalCharacter updated) {
	FictionalCharacter existing = findById(id);
	existing.setName(updated.getName());
	existing.setDescription(updated.getDescription());
	existing.setUniverse(updated.getUniverse());
	existing.setRole(updated.getRole());
	existing.setSpecies(updated.getSpecies());
	existing.setPowerLevel(updated.getPowerLevel());
	existing.setFirstAppearance(updated.getFirstAppearance());
	existing.setImageUrl(updated.getImageUrl());
	return repository.save(existing);
  }
  
  public void delete(Long id) {
	FictionalCharacter existing = findById(id);
	repository.delete(existing);
  }
}
