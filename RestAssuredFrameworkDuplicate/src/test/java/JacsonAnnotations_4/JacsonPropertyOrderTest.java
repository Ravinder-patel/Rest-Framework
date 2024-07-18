package JacsonAnnotations_4;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonPropertyOrder({ "production", "movieName", "status", "hero" })
@JsonIgnoreProperties({ "status" })

class Kalki {
	
	@JsonProperty(value="movie Name")
	private String movieName;
	private String status;
	private String hero;
	private String production;

	public Kalki(String movieName, String status, String hero, String production) {
		this.movieName = movieName;
		this.status = status;
		this.hero = hero;
		this.production = production;
	}
	
	
	
	public Kalki() { 
		
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHero() {
		return hero;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getProduction() {
		return production;
	}



}
public class JacsonPropertyOrderTest{
	
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		
		Kalki k1 = new Kalki("Kalki 2898AD", "On going", "Prbhas", "Vyjayanthi");
		
		ObjectMapper mapObj = new ObjectMapper();
		mapObj.writerWithDefaultPrettyPrinter().writeValue(new File("./annotations.json"), k1);
		
		System.out.println("=========END=========");

	}
	

}
