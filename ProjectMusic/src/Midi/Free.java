package Midi;

import java.util.ArrayList;

/**� ����� ���� ����� �������� ��� Composition ���������� ��� 
 * ���������� ���� ��������� ��������.
 */
public class Free extends Composition {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6316115906802889240L;

	/**
	 * Constructor ��� ��� ������� ��������
	 */
	public Free() {
		super();
		this.setType("Free");
	}

	/**
	 * Contructor ��� ������� ��������
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