package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project { // POJO Class [Plain Object Java Object]
	private String projectName;
	private String createdBy;
	private int teamsize;
	private String status;

	public Project(String projectName) {
	}

	public Project() { // create an empty cunstructor for create an instance of Project in another
						// class
	}

	public Project(String projectName, String createdBy, int teamsize, String status) {
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

public class Jackson_seriailizeTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Project pobj = new Project("Kalki", "Nag", 50, "success");
		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File("./project.json"), pobj);
		System.out.println("===========END=============");

	}

}
