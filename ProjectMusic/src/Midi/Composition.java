package Midi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.jfugue.player.Player;

/**
 * Aφηρημένη κλάση και υπερκλάση όλων των κλάσεων που συνδέονται με τον τρόπο
 * σύνθεσης κομματιών
 * 
 */
public abstract class Composition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7307941895975216946L;

	public static String compositionsPath = new java.io.File("Compositions")
			.getAbsolutePath();

	// Η νότες της σύνθεσης με την σειρά που παίχτηκαν
	private ArrayList<Note> notes;

	private String instrument;
	private String artistName;
	private String compositionName = "";
	private String type; // Μπορεί να είναι "Free", "Atonal" ή "Algorithmic"

	/**
	 * Constractor που δεν δέχεται ορίσματα
	 */
	public Composition() {
		this.notes = new ArrayList<Note>();
		this.instrument = "I[Piano]";
		this.artistName = "";
		this.compositionName = "";
	}

	/**
	 * Constructor που δέχεται ορίσματα
	 */
	public Composition(ArrayList<Note> notes, String instr, String artistName,
			String compositionName) {
		this.notes = notes;
		this.instrument = instr;
		this.artistName = artistName;
		this.compositionName = compositionName;
	}

	/**
	 * Αποθηκεύει σε snthz αρχειο την μουσικη που υπαρχει στο στιγμιοτυπο την
	 * δεδομενη στιγμη με όλες τις λεπτομέρειες με το όνομα που είχε αποθηκευτεί
	 * νωρίτερα
	 * 
	 */
	public void save() {
		if (compositionName.isEmpty()) {
			compositionName = "unnamed";
		}
		saveAs("Compositions\\" + compositionName + ".snthz");
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

	/**
	 * Αντιγράφει τις τιμές μίας άλλης Composition σε εκείνη που καλεί την
	 * μέθοδο
	 * 
	 * @param c
	 */
	public void copyValues(Composition other) {
		notes = other.notes;
		instrument = other.instrument;
		artistName = other.artistName;
		compositionName = other.compositionName;
		type = other.type;
	}

	/**
	 * Αναπαράγει μία νότα n
	 * 
	 * @param n
	 */
	public void playNote(Note n) {
		Player player = new Player();
		player.play(n.toString());
	}

	public void addNote(Note n) {
		notes.add(n);
	}

	// getters & setters

	/**
	 * 
	 * @return Επιστρέφει ένα String με όλες τις νότες της σύνθεσης
	 */
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

	public ArrayList<Note> getNotes() {
		return this.notes;
	}

	public String getInstrument() {
		return this.instrument;
	}

	public String getArtistName() {
		return this.artistName;
	}

	public String getCompositionName() {
		return this.compositionName;
	}

	public String getType() {
		return this.type;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setInstrument(String k) {
		this.instrument = k;
	}

	public void setArtistName(String k) {
		this.artistName = k;
	}

	public void setCompositionName(String k) {
		this.compositionName = k;
	}
}