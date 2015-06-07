package Midi;

/**
 * � ����� ���� ����� �������� ��� Exception ��� ���������� ��� �� ����� throw
 * ���� ���������� ��� ����������� ���� Symmetry ���������� ��� ������
 * ���������� � ��� �� ������ ��� ��� 12 �����.
 */
public class SymmetryActionOnNonValidAtonalRow extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2767450086273572250L;

	// Parameterless Constructor

	public SymmetryActionOnNonValidAtonalRow() {
	}

	// Constructor that accepts a message
	public SymmetryActionOnNonValidAtonalRow(String message) {
		super(message);
	}

	public SymmetryActionOnNonValidAtonalRow(Throwable cause) {
		super(cause);
	}

	public SymmetryActionOnNonValidAtonalRow(String message, Throwable cause) {
		super(message, cause);
	}
}