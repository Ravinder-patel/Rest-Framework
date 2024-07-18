package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
		value = { 
				"createdBy", 
				"projectName", 
				"status",
				"teamsize"}
		)
@JsonIgnoreProperties(
		value= {
				"teamsize"
				},allowSetters=true
		)
class Movie { // POJO Class [Plain Object Java Object]
	private String projectName;
	@JsonProperty(value="created By")
	private String createdBy;
	private int teamsize;
	private String status;

	public Movie() { // create an empty cunstructor for create an instance of Project in another
						// class
	}

	public Movie(String projectName, String createdBy, int teamsize, String status) {
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamsize = teamsize;
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

public class Jackson_Annotatiions_serialTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Movie mObj = new Movie("Pushpa", "Nag", 50, "success");
		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File("./project.json"), mObj);
		System.out.println("===========END=============");

	}

}
