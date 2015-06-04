package Editor;

public class selectModeModel {
	private FreeMMCView freeView = new FreeMMCView();
	private Midi.Free free = new Midi.Free();
	private AtonalMMCView atonalView = new AtonalMMCView();
	private Midi.Atonal atonal = new Midi.Atonal();
	private AlgorithmicMMCView algoView = new AlgorithmicMMCView();
	private Midi.Algorithmic algo = new Midi.Algorithmic();

	public void freeMode() {
		new FreeMMCController(freeView, free);
		freeView.setVisible(true);
	}

	public void atonalMode() {
		new AtonalMMCController(atonalView, atonal);
		atonalView.setVisible(true);
	}

	public void algorithmicMode() {
		new AlgorithmicMMCController(algoView, algo);
		algoView.setVisible(true);
	}

	public void algorithmicMode(int k) {
		algo.generateNotes(k);
		new AlgorithmicMMCController(algoView, algo);
		algoView.setVisible(true);
	}

	public Midi.Free getFree() {
		return free;
	}

	public Midi.Atonal getAtonal() {
		return atonal;
	}

	public Midi.Algorithmic getAlgo() {
		return algo;
	}
	
}
