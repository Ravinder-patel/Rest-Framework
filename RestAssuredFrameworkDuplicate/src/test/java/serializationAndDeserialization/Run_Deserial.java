package serializationAndDeserialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Run_Deserial {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./file.txt");
		ObjectInputStream objInput = new ObjectInputStream(fis);

		NFCGame user2 = (NFCGame) objInput.readObject(); // De-serialization
		System.out.println(user2.user);
		System.out.println(user2.score);
		System.out.println(user2.life);
		System.out.println(user2.level);

	}

}
