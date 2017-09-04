/**
 * 
 */
package src.pwd.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * BioDaata entity.
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class BioData {
	
	private Map<String,String> data;
	
	public BioData() {
		this.data = new HashMap<String, String>();
	}
	
	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public void addDataValue(String key, String value){
		if(!data.containsKey(key)){
			data.put(key, value);
		}
	}
	
	public String getDataValue(String key){
		return data.get(key);
	}
}
