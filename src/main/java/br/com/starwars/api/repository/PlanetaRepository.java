package br.com.starwars.api.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.starwars.api.entity.PlanetaEntity;

public interface PlanetaRepository extends MongoRepository<PlanetaEntity, String> {
	
	public List<PlanetaEntity> findByName(String nome);	

}
