package bean;

import java.io.Serializable;

public class KategorieBean implements Serializable {

	private static final long serialVersionUID = 1L;

		
		private Integer id;
		private String name;
		private Integer bildID;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
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
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
			}

	

