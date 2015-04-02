package sg.edu.nus.iss.usstore.gui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrderListPanel extends JPanel{

	private JTable table;
	private DefaultTableModel tableModel;
	private final String[] columnNames = {"Vendor Name","Product Id","Product Name"}; 
	private StoreApplication manager;
	
	public OrderListPanel(StoreApplication manager){
		this.manager = manager;
		
	}
}
