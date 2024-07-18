package serializationAndDeserialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFCGame implements Serializable {
	String user;
	int score;
	int level;
	int life;

	public NFCGame(String user, int score, int level, int life) {
		this.user = user;
		this.score = score;
		this.level = level;
		this.life = life;
	}

}

public class Run_serial {
	public static void main(String[] args) throws Throwable {
		NFCGame user1 = new NFCGame("Ravinder", 690000, 88, 1);
		FileOutputStream fos = new FileOutputStream("./file.txt");

		ObjectOutputStream objOut = new ObjectOutputStream(fos);
		objOut.writeObject(user1);	//serializing method
		System.out.println("========ENDED=========");

	}

}
