package sg.edu.nus.iss.usstore.util;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlertDialog extends JDialog{

	private JLabel msgLabel;
	public AlertDialog(){
		super(new JFrame(),"Alert");
		initGUI();
	}
	
	public AlertDialog(String msg){
		super();
		initGUI();
		msgLabel.setText(msg);
	}
	
	public AlertDialog(String title, String msg){
		super(new JFrame(),title);
		initGUI();
		msgLabel.setText(msg);
	}
	
	private void initGUI(){
		setLayout(new FlowLayout());
		Dimension size = new Dimension(300,200);
		setSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setVisible(true);
		setModal(true);
		setLocationRelativeTo(null);
		msgLabel = new JLabel();
		
	}
}
