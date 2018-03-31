package tables;

public class InstrumentPlayer {
	private int id;
	private int instrument_id; // FOREIGN KEY REFERENCES INSTRUMENT
	private String m_ssn; // FOREIGN KEY REFERENCES MUSICIAN
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(int instrument_id) {
		this.instrument_id = instrument_id;
	}
	public String getM_ssn() {
		return m_ssn;
	}
	public void setM_ssn(String m_ssn) {
		this.m_ssn = m_ssn;
	}
	
}
