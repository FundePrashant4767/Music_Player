package music_players_jdbc.app;

class Song {
	
	private int id;
	private String name;
	private String singure;
	private String language;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSingure() {
		return singure;
	}
	public void setSingure(String singure) {
		this.singure = singure;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}

