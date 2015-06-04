package Editor;

public class selectModeMain {

	public static void main(String[] args) {
		selectModeModel theModel = new selectModeModel();
		selectMode theView = new selectMode();
		new selectModeController(theView, theModel);
		theView.setVisible(true);
	}

}
