package Midi;

import java.util.ArrayList;

public class Free extends Composition {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6316115906802889240L;

	/**
	 * Constructor ��� ������ ��� ���� ����� ���� ���� ��� string
	 */
	public Free() {
		super();
		this.setEidos("Free");
	}

	/**
	 * Contructor ��� ������� ��� string ��� �������������� ��� ������������ ���
	 * ����� ������ ������ ���������� �� ��� ��������� ��� �� ���� �������
	 * (�,�#,�,C,C#,D,D#,E,F,F#,G,G#)
	 */
	public Free(ArrayList<Note> notes, String instr, String onomsinth, String compname) {
		super(notes, instr, onomsinth, compname);
		this.setEidos("Free");
	}

}