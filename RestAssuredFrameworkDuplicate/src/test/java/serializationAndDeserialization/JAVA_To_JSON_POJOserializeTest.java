package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Kalki {

	private String movieName;
	private String status;
	private List<String> teamMembers;
	private Manager manager;

	public Kalki(String movieName, String status, List<String> teamMembers, Manager manager) {
		this.movieName = movieName;
		this.status = status;
		this.teamMembers = teamMembers;
		this.manager = manager;
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

	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public List<String> getTeamMembers() {
		return teamMembers;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

}

class Manager {

	private String name;
	private String type;

	public Manager(String name, String type) {
		this.name = name;
		this.type = type;
	}
	public Manager() { //POJO De-serialization
		
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}

public class JAVA_To_JSON_POJOserializeTest {
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		List<String> team = new ArrayList<String>();
		team.add("Prabhas");
		team.add("Amitab");
		team.add("Kamal");
		team.add("Nag");

		Manager mObj = new Manager("Vyjayanthi", "Film Production");

		Kalki k1 = new Kalki("Kalki 2898AD", "On going", team, mObj);

		ObjectMapper mapObj = new ObjectMapper();
		mapObj.writeValue(new File("./kalki.json"), k1);
		
		System.out.println("=========END=========");

	}

}
