package sg.edu.nus.iss.usstore.util;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sg.edu.nus.iss.usstore.domain.Product;

public abstract class ProductDialog extends JDialog{

//	private ProductMgr manager;
//	private StoreWindow mainScreen;
	private JTextField idText;
	private JTextField nameText;
	private JTextField categoryText;
	private JTextField descriptionText;
	private JTextField quantityText;
	private JTextField priceText;
	private JTextField barCodeText;
	private JTextField reorderQtyText;
	private JTextField orderQtyText;
	
	public ProductDialog(JFrame parent, String title){
		super(parent,title);
		initGUI();
	}
	
	private void initGUI() {
		try {
			setLayout(new BorderLayout());
			add("Center",createCenterPanel());
			add("South",createBottomPanel());
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
		panel.add(new JLabel("Name: "));
		panel.add(new JLabel("Id: "));
		panel.add(new JLabel("Category: "));
		panel.add(new JLabel("Description: "));
		panel.add(new JLabel("Price: "));
		panel.add(new JLabel("Avaliable Quantity: "));
		panel.add(new JLabel("Bar Code Number: "));
		panel.add(new JLabel("Reorder Quantity: "));
		panel.add(new JLabel("Order Quantity: "));
		p.add("West",panel);
		
		nameText = new JTextField();
		idText = new JTextField();
		idText.setEditable(false);
		categoryText = new JTextField();
		descriptionText = new JTextField();
		priceText = new JTextField();
		priceText.setDocument(new DigitDocument());
		quantityText = new JTextField();
		quantityText.setDocument(new DigitDocument());
		barCodeText = new JTextField();
		reorderQtyText = new JTextField();
		reorderQtyText.setDocument(new DigitDocument());
		orderQtyText = new JTextField();
		orderQtyText.setDocument(new DigitDocument());
		panel = new JPanel(new GridLayout(9,1));
		panel.add(nameText);
		panel.add(idText);
		panel.add(categoryText);
		panel.add(descriptionText);
		panel.add(priceText);
		panel.add(quantityText);
		panel.add(barCodeText);
		panel.add(reorderQtyText);
		panel.add(orderQtyText);
		p.add("Center",panel);
		
		return p;
	}
	
	public void setData(String id,String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		nameText.setText(name);
		idText.setText(id);
		categoryText.setText(categoryCode);
		descriptionText.setText(briefDescription);
		priceText.setText(Double.toString(price));
		quantityText.setText(Integer.toString(quantityAvailable));
		barCodeText.setText(barCode);
		reorderQtyText.setText(Integer.toString(threshold));
		orderQtyText.setText(Integer.toString(orderQuantity));
		
	}

	public boolean validateData(){
		if(idText.getText()!="" && nameText.getText()!="" && categoryText.getText()!="" && descriptionText.getText()!="" 
				&& priceText.getText()!="" && quantityText.getText()!="" && barCodeText.getText()!="" 
				&& reorderQtyText.getText()!="" && orderQtyText.getText()!=""){
			return true;
		}
		return false;
	}
	
	protected abstract JPanel createBottomPanel();

	public String getIdText() {
		return idText.getText();
	}

	public String getNameText() {
		return nameText.getText();
	}

	public String getCategoryText() {
		return categoryText.getText();
	}

	public String getDescriptionText() {
		return descriptionText.getText();
	}

	public int getQuantityText() {
		return Integer.parseInt(quantityText.getText());
	}

	public Double getPriceText() {
		return Double.parseDouble(priceText.getText());
	}

	public String getBarCodeText() {
		return barCodeText.getText();
	}

	public int getReorderQtyText() {
		return Integer.parseInt(reorderQtyText.getText());
	}

	public int getOrderQtyText() {
		return Integer.parseInt(orderQtyText.getText());
	}
	
	
}
