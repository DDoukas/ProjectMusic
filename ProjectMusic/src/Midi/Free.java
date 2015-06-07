package Midi;

import java.util.ArrayList;

/**Η κλάση αυτή είναι υποκλάση της Composition χρησιμεύει στη 
 * δημιουργία μιας ελεύθερης σύνθεσης.
 */
public class Free extends Composition {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6316115906802889240L;

	/**
	 * Constructor που δεν δέχεται ορίσματα
	 */
	public Free() {
		super();
		this.setType("Free");
	}

	/**
	 * Contructor που δέχεται ορίσματα
	 * 
	 * @param notes
	 * @param instrument
	 * @param artistName
	 * @param compositionName
	 */
	public Free(ArrayList<Note> notes, String instrument, String artistName,
			String compositionName) {
		super(notes, instrument, artistName, compositionName);
		this.setType("Free");
	}

}