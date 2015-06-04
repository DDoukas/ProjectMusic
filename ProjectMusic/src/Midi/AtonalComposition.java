package Midi;

import java.io.Serializable;
import java.util.ArrayList;

public class AtonalComposition implements Symmetry, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9206954243313753918L;
	int actions = 0;
	String[] seq = new String[100000];
	String[] acperf = new String[100000];
	String[] praxeis = new String[100000];
	AtonalRow seed;

	public AtonalComposition(ArrayList<Note> seed) {
		this.seed = new AtonalRow(seed);
		praxeis[0] = "a";
		// actions++;
	}

	public String getAtonalComposition() {
		return null;
	}

	@Override
	public void doNothing() throws SymmetryActionOnNonValidAtonalRow {
		int k = 0;
		for (int i = ((int) Math.pow(2, actions)); i < ((int) Math.pow(2,
				actions) * 2); i++) {
			praxeis[i] = praxeis[k] + "-doNothing";
			k++;
		}
		seq[actions] = Integer.toString(actions);
		acperf[actions] = "doNothing";
		actions++;

	}

	@Override
	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
		int k = 0;
		for (int i = ((int) Math.pow(2, actions)); i < ((int) Math.pow(2,
				actions) * 2); i++) {
			praxeis[i] = (praxeis[k] + "-transpose," + x);
			k++;
		}
		acperf[actions] = "transpose";
		seq[actions] = Integer.toString(actions);
		actions++;

	}

	@Override
	public void retrograde() throws SymmetryActionOnNonValidAtonalRow {
		int k = (int) Math.pow(2, actions) - 1;
		for (int i = ((int) Math.pow(2, actions)); i < ((int) Math.pow(2,
				actions) * 2); i++) {
			praxeis[i] = (praxeis[k] + "-retrograde");
			k--;
		}
		acperf[actions] = "retrograde";
		seq[actions] = Integer.toString(actions);
		actions++;
	}

	@Override
	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
		int k = 0;
		for (int i = ((int) Math.pow(2, actions)); i < ((int) Math.pow(2,
				actions) * 2); i++) {
			praxeis[i] = praxeis[k] + ("-reflect," + x);
			k++;
		}
		acperf[actions] = "reflect";
		seq[actions] = Integer.toString(actions);
		actions++;
	}

	public ArrayList<Note> getMusic() throws SymmetryActionOnNonValidAtonalRow {
		ArrayList<Note> notes = seed.GetAtonalRow();
		int k = (int) Math.pow(2, actions);
		for (int i = 1; i < k; i++) {
			String[] a = praxeis[i].split("-");
			// System.out.println(praxeis[i]);
			int leng = a.length;
			AtonalRow p = new AtonalRow(seed.GetAtonalRow());
			for (int j = 1; j < leng; j++) {

				if (a[j].equals("doNothing")) {
					seed.doNothing();
				}
				if (a[j].equals("retrograde")) {
					seed.retrograde();

				}
				if (a[j].contains("transpose")) {
					String[] numb = a[j].split(",");
					seed.transpose(Integer.parseInt(numb[1]));

				}
				if (a[j].contains("reflect")) {
					String[] numb = a[j].split(",");
					seed.reflect(Integer.parseInt(numb[1]));
				}
			}
			notes.addAll(seed.GetAtonalRow());
			seed = p;
		}
		return notes;
	}

}