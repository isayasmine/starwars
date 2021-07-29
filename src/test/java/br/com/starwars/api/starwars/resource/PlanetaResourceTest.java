package br.com.starwars.api.starwars.resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.starwars.api.starwars.StarwarsApplicationTests;

public class PlanetaResourceTest extends StarwarsApplicationTests {
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}
	
	@Test
	public void testPOSTCreatePlanet() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/star-wars/planeta")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.param("clima", "temparate")
				.param("idSWAPI", "8")
				.param("nome", "Naboo")
				.param("terreno", "grassy hills, swamps, forests, mountains")).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
