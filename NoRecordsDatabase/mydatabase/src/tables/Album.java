package tables;

import java.sql.Date;

public class Album {
	private int id;
	private int album_id;
	private String title;
	private Date copyright_dt;
	private String format;
	private String m_ssn; // producer of album
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCopyright_dt() {
		return copyright_dt;
	}
	public void setCopyright_dt(Date copyright_dt) {
		this.copyright_dt = copyright_dt;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getM_ssn() {
		return m_ssn;
	}
	public void setM_ssn(String m_ssn) {
		this.m_ssn = m_ssn;
	}  
}
