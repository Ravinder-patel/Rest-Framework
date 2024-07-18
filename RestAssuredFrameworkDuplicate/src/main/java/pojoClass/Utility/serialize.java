package pojoClass.Utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


class Root {
	private List<Value> value;
	private String itemConfigId;

	public Root(List<Value> value, String itemConfigId) {
		super();
		this.value = value;
		this.itemConfigId = itemConfigId;
	}

	public Root() {

	}

	public List<Value> getValue() {
		return value;
	}

	public void setValue(List<Value> value) {
		this.value = value;
	}

	public String getItemConfigId() {
		return itemConfigId;
	}

	public void setItemConfigId(String itemConfigId) {
		this.itemConfigId = itemConfigId;
	}

}

class Value {
	private List<User> user;
	private List<Manager> mansger;
	private String pinName;

	public Value(List<User> user, List<Manager> mansger, String pinName) {
		super();
		this.user = user;
		this.mansger = mansger;
		this.pinName = pinName;
	}

	public Value() {

	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Manager> getMansger() {
		return mansger;
	}

	public void setMansger(List<Manager> mansger) {
		this.mansger = mansger;
	}

	public String getPinName() {
		return pinName;
	}

	public void setPinName(String pinName) {
		this.pinName = pinName;
	}

}


class User {
	private String id;
	private String value;

	public User(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

class Manager {
	private String id;
	private String value;

	public Manager(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public Manager() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

public class serialize {
	public static void main(String[] args) throws Throwable, Throwable, IOException {

		Manager m1 = new Manager("56789", "ENG");
		User u1 = new User("1324", "Jerry");

		List<Manager> m1list = new ArrayList<Manager>();
		m1list.add(m1);
		
		List<User> u1list = new ArrayList<User>();
		u1list.add(u1);

		Value v1=new Value(u1list, m1list, "PIN11111");

		//
		List<Value> vList = new ArrayList<Value>();
		vList.add(v1);

		Root root = new Root(vList, "itemConfig#123");
		
		List<Root> rr=new ArrayList<Root>();
		rr.add(root);
		
		//RootList rl=new RootList(rr);

		ObjectMapper mapObj = new ObjectMapper();
		mapObj.writerWithDefaultPrettyPrinter().writeValue(new File("./POJO3.json"), rr);
		
		System.out.println("======Serialized=======");
	}

}
//class RootList{
//private List<Root> r1;
//
//public RootList(List<Root> r1) {
//	this.r1 = r1;
//}
//public RootList() {
//	
//}
//public List<Root> getR1() {
//	return r1;
//}
//public void setR1(List<Root> r1) {
//	this.r1 = r1;
//}
//
//
//}
