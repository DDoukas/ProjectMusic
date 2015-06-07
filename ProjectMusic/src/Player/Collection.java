package Player;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Midi.Composition;
import Midi.Note;

public class Collection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8695929870480157180L;

	public static String collectionsPath = new java.io.File("Collections").getAbsolutePath();
	
	private String name = null;
	private List<Composition> compositions = new ArrayList<Composition>();

	public Collection(String name) {
		this.name = name;
	}

	public Collection(List<Composition> compositions) {
		this.compositions = compositions;
	}

	public ArrayList<Note> getNotes(int x) {
		return compositions.get(x).getNotes();
	}

	public void addSong(Composition x) {
		compositions.add(x);
	}

	public void deleteSong(int x) {
		compositions.remove(x);
	}
	
	public void moveSongUp(int x) {
		if (x > 0)
			Collections.swap(compositions, x, x - 1);
	}

	public void moveSongDown(int x) {
		if (x + 1 < compositions.size())
			Collections.swap(compositions, x, x + 1);
	}

	public void saveCollection() {
		saveCollectionAs("Collections\\" + name + ".clxn");
	}
	
	public void saveCollectionAs(String filename) {
		try {
			File f;
			if (filename.contains("."))
				f = new File(filename);
			else
				f = new File(filename + ".clxn");
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(f));
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public List<Composition> getCompositions() {
		return compositions;
	}
}
