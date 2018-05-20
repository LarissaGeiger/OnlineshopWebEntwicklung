package bean;

public class BilderBean {
	
	private String bez;
	private byte[] file;
	private String imageFileName;
	private Integer id;
	



	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getBez() {
		return bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

}
