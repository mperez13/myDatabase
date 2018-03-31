package tables;

public class Instrument {
	private int instrument_id; //PRIMARY KEY
	private String name;
	private String musickeys;
	
	public int getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(int instrument_id) {
		this.instrument_id = instrument_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMusickeys() {
		return musickeys;
	}
	public void setMusickeys(String musickeys) {
		this.musickeys = musickeys;
	}
}
