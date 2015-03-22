package sg.edu.nus.iss.usstore.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.util.ProductDialog;

public class ModifyProductDialog extends ProductDialog{
	
	private StoreApplication manager;
	private StoreWindow mainScreen;
	private int index;
	
	public ModifyProductDialog(StoreApplication manager,int index){
		super(manager.getStoreWindow(),"Modify Product");
		this.manager = manager;
		this.mainScreen = manager.getStoreWindow();
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
				//Product newProduct = new Product("4","animal","pig","something",12,20,"c123",100,200);
				
				if(validateData()){
					manager.modifyProduct(getNameText(),getCategoryText(),getDescriptionText(),getQuantityText(),
								getPriceText(),getBarCodeText(),getReorderQtyText(),getOrderQtyText());
				
					//manager.modifyProduct(newProduct, index);
					mainScreen.getProductListPanel().refreshTable();
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
