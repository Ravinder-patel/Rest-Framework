package serializationAndDeserialization;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson_DeseriailizeTest {

	public static void main(String[] args) throws Throwable {
		ObjectMapper objMap = new ObjectMapper();
		Project user1 = objMap.readValue(new File("./project.json"), Project.class);
		
		System.out.println(user1.getProjectName());
		System.out.println(user1.getCreatedBy());
		System.out.println(user1.getTeamsize());
		System.out.println(user1.getStatus());
		// System.out.println(user1.getClass());

	}

}
