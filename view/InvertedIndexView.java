package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

//import controller.BacktrackController;
//import controller.StringAlignerController;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class InvertedIndexView extends JPanel implements IInvertedIndexView, ActionListener, KeyListener  {
	private MainFrame mainFrame;

	/** Controller */
	//private StringAlignerController controller;
	// BacktrackController backtrackController;
	
        private Object [][] grid;
        private Object [][] results;
        private DefaultTableModel model;
        private ArrayList<Integer> backtrackPath;

            /** Panel components */
        private JTable table;
        private JTable tableResults;
        private JButton btnAlign;
        private JTextField txtFirstWord;
        private JTextField txtSecondWord;
        private JLabel firstWord;
        private JLabel secondWord;
        private JScrollPane scrollPane;

    public InvertedIndexView(MainFrame mainFrame) {
            setLayout(null);
           // controller = new StringAlignerController(this);
           // backtrackController = new BacktrackController(this);

            //JLabel lblSex = new JLabel("SEX");
            //lblSex.setBounds(216, 5, 18, 14);
            //add(lblSex);
            
            firstWord = new JLabel();
            firstWord.setSize(200, 10);
            firstWord.setLocation(30, 100);
            secondWord = new JLabel();
            secondWord.setSize(200, 10);
            secondWord.setLocation(30, 120);
            add(firstWord);
            add(secondWord);
            firstWord.setVisible(false);
            secondWord.setVisible(false);
            
            Object rowData[][] = {}; // dummy data
            Object columnNames[] = {}; // dummy data
            
            tableResults = new JTable(rowData, columnNames); // dummy data
            model = new DefaultTableModel(rowData,columnNames); // dummy data
            tableResults.setModel(model); // dummy data
            tableResults.setBounds(95, 100, 250, 30);
            tableResults.setBackground(this.getBackground()); // comoflauge
            tableResults.setShowGrid(false); // remove border
           // add(tableResults);

            txtFirstWord = new JTextField();
            txtFirstWord.setText("First word");
            txtFirstWord.setBounds(61, 219, 86, 20);
            //add(txtFirstWord);
            txtFirstWord.setColumns(10);
            txtFirstWord.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            txtFirstWord.setText("");
                }
             });

            txtSecondWord = new JTextField();
            txtSecondWord.setText("Search");
            txtSecondWord.setBounds(275, 280, 86, 23);
            add(txtSecondWord);
            txtSecondWord.setColumns(10);
            txtSecondWord.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            txtSecondWord.setText("");
                }
             });
            
            btnAlign = new JButton("Search");
            btnAlign.setBounds(375, 280, 89, 23);
            add(btnAlign);
            btnAlign.addActionListener(this);
            
            //rowData[][] = {};
            //columnNames[] = {};
            table = new JTable(rowData, columnNames);
            
       
            scrollPane = new JScrollPane();
            model = new DefaultTableModel(rowData,columnNames);
            table.setModel(model);
            
            scrollPane.setBounds(20, 10, 750, 260);
            scrollPane.setViewportView(table);
            scrollPane.getViewport().setBackground(Color.LIGHT_GRAY);
            add(scrollPane);
    
    }


    public void DisplayTable(Object [][] data)
    {
        ArrayList<String> col = new ArrayList<>();
        for(int i=0; i< data[0].length; i++)
            col.add("");
       String column[]=col.toArray(new String[col.size()]);
       // table = new JTable(data, col );
        model = new DefaultTableModel(data,column);
        table.setModel(model);
      
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    //		if(ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getSource() == chatInputTxtField)	{
    //            
    //		}
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        System.out.println("hello");
    }
    
    


      
}