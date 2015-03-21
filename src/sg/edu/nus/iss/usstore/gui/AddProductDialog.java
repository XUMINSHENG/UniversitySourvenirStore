package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.tools.DiagnosticCollector;

import sg.edu.nus.iss.usstore.domain.*;
import sg.edu.nus.iss.usstore.util.DigitDocument;
import sg.edu.nus.iss.usstore.util.ProductDialog;

public class AddProductDialog extends ProductDialog {
	
	private ProductMgr manager;
	private StoreWindow mainScreen;
	private JTextField idText;
	private JTextField nameText;
	private JTextField categoryText;
	private JTextField descriptionText;
	private JTextField quantityText;
	private JTextField priceText;
	private JTextField barCodeText;
	private JTextField reorderQtyText;
	private JTextField orderQtyText;
	/**
	* Auto-generated main method to display this JDialog
	*/
	
	public AddProductDialog(StoreApplication manager){
		super(manager.getStoreWindow(),"Add Product");
		this.manager = manager.getStore().getPm();
		this.mainScreen = manager.getStoreWindow();
	}
	
	public AddProductDialog(JFrame parent, ProductMgr manager){
		super(parent,"Add Product");
		this.manager = manager;
		this.mainScreen = (StoreWindow)parent;
	}

	@Override
	protected JPanel createBottomPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new FlowLayout());
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Product newProduct = new Product("4","animal","pig","something",12,20,"c123",100,200);
				
				
//				Product newProduct = 
//						new Product(idText.getText(),nameText.getText(),categoryText.getText(),descriptionText.getText(),
//								Integer.parseInt(quantityText.getText()),Double.parseDouble(priceText.getText()),
//								barCodeText.getText(),Integer.parseInt(reorderQtyText.getText()),Integer.parseInt(orderQtyText.getText()));
//				
				manager.addProduct(newProduct);
				mainScreen.getProductListPanel().refreshTable();;
				manager.showData();
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
	
}
