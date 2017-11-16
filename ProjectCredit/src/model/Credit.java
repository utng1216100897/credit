package model;
import java.io.Serializable;

	public class Credit implements Serializable{
		private Long id;
		private String name;
		private String expeditionDate;
		private String type;
		
		public Credit (Long id, String name, String expeditionDate, String type) {
			
			super();
			this.id = id;
			this.name = name;
			this.expeditionDate = expeditionDate;
			this.type = type;
		}
		public Credit() {
				this(0L, "", "", "");
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getExpeditionDate() {
			return expeditionDate;
		}
		public void setExpeditionDate(String expeditionDate) {
			this.expeditionDate = expeditionDate;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		@Override
		public String toString() {
			return "Credit [id=" + id + ", name=" + name + ", expeditionDate=" + expeditionDate + ", type=" + type + "]";
		}
		
		
		
	}


