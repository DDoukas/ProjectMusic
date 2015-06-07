package Midi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Η κλάση αυτή υλοποιεί την διεπαφή Symmetry. Ένα στιγμιότυπο της κλάσης είναι
 * μία ατονική σειρά, άρα μια ακολουθία από φθόγγους (που είναι έγκυρη αν έχει
 * 12 φθόγγους και κανένα διπλότυπο).
 */
public class AtonalRow implements Symmetry, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6572239890295999364L;
	private ArrayList<Note> notes;;

	public AtonalRow(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public ArrayList<Note> GetAtonalRow() {
		return notes;
	}

	@Override
	public void doNothing() throws SymmetryActionOnNonValidAtonalRow {
	}

	/**
	 * Γίνεται μια ολίσθηση ανάλογα με τον ακέραιο που δίνεται.
	 */
	@Override
	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
		String[] noteNames = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#",
				"A", "A#", "B" };
		for (Note n : notes) {
			for (int j = 0; j < noteNames.length; j++) {
				String s;
				String a = n.getNote();
				if (a.contains("#"))
					s = a.substring(0, 2);
				else
					s = a.substring(0, 1);
				if (s.equals((noteNames[j]))) {
					if (j + x <= 11) {
						n.setNote(a.replace(noteNames[j], noteNames[j + x]));
						break;
					} else {
						n.setNote(a
								.replace(noteNames[j], noteNames[j + x - 12]));
						break;
					}

				}
			}
		}
	}

	/**
	 * Αντιστρέφει την σειρά των φθόγγων της σύνθεσης
	 */
	@Override
	public void retrograde() throws SymmetryActionOnNonValidAtonalRow {
		Collections.reverse(notes);
	}

	/**
	 * Ανάκλαση του πολυγώνου γύρω από τον άξονα τουπου ορίζεται από ένα φθόγγο
	 * x και τον απέναντί του ((x+6) % 12).
	 */
	@Override
	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
		String[] noteNames = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#",
				"A", "A#", "B" };
		int refl = ((x + 6) % 12);
		if (refl >= 6) {
			refl -= 6;
		}
		int reflkatw = refl + 6;
		for (Note n : notes) {
			String s;
			String a = n.getNote();
			if (a.contains("#"))
				s = a.substring(0, 2);
			else
				s = a.substring(0, 1);
			for (int j = 0; j < noteNames.length; j++) {
				if (s.equals(noteNames[j])) {
					if (j == x || refl == j) {
						break;
					} else {
						int diaf = Math.abs(j - reflkatw);
						if (j - reflkatw > 0) {
							n.setNote(a.replace(noteNames[j],
									noteNames[Math.abs(j - diaf - diaf)]));
							break;
						} else {
							if (j + diaf + diaf > 11) {
								n.setNote(a.replace(noteNames[j], noteNames[j
										+ diaf + diaf - 12]));
								break;
							} else {
								n.setNote(a.replace(noteNames[j], noteNames[j
										+ diaf + diaf]));
								break;
							}
						}
					}
				}
			}
		}
	}

}