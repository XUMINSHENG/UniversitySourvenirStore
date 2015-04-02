package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.usstore.util.TableColumnAdjuster;

/*
 * cardName: orderList
 * @ Team FT2 - XIE JIABAO 
 */

public class OrderListPanel extends JPanel{

	private JTable table;
	private DefaultTableModel tableModel;
	private final String[] columnNames = {"Vendor Name","Product Id","Product Name","Order Quantity"}; 
	private StoreApplication manager;
	
	public OrderListPanel(StoreApplication manager){
		this.manager = manager;
		setLayout(new BorderLayout());
		
		
	}
	
	public JPanel createNorthPanel(){
		JPanel p = new JPanel(new FlowLayout());
		p.add(new JLabel("Replenish Order List"));
		return p;
	}
	
	public Container createCenterPanel(){
		tableModel = new DefaultTableModel(loadTableData(manager.getProductList()),columnNames){
			@Override
			public boolean isCellEditable(int row,int column){
				return false;
			}
			@Override
			public Class getColumnClass(int column){
				Class returnValue;
				if(column>=0 && column<getColumnCount()){
					returnValue = getValueAt(0, column).getClass();
				}else{
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		
		table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnAdjuster tca = new TableColumnAdjuster(table);
		tca.setColumnHeaderIncluded(true);
		tca.setColumnDataIncluded(true);
		tca.setOnlyAdjustLarger(true);
		tca.adjustColumns();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectionModel().isSelectionEmpty()){
					//fire.setEnabled(false);
				}else{
					//fire.setEnabled(true);
				}
			}

		});
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		JScrollPane p = new JScrollPane(table);
		return p;
	}
}
