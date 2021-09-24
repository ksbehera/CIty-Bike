package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetNetworks {
	
	//private JsonNode  company;
	private String href;
	private String id;
	private locationCountry location;
	private String name;
	
	
	/*public JsonNode  getCompany() {
		return  company;
	}
	public void setCompany(JsonNode  company) {
		this.company = company;
	}*/
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public locationCountry getLocation() {
		return location;
	}
	public void setLocation(locationCountry location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
