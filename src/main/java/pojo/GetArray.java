package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GetArray {
	private List<GetNetworks> arrayNet;

	public List<GetNetworks> getArray() {
		return arrayNet;
	}

	public void setArray(List<GetNetworks> array) {
		this.arrayNet = arrayNet;
	}

}
