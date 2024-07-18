package api.json.utility;

import java.util.List;

import org.asynchttpclient.Response;

import com.jayway.jsonpath.JsonPath;

/*
 *  @Auther Ravi
 */
public class JsonUtility {

	/*
	 * get jsondata based on json complex path
	 *  @Param resp
	 *  @param json xpath
	 *  @return
	 */
	public String getDataOnjsonPath(Response resp, String jsonXpath) {
		List<Object> list = JsonPath.read(resp.toString(), jsonXpath);
		return list.get(0).toString();
		
	}
	/*
	 * get jsondata based on xml complex path
	 *  @Param resp
	 *  @param json xpath
	 *  @return
	 */
	
	//=========================
}
