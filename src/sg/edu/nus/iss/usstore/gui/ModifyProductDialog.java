//package sg.edu.nus.iss.usstore.gui;
//
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JPanel;
//
//public class ModifyProductDialog extends ProductDialog{
//	
//	private StoreApplication manager;
//	private StoreWindow mainScreen;
//	private int index;
//	
//	public ModifyProductDialog(StoreApplication manager,int index){
//		super(manager.getStoreWindow(),"Modify Product");
//		this.manager = manager;
//		this.mainScreen = manager.getStoreWindow();
//		this.index = index;
//		loadCategoryListData();
//	}
//	
//	public void loadCategoryListData(){
//		int lenght = manager.getCategoryList().size();
//		if(lenght>0){
//			String[] data = new String[lenght+1];
//			data[0] = "";
//			for(int i=0;i<lenght;i++){
//				data[i+1] = manager.getCategoryList().get(i).getCode();
//			}
//			setCateogryList(data);
//		}
//	}
//	
//	@Override
//	protected JPanel createBottomPanel() {
//		// TODO Auto-generated method stub
//		JPanel panel = new JPanel(new FlowLayout());
//		JButton button = new JButton("Modify");
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				//Product newProduct = new Product("4","animal","pig","something",12,20,"c123",100,200);
//				
//				if(validateData()){
//					manager.modifyProduct(getNameText(),getCategoryText(),getDescriptionText(),getQuantityText(),
//								getPriceText(),getBarCodeText(),getReorderQtyText(),getOrderQtyText(),index);
//				
//					//manager.modifyProduct(newProduct, index);
//					mainScreen.getProductListPanel().refreshTable();
//				}else{
//					System.out.println("invalid data");
//				}
//			}
//		});
//		panel.add(button);
//		
//		button = new JButton("Delete");
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				manager.deleteProduct(index);
//				mainScreen.getProductListPanel().refreshTable();
//				dispose();
//			}
//		});
//		panel.add(button);
//		
//		button = new JButton("Cancel");
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				//setVisible(false);
//				dispose();
//			}
//		});
//		panel.add(button);
//		
//		return panel;
//	}
//}
