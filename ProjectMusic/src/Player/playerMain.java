package Player;

public class playerMain {
	public static void main(String args[]) {
		playerModel theModel = new playerModel();
		playerView theView = new playerView();
		new playerController(theView, theModel);
		theView.setVisible(true);
	}
}
