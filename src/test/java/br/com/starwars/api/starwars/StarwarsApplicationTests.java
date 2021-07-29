package br.com.starwars.api.starwars;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.starwars.api.dto.PlanetaDTO;
import br.com.starwars.api.entity.PlanetaEntity;
import br.com.starwars.api.repository.PlanetaRepository;
import br.com.starwars.api.resource.PlanetaResource;
import br.com.starwars.api.service.PlanetaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarwarsApplicationTests {
	
	@Autowired
	public PlanetaRepository repository;
	
	@Autowired
	public PlanetaService service;
	
	@Autowired
	public PlanetaResource resource;
	
	public MockMvc mockMvc;

	
	public PlanetaDTO testPlaneta() {
		
		PlanetaEntity entity = new PlanetaEntity();
		PlanetaDTO dto = new PlanetaDTO();
		
		entity.setId("1");
		entity.setClimate("SOL");
		entity.setName("Naboo");
		entity.setQuantity("4");
		entity.setTerrain("plana");
		
		dto.setId(entity.getId());
		dto.setClima(entity.getClimate());
		dto.setNome(entity.getName());
		dto.setIdSWAPI(entity.getQuantity());
		dto.setTerreno(entity.getTerrain());
		
		return dto;
	}
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}
	
}
