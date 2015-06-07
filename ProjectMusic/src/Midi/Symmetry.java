package Midi;

/**
 * � ������� ���� ����������� ��� ��� AtonalRow ��� AtonalComposition 
 * ��� �������� ��� �������� ��� ��� ������� �������� �������� ��������. 
 */
public interface Symmetry {

	public void doNothing() throws SymmetryActionOnNonValidAtonalRow;

	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow;

	public void retrograde() throws SymmetryActionOnNonValidAtonalRow;

	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow;

}