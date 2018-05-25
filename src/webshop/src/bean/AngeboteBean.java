package bean;

import java.io.Serializable;

public class AngeboteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Integer bildID;




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBildID() {
		return bildID;
	}

	public void setBildID(Integer bildID) {
		this.bildID = bildID;
	}

	

}
