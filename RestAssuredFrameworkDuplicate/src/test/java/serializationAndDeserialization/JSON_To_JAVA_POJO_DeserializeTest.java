package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON_To_JAVA_POJO_DeserializeTest {
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		ObjectMapper mapperObj = new ObjectMapper();
		Kalki kalkiObj = mapperObj.readValue(new File("./kalki.json"), Kalki.class);
		
		System.out.println(kalkiObj.getMovieName());
		System.out.println(kalkiObj.getStatus());
		System.out.println(kalkiObj.getTeamMembers());
		System.out.println(kalkiObj.getManager().getName());
		System.out.println(kalkiObj.getManager().getType());
		System.out.println(kalkiObj.getClass());
	}

}
