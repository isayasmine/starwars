package br.com.starwars.api.resource;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwars.api.constants.ConstantsPath;
import br.com.starwars.api.dto.PlanetaDTO;
import br.com.starwars.api.dto.PlanetsDTO;
import br.com.starwars.api.entity.PlanetaEntity;
import br.com.starwars.api.service.PlanetaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = ConstantsPath.PATH_STARWARS)
@Api(tags = {"Planeta"})
public class PlanetaResource {
	
	@Autowired
	private PlanetaService service;

	@ApiOperation(value = "Realiza a busca do planeta pelo id.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = PlanetaDTO.class),
			@ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		
		PlanetaEntity planeta = service.findByPlaneta(id);
		
		if (planeta != null) {
			return new ResponseEntity<PlanetaEntity>(planeta, HttpStatus.OK);
		}
		return new ResponseEntity<String>("ID não encontrado!", HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Realiza uma listagem de planetas.")
	@ApiParam(name = "nome", required = false, type = "string")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = PlanetaDTO.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findByListPlanetas(@RequestParam("nome") String nome) {
		
		List<PlanetaEntity> planetaList = service.findListPlaneta(nome);
		
		if (!CollectionUtils.isEmpty(planetaList)) {
			return new ResponseEntity<List<PlanetaEntity>>(planetaList, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Nome não encontrado!", HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Realiza o cadastro de um planeta.")
	@ApiResponses({ @ApiResponse(code = 201, message = "Ok", response = PlanetaDTO.class),
			@ApiResponse(code = 404, message = "Usuário não encontrado", response = String.class),
			@ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@PostMapping(value = "/planeta", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> createPlaneta(@RequestBody PlanetaDTO planeta) throws URISyntaxException {

		PlanetaEntity planetaEntity = service.adicionar(planeta);
		
		if (planetaEntity != null) {
			return new ResponseEntity<PlanetaEntity>(planetaEntity, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Problemas ao cadastrar planeta!", HttpStatus.BAD_REQUEST);
    }
	
	@ApiOperation(value = "Realiza o cadastro de um perfil de consumidor para um usuário.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = String.class),
			@ApiResponse(code = 404, message = "Usuário não encontrado", response = String.class),
			@ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePlaneta(@PathVariable("id") String id) {
		service.remover(id);
		return new ResponseEntity<String>("Planeta removido com sucesso!", HttpStatus.OK);
    }
	
	@ApiOperation(value = "Realiza consumo da API SW por id.")
	@ApiParam(name = "nome", required = false, type = "string")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = PlanetsDTO.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@GetMapping(value = "/SWAPi/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findPlanetsSWApi(@RequestParam("id") String id) throws URISyntaxException {
		
		PlanetsDTO dto = service.consunoSWApi(id);
		if (!StringUtils.isEmpty(id)) {
			return new ResponseEntity<PlanetsDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Nome não encontrado!", HttpStatus.BAD_REQUEST);
	}
}
