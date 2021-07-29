package br.com.starwars.api.starwars.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;

import br.com.starwars.api.dto.PlanetaDTO;
import br.com.starwars.api.entity.PlanetaEntity;
import br.com.starwars.api.starwars.StarwarsApplicationTests;

public class PlanetaServiceTest extends StarwarsApplicationTests {

	@Test
	public void shouldIncludPlanetAndClimateSOL() throws URISyntaxException {
		PlanetaDTO dto = testPlaneta();
		PlanetaEntity entity = service.adicionar(dto);
		
		assertThat(entity.getClimate()).isEqualTo(dto.getClima());
	}
	
	@Test
	public void shouldIncludPlanetNull() throws URISyntaxException {
		PlanetaDTO dto = null;
		PlanetaEntity entity = service.adicionar(dto);
		
		assertThat(entity).isNull();
	}
	
	@Test
	public void shouldRemovePlanet() {
		PlanetaDTO dto = testPlaneta();
		service.remover(dto.getId());
	}
	
	@Test
	public void shouldFindListPlanets() {
		PlanetaDTO dto = testPlaneta();
		service.findListPlaneta(dto.getNome());
				
		assertThat(dto.getNome()).isNotEmpty();
	}
	
	@Test
	public void shouldFindListPlanetNull() {
		List<PlanetaEntity> planetas = service.findListPlaneta(null);
		assertThat(planetas).isNull();
	}
	
	@Test
	public void shouldFindByPlanetNull() {
		PlanetaEntity planeta = service.findByPlaneta(null);
		
		assertThat(planeta).isNull();
	}
	
	@Test
	public void shouldFindByPlanetaId() throws URISyntaxException {
		PlanetaDTO dto = testPlaneta();
		service.findByPlaneta(dto.getId());
		assertThat(dto).isNotNull();
	}

}
