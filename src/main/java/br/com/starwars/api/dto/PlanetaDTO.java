package br.com.starwars.api.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class PlanetaDTO implements Serializable {

	private static final long serialVersionUID = -4398304567477766032L;
	
	@ApiModelProperty(hidden = true)
	private String id;
	private String idSWAPI;
	private String nome;
	private String clima;
	private String terreno;
	@ApiModelProperty(hidden = true)
	private String quantidade;
	
	public PlanetaDTO() {
		
	}
	
	public PlanetaDTO(String id, String idSWAPI, String nome, String clima, String terreno, String quantidade) {
		
		this.id = id;
		this.idSWAPI = idSWAPI;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantidade = quantidade;
	}
	
	public String getId() {
		return id;
	}
	
	public String getIdSWAPI() {
		return idSWAPI;
	}

	public void setIdSWAPI(String idSWAPI) {
		this.idSWAPI = idSWAPI;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
}
