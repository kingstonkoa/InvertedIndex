package driver;

import utilities.TxtReader;
import view.MainFrame;

public class Driver {
	public static void main(String[] args) {
            TxtReader txtReader = new TxtReader();
            new MainFrame().renderMainView();
	}
}
