package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sg.edu.nus.iss.usstore.domain.*;
import sg.edu.nus.iss.usstore.util.DialogMode;
import sg.edu.nus.iss.usstore.util.StringDocument;

/**
 * 
 * @author Xu Minsheng
 *
 */
public class CategoryDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StoreApplication manager;
	private StoreWindow mainScreen;
	
	private JTextField codeText;
	private JTextField nameText;
	
	
	public CategoryDialog( StoreApplication manager,String title, Category category, DialogMode dialogMode){
		super(manager.getStoreWindow(),title);
		this.manager = manager;
		this.mainScreen = manager.getStoreWindow();
		initGUI();
		add("South",createModifyBottomPanel());
		
		
		
		switch (dialogMode) {
			case ADD:
				break;
			case MODIFY:
				setData(category);
				break;
			case VIEW:
				setData(category);
				break;
			default:
				break;
		}
		
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
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(10, 10, 0, 10));
		
		JPanel panel = new JPanel(new GridLayout(9,1));
		panel.add(new JLabel("Code: "));
		panel.add(new JLabel("Name: "));
		p.add("West",panel);
		
		
		loadVendorList();
		codeText = new JTextField();
		codeText.setDocument(new StringDocument());
		nameText = new JTextField();
		nameText.setDocument(new StringDocument());
		
	
		panel = new JPanel(new GridLayout(9,1));
		panel.add(codeText);
		panel.add(nameText);
		p.add("Center",panel);
		
		return p;
	}
	
	public void loadVendorList(){
		
	}
	
	public void setData(Category category){
		codeText.setText(category.getCode());
		nameText.setText(category.getName());
		
	}

	public boolean validateData(){
		
		return false;
	}
	
	private JPanel createAddBottomPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new FlowLayout());
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//Product newProduct = new Product("4","animal","pig","something",12,20,"c123",100,200);
				
				if(validateData()){
					
				
				}else{
					System.out.println("invalid data");
				}
				
			}
		});
		panel.add(button);
		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//setVisible(false);
				dispose();
			}
		});
		panel.add(button);
	
		return panel;
	}
	
	private JPanel createModifyBottomPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new FlowLayout());
		JButton button = new JButton("Modify");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				if(validateData()){
					
					
				}else{
					System.out.println("invalid data");
				}
			}
		});
		panel.add(button);
		
		button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				dispose();
			}
		});
		panel.add(button);
		
		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(button);
		return panel;
	}
	
}
