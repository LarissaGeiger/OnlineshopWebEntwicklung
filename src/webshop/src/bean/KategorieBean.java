package bean;

import java.io.Serializable;

public class KategorieBean implements Serializable {

	private static final long serialVersionUID = 1L;

		
		private Integer kategorieID;
		private String kategorieName;
		
		public Integer getKategorieID() {
			return kategorieID;
		}
		public void setKategorieID(Integer kategorieID) {
			this.kategorieID = kategorieID;
		}
		
		
		public String getKategorieName() {
			return kategorieName;
		}
		
		public void setKategorieName(String kategorieName) {
			this.kategorieName = kategorieName;
		}
	}

	

