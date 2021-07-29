package br.com.starwars.api.dto;

import java.io.Serializable;

public class ResidentDTO implements Serializable {

	private static final long serialVersionUID = -4960368103918333005L;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ResidentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResidentDTO(String url) {
		super();
		this.url = url;
	}

}
