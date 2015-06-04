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
	 * Contractor ��� ����� ��� �� ����� null
	 */
	public playerModel() {
		Collection x = new Collection("First");
		collections.add(x);
	}

	/**
	 * Contractor ��� ������� ��� collection
	 * 
	 * @param collection
	 *            �� Collection �� �����
	 */
	public playerModel(Collection collection) {
	}

	public void addCollection(String name) {
		Collection x = new Collection(name);
		collections.add(x);
	}

	/**
	 * ��������� �� ������� ������
	 * 
	 * @param x
	 *            � ���� ��� ������� ���� �����
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
	 * ��������� ��� �� ������ ��� ���� ������
	 * 
	 * @param x
	 *            �� path ��� �������
	 */
	public void addFolder(String x) {
	}

	/**
	 * ������� ��� ������������ Collection ��� ��� ������
	 * 
	 * @param x
	 *            �� path ��� �������
	 * @throws IOException
	 */
	public void openCollection(String x, int tab) throws IOException {
		collections.get(tab).openCollection(x);
	}

	/**
	 * ���������� �� Collection
	 * 
	 * @throws FileNotFoundException
	 */
	public void saveCollection(int tab) throws FileNotFoundException {
		collections.get(tab).saveCollection();
	}

	/**
	 * �������� ��� ���� ���� ����� ��� �������
	 * 
	 * @param x
	 *            � ���� ���� ����� ��� ��������� ��� �� ������
	 */
	public void moveUp(int x) {
	}

	/**
	 * ��������� ��� ������
	 * 
	 * @param x
	 */
	public void moveDown(int x) {
	}

	/**
	 * ������ ��� ������� ��� ��� �����
	 * 
	 * @param x
	 *            � ���� ��� ���������
	 */
	public void remove(int x) {
	}

	/**
	 * ��������� ��������� �� �������
	 */
	public void pause() {
	}

	/**
	 * ��������� �������� �� �������
	 */
	public void stop() {
	}

	/**
	 * �������� �� �������
	 */
	public void play() {
	}

	/**
	 * ���������� �� Composition ��� ����� x
	 * 
	 * @param �
	 *            ���� ��� �� ����������.
	 * @return
	 */
	public ArrayList<Note> getComposition(int x, int y) {
		return collections.get(x).getNotes(y);
	}

}
