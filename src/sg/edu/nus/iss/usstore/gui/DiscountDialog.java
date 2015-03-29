
package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
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
import javax.swing.text.Caret;

import sg.edu.nus.iss.usstore.domain.*;
import sg.edu.nus.iss.usstore.util.DigitDocument;
import sg.edu.nus.iss.usstore.util.StringDocument;
import sg.edu.nus.iss.usstore.util.Util;
package sg.edu.nus.iss.usstore.util;
public class DiscountDialog extends JDialog{

	
	private static final long serialVersionUID = 1L;
	private StoreApplication manager;
	private StoreWindow mainScreen;
	private int index;
	private JTextField discountCodeText;
	private JTextField descriptionDescriptionText;
	private JTextField percentText;
	private JTextField startDateText;
	private JTextField periodText;
	private JTextField applicableText;
	
	
	public DiscountDialog(StoreApplication manager, String title){
		super(manager.getStoreWindow(),title);
		this.manager = manager;
		this.mainScreen = manager.getStoreWindow();
		initGUI();
		getContentPane().add("South",createAddBottomPanel());
		
	}
	
	public DiscountDialog(StoreApplication manager,String title,int index){
		super(manager.getStoreWindow(),title);
		this.manager = manager;
		this.mainScreen = manager.getStoreWindow();
		this.index = index;
		initGUI();
		getContentPane().add("South",createModifyBottomPanel());
		Discount d= manager.getDiscountList().get(index);
		setData(d.getDiscountcode(),d.getDiscountDescription(),d.getStartDate(),(int) d.getPercent(),d.getPeriod(),d.getApplicable());
		discountList.setEnabled(false);
	}
	
	
		
	
	private void initGUI() {
		try {
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add("Center",createCenterPanel());
			setSize(400, 300);
			setLocationRelativeTo(null);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private JPanel createCenterPanel(){
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(10, 10, 0, 10));
		
		JPanel panel = new JPanel(new GridLayout(9,1));
		panel.add(new JLabel("DiscountCode"));
		panel.add(new JLabel("Discount Description"));
		panel.add(new JLabel("Start Date"));
		panel.add(new JLabel("Percent"));
		panel.add(new JLabel("Period"));
		panel.add(new JLabel("Applicable"));
		p.add("West",panel);
		
		
		loadDiscountList();
		discountCodeText = new JTextField();
		discountCodeText.setDocument(new StringDocument());
		descriptionDescriptionText = new JTextField();
		descriptionDescriptionText.setDocument(new StringDocument());
		startDateText = new JTextField();
		startDateText.setDocument(Util.castDate(Date);
		percentText = new JTextField();
		percentText.setDocument(Util.castDouble(s) );
		periodText = new JTextField();
		periodText.setDocument(util.);
		applicableText = new JTextField();
		applicableText.setDocument(new StringDocument());
		panel = new JPanel(new GridLayout(9,1));
		panel.add(discountCodeText);
		panel.add(descriptionDescriptionText);
		panel.add(startDateText);D
		panel.add(percentText);
		panel.add(periodText);
		panel.add(applicableText);
		p.add("Center",panel);
		
		return p;
	}
	
	public void loadDiscountList(){
		int lenght = manager.getDiscountList().size();
		if(lenght>0){
			for(int i=0;i<lenght;i++){
				discountList.addItem(manager.getDiscountList());
			}
			discountList.updateUI();
		}
	}
	
	public void setData(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String Applicable){
		
		discountCodeText.setText(discountCode);
		descriptionDescriptionText.setText(discountDescription);
		startDateText.setDocument(new DigitDocument() );
		percentText.setText(Double.toString(percent));
		periodText.setText(Integer.toString(period));
		applicableText.setText(Applicable);
			}

	
