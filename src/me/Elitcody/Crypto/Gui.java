package me.Elitcody.Crypto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Gui {
	 	private JFrame frame;
	    private JLabel label;
	    private JTextArea inputUML;
	    private JButton button;
	    // Don't give a method the same name as a class!!
	    public void initGui(){
	        frame = new JFrame();
	        
	        frame.setSize(300, 400);
	        //frame.setLocationRelativeTo(null);    // do something better
	        frame.setLocationByPlatform(true);  // better!
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setTitle("Enrypt a message into image");

	        JPanel CreationPanel = new JPanel();
	        CreationPanel.setLayout(new BorderLayout());

	        label = new JLabel("Write here the message");
	        CreationPanel.add(label,BorderLayout.NORTH);

	        inputUML = new JTextArea("",7,30);
	        // very important next 2 lines
	        inputUML.setLineWrap(true);
	        inputUML.setWrapStyleWord(true);
	        // add it to a scrollpane
	        CreationPanel.add(new JScrollPane(inputUML),BorderLayout.CENTER);
	        CreationPanel.add(button,BorderLayout.CENTER);

	        frame.add(CreationPanel);
	        

	        frame.pack();   // assume the natural size!
	        frame.setVisible(true);

//	        for (int ii=0; ii<150; ii++) {
//	            inputUML.append(SENTENCE);
//	            inputUML.setCaretPosition( inputUML.getText().length() );
//	        }
	    }

}
