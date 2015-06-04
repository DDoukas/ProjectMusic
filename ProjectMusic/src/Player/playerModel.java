package Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Midi.Algorithmic;
import Midi.Atonal;
import Midi.Free;
import Midi.Note;

public class playerModel {
	private List<Collection> collections = new ArrayList<Collection>();

	/**
	 * Contractor που θέτει όλα τα πεδία null
	 */
	public playerModel() {
		Collection x = new Collection("First");
		collections.add(x);
	}

	/**
	 * Contractor που δέχεται ένα collection
	 * 
	 * @param collection
	 *            το Collection σε λιστα
	 */
	public playerModel(Collection collection) {
	}

	public void addCollection(String name) {
		Collection x = new Collection(name);
		collections.add(x);
	}

	/**
	 * Προσθέτει το μουσικό αρχείο
	 * 
	 * @param x
	 *            Η θέση του αρχείου στον δίσκο
	 * @return
	 * @throws IOException
	 */
	public String[] addFile(String x, int tab) throws IOException {
		String k;
		String[] p = null;
		/*BufferedReader br = new BufferedReader(new FileReader(x));
		k = br.readLine();

		p = k.split(",");
		k = p[3];

		if (k.equals("Free")) {
			Free tragoudi = new Free(p[0], p[1], p[2], p[3]);
			tragoudi.open(x);
			collections.get(tab).addSong(tragoudi);
		} else if (k.equals("Atonal")) {
			Atonal tragoudi = new Atonal(p[0], p[1], p[2], p[3]);
			collections.get(tab).addSong(tragoudi);

		} else {
			Algorithmic tragoudi = new Algorithmic(p[0], p[1], p[2], p[3]);
			collections.get(tab).addSong(tragoudi);

		}
		br.close();*/
		
		
		return p;
	}

	/**
	 * Προσθέτει όλα τα άρχεια από έναν φάκελο
	 * 
	 * @param x
	 *            Το path του φακέλου
	 */
	public void addFolder(String x) {
	}

	/**
	 * Ανοίγει ένα συγκεκριμένο Collection απο τον σκληρό
	 * 
	 * @param x
	 *            Το path του αρχείου
	 * @throws IOException
	 */
	public void openCollection(String x, int tab) throws IOException {
		collections.get(tab).openCollection(x);
	}

	/**
	 * Αποθηκεύει το Collection
	 * 
	 * @throws FileNotFoundException
	 */
	public void saveCollection(int tab) throws FileNotFoundException {
		collections.get(tab).saveCollection();
	}

	/**
	 * Ανεβάζει πιο ψηλά στην λιστα ένα κομματι
	 * 
	 * @param x
	 *            Η θέση στην λίστα του κομματιου που θα ανέβει
	 */
	public void moveUp(int x) {
	}

	/**
	 * Κατεβάζει πιο χαμηλα
	 * 
	 * @param x
	 */
	public void moveDown(int x) {
	}

	/**
	 * Σβήνει ένα κομμάτι απο την λίστα
	 * 
	 * @param x
	 *            Η θέση του κομματιού
	 */
	public void remove(int x) {
	}

	/**
	 * Διακόπτει προσωρινά το κομμάτι
	 */
	public void pause() {
	}

	/**
	 * Διακόπτει οριστικά το κομμάτι
	 */
	public void stop() {
	}

	/**
	 * Ξεκινάει το κομμάτι
	 */
	public void play() {
	}

	/**
	 * Επιστρέφει το Composition της θέσης x
	 * 
	 * @param η
	 *            θέση που θα επιστραφεί.
	 * @return
	 */
	public ArrayList<Note> getComposition(int x, int y) {
		return collections.get(x).getNotes(y);
	}

}
