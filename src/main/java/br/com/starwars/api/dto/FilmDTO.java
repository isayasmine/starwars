package br.com.starwars.api.dto;

import java.io.Serializable;

public class FilmDTO implements Serializable {

	private static final long serialVersionUID = 2275182445756475774L;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public FilmDTO(String url) {
		super();
		this.url = url;
	}

	public FilmDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
