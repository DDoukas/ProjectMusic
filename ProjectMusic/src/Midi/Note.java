package Midi;

import java.io.Serializable;

/**
 * 
 * Αυτή η κλάση ασχολείται με την δημιουργία και διαχείρηση των νότων
 * 
 */
public class Note implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1676281611865484867L;

	private String note; // Can also be "R" (rest)
	private String value;
	private String octave;
	private String instrument;

	/**
	 * Default constructor
	 * 
	 * @param note
	 * @param value
	 * @param octave
	 * @param instrument
	 */
	public Note(String note, String value, int octave, String instrument) {
		this.note = note;
		this.value = value;
		this.instrument = instrument;

		// Rests do not need an octave setting
		if (!note.equals("R"))
			this.octave = String.valueOf(octave);
		else
			this.octave = "";
	}

	/**
	 * @return Επιστρέφει ένα String με όλα τα στοιχεία του αντικειμένου
	 */
	public String toString() {
		return instrument + " " + note + octave + value;
	}

	/**
	 * 
	 * @return Επιστρέφει ένα String με όλα τα στοιχεία του αντικειμένου εκτός
	 *         του οργάνου
	 */
	public String toStringNoInstr() {
		return note + octave + value;
	}

	//Getters
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
