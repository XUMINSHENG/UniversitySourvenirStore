package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sg.edu.nus.iss.usstore.domain.MemberDiscount;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataInputException;
import sg.edu.nus.iss.usstore.util.Util;
/**
 * 
 * @author tanuj
 *
 */
public class DiscountDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField DiscountCode;
	private JTextField DiscountDescription;
	private JTextField StartDate;
	private JTextField Period;
	private JTextField Percent;
	private JTextField Applicable;

	//private DiscountMgr discountlist;

	private JRadioButton rdbtnOcaDisc;
	private JRadioButton rdbtnMemDisc;
	
	private StoreApplication manager;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DiscountDialog dialog = new DiscountDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DiscountDialog(StoreApplication manager){
		super(manager.getStoreWindow(),"Add New Discount");
		this.manager = manager;
		initGUI();
		createTopButton();
		createAddButton();
	}
	
	public DiscountDialog(StoreApplication manager, String code,boolean ifMember){
		super(manager.getStoreWindow());
		this.manager = manager;
		initGUI();
		createModiyButton();
		createDeleteButton();
		if(ifMember){
			setTitle("Member Discount");
			StartDate.setEditable(false);
			StartDate.setText("ALWAYS");
			Period.setEditable(false);
			Period.setText("ALWAYS");
			Applicable.setText("M");
			
		}else{
			setTitle("Ocassional Discount");
			Applicable.setText("A");
		}
	}
	
	private void createTopButton(){
		rdbtnMemDisc = new JRadioButton("Member Discount");
		rdbtnMemDisc.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED){
					Applicable.setText("M");
					StartDate.setText("Always");
					Period.setText("Always");
					StartDate.setEditable(false);
					Period.setEditable(false);
				}
				
					
			}
		});
		
		rdbtnMemDisc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMemDisc.setBounds(6, 7, 160, 23);
		contentPanel.add(rdbtnMemDisc);

		rdbtnOcaDisc = new JRadioButton("Ocassional Discount");
		rdbtnOcaDisc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnOcaDisc.setBounds(187, 7, 200, 23);
		contentPanel.add(rdbtnOcaDisc);
		rdbtnOcaDisc.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED){
					Applicable.setText("A");
				    StartDate.setText(null);
				    Period.setText(null);
				    StartDate.setEditable(true);
				    Period.setEditable(true);
				}
			}
		});

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMemDisc);
		group.add(rdbtnOcaDisc);
	}

	private void initGUI() {
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblDiscountcode = new JLabel("Discount Code:");
		lblDiscountcode.setBounds(6, 37, 100, 23);
		contentPanel.add(lblDiscountcode);

		DiscountCode = new JTextField();
		DiscountCode.setBounds(140, 38, 200, 20);
		contentPanel.add(DiscountCode);
		DiscountCode.setColumns(10);

		JLabel lblDiscountDescription = new JLabel("Discount Description :");
		lblDiscountDescription.setBounds(6, 63, 125, 14);
		contentPanel.add(lblDiscountDescription);

		DiscountDescription = new JTextField();
		DiscountDescription.setBounds(140, 60, 200, 20);
		contentPanel.add(DiscountDescription);
		DiscountDescription.setColumns(10);

		JLabel lblPercent = new JLabel("Percent :");
		lblPercent.setBounds(6, 88, 99, 14);
		contentPanel.add(lblPercent);
		
		JLabel lblStartDate = new JLabel("Start Date :");
		lblStartDate.setBounds(6, 113, 99, 14);
		contentPanel.add(lblStartDate);

		StartDate = new JTextField();
		StartDate.setBounds(140, 110, 200, 20);
		contentPanel.add(StartDate);
		StartDate.setColumns(10);

		JLabel lblPeriod = new JLabel("Period :");
		lblPeriod.setBounds(6, 138, 95, 14);
		contentPanel.add(lblPeriod);

		JLabel lblApplicable = new JLabel("Applicable :");
		lblApplicable.setBounds(6, 163, 109, 14);
		contentPanel.add(lblApplicable);

		Period = new JTextField();
		Period.setBounds(140, 135, 200, 20);
		contentPanel.add(Period);
		Period.setColumns(10);

		Percent = new JTextField();
		Percent.setBounds(140, 85, 200, 20);
		contentPanel.add(Percent);
		Percent.setColumns(10);

		Applicable = new JTextField();
		Applicable.setBounds(140, 160, 200, 20);
		contentPanel.add(Applicable);
		Applicable.setColumns(10);
		Applicable.setEditable(false);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(250, 194, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		contentPanel.add(btnCancel);
		
//		{
//			{
//				setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), contentPanel, rdbtnMemDisc, rdbtnOcaDisc, lblDiscountcode, DiscountCode, lblDiscountDescription, DiscountDescription, lblStartDate, StartDate, lblPeriod, lblPercent, lblApplicable, Period, Percent, Applicable, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3}));
//			}
//		}

	}
	
	private void createAddButton(){
		JButton ADDButton = new JButton("ADD");
		ADDButton.setBounds(100, 194, 89, 23);
		contentPanel.add(ADDButton);
		ADDButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String code = DiscountCode.getText();
					String description = DiscountDescription.getText();
					String startDate = StartDate.getText();
					if (startDate == "ALWAYS") 
					
					
					manager.registerDiscount(code, description,Util.castDate(StartDate.getText()), Util.castInt(Period.getText()),Util.castDouble(Percent.getText()), Applicable.getText());
				} catch (DataInputException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(getParent(), "Invalid data","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});

	}

	private void createModiyButton(){
		JButton MButton = new JButton("MODIFY");
		MButton.setBounds(30, 194, 89, 23);
		contentPanel.add(MButton);
		MButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String code = DiscountCode.getText();
					String description = DiscountDescription.getText();
					String startDate = StartDate.getText();
					if (startDate == "ALWAYS") 
					
					
					manager.registerDiscount(code, description,Util.castDate(StartDate.getText()), Util.castInt(Period.getText()),Util.castDouble(Percent.getText()), Applicable.getText());
				} catch (DataInputException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(getParent(), "Invalid data","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});

	}

	private void createDeleteButton(){
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(140, 194, 89, 23);
		contentPanel.add(btnDelete);
	}

}
