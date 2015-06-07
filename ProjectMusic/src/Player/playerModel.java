package Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import Midi.Composition;

/**
 * 
 * H κλάση αυτή είναι υπεύθυνη για όλες τις λειτουργίες του προγράμματος
 * αναπαραγωγής μουσικής και διαχείρισης των μουσικών συλλογών. Περιγράφει τα
 * δεδομένα, τη συμπεριφορά τους και το σύνολο των κανόνων που τα διέπει.
 * 
 */
public class playerModel {
	private List<Collection> collections = new ArrayList<Collection>();

	/**
	 * Contractor που θέτει όλα τα πεδία null
	 */
	public playerModel() {
		Collection x = new Collection("First");
		collections.add(x);
	}

	public void addCollection(Collection c) {
		collections.add(c);
	}

	/**
	 * Προσθέτει το μουσικό αρχείο
	 * 
	 * @param x
	 *            Η θέση του αρχείου στον δίσκο
	 * @return
	 * 
	 */
	public Composition addFile(File f, int tab) {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(f));
			Composition c = (Composition) ois.readObject();
			ois.close();
			collections.get(tab).addSong(c);
			return c;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * Αποθηκεύει το Collection
	 * 
	 */
	public void saveCollection(int tab) {
		collections.get(tab).saveCollection();
	}

	/**
	 * Αποθηκεύει το Collection
	 * 
	 */
	public void saveCollectionAs(int tab, String filename) {
		collections.get(tab).saveCollectionAs(filename);
	}

	/**
	 * Ανεβάζει πιο ψηλά στην λιστα ένα κομματι
	 * 
	 * @param x
	 *            Η θέση στην λίστα του κομματιου που θα ανέβει
	 */
	public void moveUp(int x, int y) {
		collections.get(x).moveSongUp(y);
	}

	/**
	 * Κατεβάζει πιο χαμηλα
	 * 
	 * @param x
	 */
	public void moveDown(int x, int y) {
		collections.get(x).moveSongDown(y);
	}

	/**
	 * Σβήνει ένα κομμάτι απο την λίστα
	 * 
	 * @param x
	 *            Η θέση της συλλογής
	 * @param y
	 *            Η θέση του κομματιού
	 */
	public void remove(int x, int y) {
		collections.get(x).deleteSong(y);
	}

	/**
	 * Επιστρέφει το Composition της θέσης x
	 * 
	 * @param x
	 *            η θέση που θα επιστραφεί.
	 * @return
	 */
	public List<Composition> getCompositions(int x) {
		return collections.get(x).getCompositions();
	}

	public List<Collection> getCollections() {
		return collections;
	}

}
