
package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sg.edu.nus.iss.usstore.domain.*;
import sg.edu.nus.iss.usstore.util.DigitDocument;

public class DiscountDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StoreApplication manager;
	private StoreWindow mainScreen;
	private int index;
	
	private JTextField DiscountCode;
	private JTextField DiscountDescription;
	//private JTextField categoryText;
	
	private JTextField discountCodeText;
	private JTextField DiscountDescriptionText;
	private JTextField PercentText;
	private JTextField ApplicableText;
	private JTextField PeriodText;
	private JTextField orderQtyText;
	
	private JTextField StartDateText;
	
	public DiscountDialog(StoreApplication manager, String title){
		super(manager.getStoreWindow(),title);
		this.manager = manager;
		this.mainScreen = manager.getStoreWindow();
		this.index = manager.getProductList().size()+1;
		initGUI();
		add("South",createCenterPanel());
	}
	
	public DiscountDialog(StoreApplication manager,String title,int index){
		super(manager.getStoreWindow(),title);
		this.manager = manager;
		this.mainScreen = manager.getStoreWindow();
		this.index = index;
		initGUI();
		add("South",createModifyBottomPanel());
		Discount d = manager.get(index);
		setData(d.getDiscountcode(),d.getDiscountDescription(),d.getStartDate(),d.getPercent(),d.getPeriod(),d.getApplicable());
	}
	


	private Component createModifyBottomPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private void initGUI() {
		try {
			setLayout(new BorderLayout());
			add("Center",createCenterPanel());
			setSize(400, 300);
			setLocationRelativeTo(null);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private JPanel createCenterPanel(){
		JPanel d = new JPanel(new BorderLayout());
		d.setBorder(new EmptyBorder(10, 10, 0, 10));
		
		JPanel panel = new JPanel(new GridLayout(9,1));
		panel.add(new JLabel("DiscountCode "));
		panel.add(new JLabel("DiscountDescription "));
		panel.add(new JLabel("StartDate "));
		panel.add(new JLabel("Percentage "));
		panel.add(new JLabel("Period "));
		panel.add(new JLabel("Applicable "));
		d.add("West",panel);
		
		
		loadDiscountList();
		discountCodeText = new JTextField();
		discountCodeText.setEditable(false);
		//categoryText = new JTextField();
		DiscountDescriptionText = new JTextField();
		DiscountDescriptionText.setEditable(false);
		StartDateText = new JTextField();
		
		PercentText = new JTextField();
		PercentText.setEditable(false);
		PeriodText = new JTextField();
		PeriodText.setEditable(false);
		ApplicableText = new JTextField();
		ApplicableText.setEditable(false);
		
		panel = new JPanel(new GridLayout(6,1));
		panel.add(DiscountCode);
		panel.add(DiscountDescriptionText);
		panel.add(StartDateText);
		panel.add(PercentText);
		panel.add(PeriodText);
		panel.add(ApplicableText);
		;
		d.add("Center",panel);
		
		return d;
	}
	
	
	
	private void loadDiscountList() {
		// TODO Auto-generated method stub
		
	}

	private void setData(String discountCode, String discountDescription,
			Date startDate, double percent, int period, String applicable) {
		// TODO Auto-generated method stub
	}
	
		
	
	
	
}
