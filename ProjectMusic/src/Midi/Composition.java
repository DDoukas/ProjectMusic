package Midi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.jfugue.player.Player;

/**
 * A�������� ����� ��� ��������� ���� ��� ������� ��� ���������� �� ��� �����
 * �������� ���������
 * 
 */
public abstract class Composition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7307941895975216946L;

	public static String compositionsPath = new java.io.File("Compositions")
			.getAbsolutePath();

	// � ����� ��� �������� �� ��� ����� ��� ���������
	private ArrayList<Note> notes;

	private String instrument;
	private String artistName;
	private String compositionName = "";
	private String type; // ������ �� ����� "Free", "Atonal" � "Algorithmic"

	/**
	 * Constractor ��� ��� ������� ��������
	 */
	public Composition() {
		this.notes = new ArrayList<Note>();
		this.instrument = "I[Piano]";
		this.artistName = "";
		this.compositionName = "";
	}

	/**
	 * Constructor ��� ������� ��������
	 */
	public Composition(ArrayList<Note> notes, String instr, String artistName,
			String compositionName) {
		this.notes = notes;
		this.instrument = instr;
		this.artistName = artistName;
		this.compositionName = compositionName;
	}

	/**
	 * ���������� �� snthz ������ ��� ������� ��� ������� ��� ����������� ���
	 * �������� ������ �� ���� ��� ������������ �� �� ����� ��� ���� �����������
	 * ��������
	 * 
	 */
	public void save() {
		if (compositionName.isEmpty()) {
			compositionName = "unnamed";
		}
		saveAs("Compositions\\" + compositionName + ".snthz");
	}

	/**
	 * ���������� �� snthz ������ ��� ������� ��� ������� ��� ����������� ���
	 * �������� ������ �� ���� ��� ������������ �� �� ����� ��� ����� ������ ���
	 * ������ � �������
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
	 * ���������� ��� ����� ���� ����� Composition �� ������ ��� ����� ���
	 * ������
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
	 * ���������� ��� ���� n
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
	 * @return ���������� ��� String �� ���� ��� ����� ��� ��������
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