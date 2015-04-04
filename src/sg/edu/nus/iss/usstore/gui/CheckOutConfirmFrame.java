//CheckOutConfirmFrame.java
package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.usstore.domain.Customer;
import sg.edu.nus.iss.usstore.domain.Discount;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.RecieptPrinter;
import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionItem;


public class CheckOutConfirmFrame extends JFrame
{
	/**
	 * @author Liu Xinzhuo
	 * @author A0136010A
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	
	private final String STORE_NAME = "University Souvenir Store";
	private final String STORE_ADDRESS = "21 Lower Kent Ridge Road Singapore 119077 ";
	private final String STORE_TELEPHONE = "+65 XXXX XXXX ";
	
	private DefaultTableModel defaultModel;
	private Transaction transaction = new Transaction();
	private Product product = null;
	private JTable table;
	
	private SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	//draw UI
	public CheckOutConfirmFrame(Transaction t) 
	{
		this.transaction = t;
		Customer customer = transaction.getCustomer();
		double cash = transaction.calcRest();
		Date date = transaction.getDate();
		Discount discount = transaction.getDiscount();
		int ID = transaction.getId();
		int redeemedPoint = transaction.getRedeemedLoyaltyPoint();
		
		JPanel jpinformation = new JPanel();
		JPanel jptransaction = new JPanel();
		JPanel jpbutton = new JPanel();
		
		
		getContentPane().add(jpinformation,BorderLayout.NORTH);
		getContentPane().add(jptransaction,BorderLayout.CENTER);
		getContentPane().add(jpbutton,BorderLayout.SOUTH);
		
		jpinformation.setLayout(new GridLayout(6,1));
		JLabel title = new JLabel(STORE_NAME);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel address = new JLabel(STORE_ADDRESS);
		address.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel phone = new JLabel(STORE_TELEPHONE);
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel transactionID = new JLabel("Transaction ID" + ID);
		transactionID.setHorizontalAlignment(SwingConstants.CENTER);
		address.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel customerName = new JLabel("Customer");
		customerName.setHorizontalAlignment(SwingConstants.CENTER);
		if (customer.name==null)
			customerName.setText("Customer:" + "PUBLIC");
		else
			customerName.setText("Customer:" + customer.name);
		JLabel dataString = new JLabel();
		dataString.setHorizontalAlignment(SwingConstants.CENTER);
		dataString.setText("Date:"+ df.format(date));
		
		jpinformation.add(title);
		jpinformation.add(address);
		jpinformation.add(phone);
		jpinformation.add(transactionID);
		jpinformation.add(customerName);
		jpinformation.add(dataString);
		
		table = new JTable(defaultModel);
		String[] tableTitle = {"Product", "Quantity","Total" };
		defaultModel = new DefaultTableModel(null, tableTitle)
		{
			public boolean isCellEditable(int row, int column)
			{
					return false;
			}
		};
		table = new JTable(defaultModel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setViewportView(table);
		jptransaction.add(scrollPane);
		tableDataBinding();
		
		jpbutton.setLayout(new GridLayout(1,4));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		jpbutton.add(jp2);
		jpbutton.add(jp1);
		jpbutton.add(jp3);
		jpbutton.add(jp4);
		
		JLabel jlCash = new JLabel("CashPay:"+cash);
		jp1.add(jlCash);
		
		JLabel jlDiscount = new JLabel("Discount:"+discount.getPercent());
		jp2.add(jlDiscount);
		
		JLabel jlReedemedPoint = new JLabel("PointPay:"+redeemedPoint);
		jp3.add(jlReedemedPoint);
		
		JButton JbConfirmn = new JButton("Confirm&Print");
		JbConfirmn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				RecieptPrinter printer = new RecieptPrinter(transaction);
				printer.print();
				dispose();
			}
		});
		jp4.add(JbConfirmn);
		
		this.pack();
		
	}
	//Data Binding
	public void tableDataBinding()
	{
		ArrayList itemList = transaction.getItemList();
		Vector dataVector = defaultModel.getDataVector();
		dataVector.clear();
		System.out.print( itemList.size());
		for (int i = 0; i < itemList.size(); i++)
		{
			Vector subVector = new Vector();
			TransactionItem transactionitem = (TransactionItem) itemList.get(i);
			product = transactionitem.getProduct();
			subVector.add(product.getName());
			subVector.add(Integer.toString(transactionitem.getQty()));
			subVector.add(transactionitem.calculateAmount());
			defaultModel.addRow(subVector);
		}
		table.validate();
		table.repaint();
	}
}// /~
