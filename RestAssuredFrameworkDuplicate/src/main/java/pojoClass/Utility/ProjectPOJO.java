package pojoClass.Utility;

public class ProjectPOJO { // POJO Class [Plain Object Java Object]
		private String projectName;
		private String createdBy;
		private int teamSize;
		private String status;


		public ProjectPOJO() { // create an empty cunstructor for de-serialization
		}

		public ProjectPOJO(String projectName, String createdBy, int teamSize, String status) {
			this.projectName = projectName;
			this.createdBy = createdBy;
			this.teamSize = teamSize;
			this.status = status;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public int getTeamsize() {
			return teamSize;
		}

		public void setTeamsize(int teamSize) {
			this.teamSize = teamSize;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

}
