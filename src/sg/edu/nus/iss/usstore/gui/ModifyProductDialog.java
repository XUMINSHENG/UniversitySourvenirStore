package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.util.DigitDocument;
import sg.edu.nus.iss.usstore.util.ProductDialog;

public class ModifyProductDialog extends ProductDialog{
	
	private ProductMgr manager;
	private StoreWindow mainScreen;
	private int index;
	private JTextField idText;
	private JTextField nameText;
	private JTextField categoryText;
	private JTextField descriptionText;
	private JTextField quantityText;
	private JTextField priceText;
	private JTextField barCodeText;
	private JTextField reorderQtyText;
	private JTextField orderQtyText;
	
	public ModifyProductDialog(JFrame parent, ProductMgr manager,int index){
		super(parent,"Modify Product");
		this.manager = manager;
		this.mainScreen = (StoreWindow)parent;
		this.index = index;
		setData(manager.getProductList().get(index));
	}
	
	@Override
	protected JPanel createBottomPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new FlowLayout());
		JButton button = new JButton("Modify");
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
				manager.modifyProduct(newProduct, index);
				mainScreen.getProductListPanel().refreshTable();
				manager.showData();
			}
		});
		panel.add(button);
		
		button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				manager.deleteProduct(index);
				mainScreen.getProductListPanel().refreshTable();
				dispose();
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
