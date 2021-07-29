package br.com.starwars.api.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planeta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PlanetaEntity implements Serializable {

	private static final long serialVersionUID = 2964589452865154542L;
	
	@Id
	private String id;
	private String name;
	private String climate;
	private String terrain;
	private String quantity;

}
