package Midi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.jfugue.player.Player;

public abstract class Composition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7307941895975216946L;
	private ArrayList<Note> notes;
	private String instr;
	private String onomsinth;
	private String compname = "";
	private String eidossinthesis;

	/**
	 * Constractor που δεν δέχεται ορίσματα και θέτει όλες τις μεταβλητές Null
	 */
	public Composition() {
		this.notes = new ArrayList<Note>();
		this.instr = "I[Piano]";
		this.onomsinth = "";
		this.compname = "";
	}

	public Composition(ArrayList<Note> notes, String instr, String onomsinth,
			String compname) {
		this.notes = notes;
		this.instr = instr;
		this.onomsinth = onomsinth;
		this.compname = compname;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public void setEidos(String k) {
		this.eidossinthesis = k;
	}

	public void setInstr(String k) {
		this.instr = k;
	}

	public void setOnomSinth(String k) {
		this.onomsinth = k;
	}

	public void setCompName(String k) {
		this.compname = k;
	}

	/**
	 * Αποθηκεύει σε synthz αρχειο την μουσικη που υπαρχει στο στιγμιοτυπο την
	 * δεδομενη στιγμη με όλες τις λεπτομέρειες με το όνομα που είχε αποθηκευτεί
	 * νωρίτερα
	 * 
	 */
	public void save() {
		if (compname.isEmpty()) {
			compname = "unnamed";
		}
		saveAs("Compositions\\" + compname + ".snthz");
	}

	/**
	 * Αποθηκεύει σε snthz αρχειο την μουσικη που υπαρχει στο στιγμιοτυπο την
	 * δεδομενη στιγμη με όλες τις λεπτομέρειες με το όνομα που δίνει εκείνη την
	 * στιγμή ο χρήστης
	 */
	public void saveAs(String filename) {
		try {
			File f;
			if (filename.contains("."))
				f = new File(filename);
			else
				f = new File(filename + ".snthz");
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(f));
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyValues(Composition c) {
		notes = c.notes;
		instr = c.instr;
		onomsinth = c.onomsinth;
		compname = c.compname;
		eidossinthesis = c.eidossinthesis;
	}

	/**
	 * οι getter
	 */
	public ArrayList<Note> getNotes() {
		return this.notes;
	}

	public String getInstr() {
		return this.instr;
	}

	public String getOnomSinth() {
		return this.onomsinth;
	}

	public String getCompName() {
		return this.compname;
	}

	public String getEidos() {
		return this.eidossinthesis;
	}

	public void playNote(Note n) {
		Player player = new Player();
		player.play(n.toString());
	}

	public void addNote(Note n) {
		notes.add(n);
	}

	public String getNotesString() {
		String s = "";
		String instr = "";
		for (Note n : notes) {
			String instrCurr = n.getInstrument();
			if (!instr.equals(instrCurr)) {
				instr = instrCurr;
				s += instr + " ";
			}
			s += n.toStringNoInstr() + " ";
			String[] b = s.split("\n");
			if (b[b.length - 1].length() >= 40)
				s += '\n';
		}
		return s;
	}
}