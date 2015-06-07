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
 * H ����� ���� ����� �������� ��� ���� ��� ����������� ��� ������������
 * ������������ �������� ��� ����������� ��� �������� ��������. ���������� ��
 * ��������, �� ����������� ���� ��� �� ������ ��� ������� ��� �� ������.
 * 
 */
public class playerModel {
	private List<Collection> collections = new ArrayList<Collection>();

	/**
	 * Contractor ��� ����� ��� �� ����� null
	 */
	public playerModel() {
		Collection x = new Collection("First");
		collections.add(x);
	}

	public void addCollection(Collection c) {
		collections.add(c);
	}

	/**
	 * ��������� �� ������� ������
	 * 
	 * @param x
	 *            � ���� ��� ������� ���� �����
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
	 * ���������� �� Collection
	 * 
	 */
	public void saveCollection(int tab) {
		collections.get(tab).saveCollection();
	}

	/**
	 * ���������� �� Collection
	 * 
	 */
	public void saveCollectionAs(int tab, String filename) {
		collections.get(tab).saveCollectionAs(filename);
	}

	/**
	 * �������� ��� ���� ���� ����� ��� �������
	 * 
	 * @param x
	 *            � ���� ���� ����� ��� ��������� ��� �� ������
	 */
	public void moveUp(int x, int y) {
		collections.get(x).moveSongUp(y);
	}

	/**
	 * ��������� ��� ������
	 * 
	 * @param x
	 */
	public void moveDown(int x, int y) {
		collections.get(x).moveSongDown(y);
	}

	/**
	 * ������ ��� ������� ��� ��� �����
	 * 
	 * @param x
	 *            � ���� ��� ��������
	 * @param y
	 *            � ���� ��� ���������
	 */
	public void remove(int x, int y) {
		collections.get(x).deleteSong(y);
	}

	/**
	 * ���������� �� Composition ��� ����� x
	 * 
	 * @param x
	 *            � ���� ��� �� ����������.
	 * @return
	 */
	public List<Composition> getCompositions(int x) {
		return collections.get(x).getCompositions();
	}

	public List<Collection> getCollections() {
		return collections;
	}

}
