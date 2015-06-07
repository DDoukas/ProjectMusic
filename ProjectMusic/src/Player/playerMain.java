package Player;

/**
 * 
 * Περιέχει τη main μέσω της οποίας ξεκινάει το πρόγραμμα.
 *
 */
public class playerMain {
	public static void main(String args[]) {
		playerModel theModel = new playerModel();
		playerView theView = new playerView();
		new playerController(theView, theModel);
		theView.setVisible(true);
	}
}
