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
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.gui.StoreApplication;
import sg.edu.nus.iss.usstore.gui.StoreWindow;

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
	
	public void setData(Product product){
		nameText.setText(product.getName());
		idText.setText(product.getProductId());
		categoryText.setText(product.getCategory());
		descriptionText.setText(product.getBriefDescription());
		priceText.setText(Double.toString(product.getPrice()));
		quantityText.setText(Integer.toString(product.getQuantityAvaible()));
		barCodeText.setText(product.getBarCodeNumber());
		reorderQtyText.setText(Integer.toString(product.getReorderQuantity()));
		orderQtyText.setText(Integer.toString(product.getOrderQuantity()));
		
	}
	
	protected abstract JPanel createBottomPanel();
	
}
