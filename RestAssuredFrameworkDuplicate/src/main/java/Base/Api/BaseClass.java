package Base.Api;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninza.hrm.generic.database.utility.DatabaseUtility;
import com.ninza.hrm.generic.file.utility.PropertiesFileUtility;
import com.ninza.hrm.genric.java.utility.JavaUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {

	public JavaUtility jLib = new JavaUtility();
	public PropertiesFileUtility pLib = new PropertiesFileUtility();
	public DatabaseUtility DBLib = new DatabaseUtility();
	public static RequestSpecification reqspec;
	public static ResponseSpecification resspec;

	@BeforeSuite
	public void configBSuite() throws Throwable {

		DBLib.getConnection();//"============connect to db once============"
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);

		builder.setBaseUri(pLib.getDataFromProperties("BASEUri"));
		reqspec = builder.build();

		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();
		responseSpec.expectContentType(ContentType.JSON);
		resspec = responseSpec.build();
	}

	@AfterSuite 
	public void configASuite() throws Throwable {
		DBLib.closeConnection();//"=========disconnect=========="
		
	}

}
