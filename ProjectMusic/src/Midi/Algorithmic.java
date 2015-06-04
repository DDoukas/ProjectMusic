package Midi;

import java.util.ArrayList;
import java.util.Random;

public class Algorithmic extends Composition {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4936502944517658085L;
	private int ar;

	public Algorithmic() {
		super();
		this.setEidos("Algorithmic");
	}

	public Algorithmic(ArrayList<Note> notes, String instr, String onomsinth,
			String compname) {
		super(notes, instr, onomsinth, compname);
	}

	public void generateNotes(int k) {
		ar = k;
		Random generator = new Random();
		ArrayList<Note> notes = new ArrayList<Note>();
		// Randomize instrument
		String instrument;
		switch (generator.nextInt(3)) {
		case 0:
			instrument = "I[Piano]";
			break;
		case 1:
			instrument = "I[Guitar]";
			break;
		default:
			instrument = "I[Accordian]";
			break;
		}
		for (int i = 0; i < k; i++) {
			// Randomize note
			String n = "";
			switch (generator.nextInt(12)) {
			case 0:
				n = "C";
				break;
			case 1:
				n = "C#";
				break;
			case 2:
				n = "D";
				break;
			case 3:
				n = "D#";
				break;
			case 4:
				n = "E";
				break;
			case 5:
				n = "F";
				break;
			case 6:
				n = "F#";
				break;
			case 7:
				n = "G";
				break;
			case 8:
				n = "G#";
				break;
			case 9:
				n = "A";
				break;
			case 10:
				n = "A#";
				break;
			default:
				n = "B";
				break;
			}
			// Randomize note value (1/7 chance for whole, 2/7 for half, 3/8 for
			// quarter, 2/8 for eigth)
			String value;
			switch (generator.nextInt(9)) {
			case 0:
				value = "w";
				break;
			case 1:
			case 2:
				value = "h";
				break;
			case 3:
			case 4:
				value = "i"; //eighth
				break;
			default:
				value = "q";
				break;
			}
			notes.add(new Note(n, value, generator.nextInt(3) + 4, instrument));
		}
		this.setNotes(notes);
	}

	public int getAr() {
		return this.ar;
	}

}