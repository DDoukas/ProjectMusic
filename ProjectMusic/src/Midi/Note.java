package Midi;

import java.io.Serializable;

public class Note implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1676281611865484867L;
	private String note;
	private String value;
	private String octave;
	private String instrument;

	public Note(String note, String value, int octave, String instrument) {
		this.note = note;
		this.value = value;
		if (!note.equals("R"))
			this.octave = String.valueOf(octave);
		else
			this.octave = "";
		this.instrument = instrument;
	}

	public String toString() {
		return instrument + " " + note + octave + value;
	}

	public String toStringNoInstr() {
		return note + octave + value;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getValue() {
		return value;
	}

	public String getOctave() {
		return octave;
	}

	public String getInstrument() {
		return instrument;
	}

}
