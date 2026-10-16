package com.csc340.character_api.characters;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "characters")
public class FictionalCharacter {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long characterId;
  
  @NotBlank(message = "name is required")
  @Size(max = 100)
  private String name;
  
  @NotBlank(message = "description is required")
  @Size(max = 1000)
  @Column(length = 1000)
  private String description;
  
  @Size(max = 100)
  private String universe;
  
  @Size(max = 100)
  private String role;
  
  @Size(max = 100)
  private String species;
  
  @Min(value = 1, message = "powerLevel must be between 1 and 5")
  @Max(value = 5, message = "powerLevel must be between 1 and 5")
  private Integer powerLevel;
  
  @PastOrPresent
  private LocalDate firstAppearance;
  
  @Size(max = 500)
  private String imageUrl;
  
  public FictionalCharacter() {
  }
  
  public Long getCharacterId() { return characterId; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  
  public String getUniverse() { return universe; }
  public void setUniverse(String universe) { this.universe = universe; }
  
  public String getRole() { return role; }
  public void setRole(String role) { this.role = role; }
  
  public String getSpecies() { return species; }
  public void setSpecies(String species) { this.species = species; }
  
  public Integer getPowerLevel() { return powerLevel; }
  public void setPowerLevel(Integer powerLevel) { this.powerLevel = powerLevel; }
  
  public LocalDate getFirstAppearance() { return firstAppearance; }
  public void setFirstAppearance(LocalDate firstAppearance) { this.firstAppearance = firstAppearance; }
  
  public String getImageUrl() { return imageUrl; }
  public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}