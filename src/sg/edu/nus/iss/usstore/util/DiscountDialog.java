
package sg.edu.nus.iss.usstore.util;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sg.edu.nus.iss.usstore.domain.Discount;

public abstract class DiscountDialog extends JDialog{

//	private ProductMgr manager;
//	private StoreWindow mainScreen;
	private JTextField discountCodeText;
	private JTextField discountDescriptionText;
	//private JTextField categoryText;
	private JComboBox discountList;
	private JTextField startDateText;
	private JTextField percentText;
	private JTextField periodText;
	private JTextField ApplicableText;
	private String s;
	
	public DiscounttDialog(JFrame parent, String title){
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
		panel.add(new JLabel("DiscountCode "));
		panel.add(new JLabel("DiscountDescription "));
		panel.add(new JLabel("StartDate "));
		panel.add(new JLabel("Period "));
		panel.add(new JLabel("Percent "));
		panel.add(new JLabel("Applicable "));
		
		p.add("West",panel);
		
		discountList=new JComboBox();
		
		discountDescriptionText = new JTextField();
		discountDescriptionText.setEditable(false);
		//categoryText = new JTextField();
		discountCodeText = new JTextField();
		startDateText = new JTextField();
		startDateText.setDocument(new DigitDocument());
		percentText = new JTextField();
		percentText.setDocument(new DigitDocument());
		
		periodText = new JTextField();
		periodText.setDocument(new DigitDocument());
		ApplicableText = new JTextField();
		
		panel = new JPanel(new GridLayout(9,1));
		panel.add(discountCodeText);
		panel.add(discountDescriptionText);
		panel.add(discountList);
		panel.add(startDateText);
		panel.add(percentText);
		panel.add(periodText);
		panel.add(ApplicableText);
		
		p.add("Center",panel);
		
		return p;
	}
	
	
	
	public void setData(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String Applicable){
		//categoryList.setSelectedItem(categoryCode);
		discountCodeText.setText(discountCode);
		discountDescriptionText.setText(discountDescription);
		
		startDateText.setDate(Util.dateToString(discount.getStartDate()));
		priceText.setText(Double.toString(price));
		quantityText.setText(Integer.toString(quantityAvailable));
		barCodeText.setText(barCode);
		reorderQtyText.setText(Integer.toString(threshold));
		orderQtyText.setText(Integer.toString(orderQuantity));
		
	}

	private int getStartDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean validateData(){
		if(idText.getText()!="" && nameText.getText()!="" && categoryList.getSelectedItem()!="" && descriptionText.getText()!="" 
				&& priceText.getText()!="" && quantityText.getText()!="" && barCodeText.getText()!="" 
				&& reorderQtyText.getText()!="" && orderQtyText.getText()!=""){
			return true;
		}
		return false;
	}
	
	protected abstract JPanel createBottomPanel();
	
	public void setCateogryList(String[] data){
		categoryList = new JComboBox<String>(data);
		categoryList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(categoryList.getSelectedIndex()==-1){
					System.out.println("no select");
				}else{
					System.out.println(categoryList.getSelectedItem());
				}
			}
		});
	}
	
	public String getIdText() {
		return idText.getText();
	}

	public String getNameText() {
		return nameText.getText();
	}

	public String getCategoryText() {
		return (String) categoryList.getSelectedItem();
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
