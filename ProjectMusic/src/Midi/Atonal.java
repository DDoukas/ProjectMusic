package Midi;

import java.util.ArrayList;

public class Atonal extends Composition {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6976165206580023507L;
	private int noteNumber = 0;
	private AtonalComposition prax;

	public Atonal() {
		super();
		this.setEidos("Atonal");
	}

	public void copyValues(Atonal a) {
		super.copyValues(a);
		noteNumber = a.noteNumber;
		prax = a.prax;
	}
	/**
	 * Constructor που δέχεται ως όρισμα μια συμβολοσειρά που αποτελείτε
	 * απαραίτητα απο 12 χαρακτήρες που ο καθένας είναι ξεχωριστός και θα
	 * δημιουργεί ένα Atonal row
	 * 
	 */
	public Atonal(ArrayList<Note> notes) {
		this.setNotes(notes);
		noteNumber = 12;
	}

	public Atonal(ArrayList<Note> notes, String instr, String onomsinth, String compname) {
		super(notes, instr, onomsinth, compname);
	}

	public void addNote(Note n) {
		super.addNote(n);;
		noteNumber++;
	}

	/**
	 * Θα παίζει την σύνθεση που έχει δοθεί
	 * 
	 * @throws IllegalAccessException
	 */
	public void setPrax() throws IllegalAccessException {
		if (noteNumber == 12) {
			prax = new AtonalComposition(this.getNotes());
		} else {
			throw new IllegalAccessException();
		}
	}

	public void doNothing() throws SymmetryActionOnNonValidAtonalRow {
		prax.doNothing();
		this.setNotes(prax.getMusic());
	}

	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
		prax.reflect(x);
		this.setNotes(prax.getMusic());

	}

	public void retrograde() throws SymmetryActionOnNonValidAtonalRow {
		prax.retrograde();
		this.setNotes(prax.getMusic());
	}

	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
		prax.transpose(x);
		this.setNotes(prax.getMusic());

	}

	public int getNoteNumber() {
		return this.noteNumber;
	}

}