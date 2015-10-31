package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private JPanel mainPanel;
	private IInvertedIndexView mainView;
        private final String iconPath;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		/** Frame setup */
		this.setTitle("InvertedIndex");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 800, 350);
		iconPath = "src/robin.png";
                ImageIcon img = new ImageIcon(iconPath);
                setIconImage(img.getImage());
		this.setLocationRelativeTo(null);
	}

	public void renderMainView() {
		/** Show Chat View */
		mainView = new InvertedIndexView(this);
                frameRevalidate();
		this.setContentPane((JPanel) mainView);
	}
	
        public void frameRevalidate()
	{
		validate();
		repaint();
		setVisible(true);
	}

}
