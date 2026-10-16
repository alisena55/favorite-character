package com.csc340.character_api.characters;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FictionalCharacterRepository extends JpaRepository<FictionalCharacter, Long> {
  
  List<FictionalCharacter> findByUniverseIgnoreCase(String universe);
  
  List<FictionalCharacter> findByNameContainingIgnoreCase(String name);
  
  List<FictionalCharacter> findByNameContainingIgnoreCaseAndUniverseIgnoreCase(String name, String universe);
}

