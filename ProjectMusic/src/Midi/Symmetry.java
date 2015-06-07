package Midi;

/**
 * Η διεπαφή αυτή υλοποιείται από τις AtonalRow και AtonalComposition 
 * και περιέχει τις μεθόδους για τις ανάγκες σύνθεσης ατονικής μουσικής. 
 */
public interface Symmetry {

	public void doNothing() throws SymmetryActionOnNonValidAtonalRow;

	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow;

	public void retrograde() throws SymmetryActionOnNonValidAtonalRow;

	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow;

}