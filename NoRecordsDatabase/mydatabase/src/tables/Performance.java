package tables;

public class Performance {
	private int id; 
	private int song_id; //FOREIGN KEY REFERENCES SONG
	private String m_ssn; // FOREIGN KEY REFERENCES MUSICIAN
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSong_id() {
		return song_id;
	}
	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
	public String getM_ssn() {
		return m_ssn;
	}
	public void setM_ssn(String m_ssn) {
		this.m_ssn = m_ssn;
	}
	
}
