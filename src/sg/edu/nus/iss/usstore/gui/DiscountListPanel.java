package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.usstore.domain.Discount;

import sg.edu.nus.iss.usstore.util.TableColumnAdjuster;

public class DiscountListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	
	private final String[] columnNames = {"DiscountCode","DiscountDescription","StartDate","Period","Percent","Applicable"};
	private JButton modifyButton;
	private JButton deleteButton;
	private JTable discountTable;
	private DefaultTableModel tableModel;
	private StoreApplication manager;
	
		
	public DiscountListPanel(StoreApplication manager){
		this.manager = manager;
		setLayout(new BorderLayout());
		add("North",createTopPanel());
		add("Center",createMiddlePanel(loadTableData(manager.getDiscountList())));
		add("South",createBottomPanel());
		setVisible(true);
	}
	
private Object[][] loadTableData(ArrayList<Discount> discount){
	Object[][] data =  new Object[discount.size()][6];
	Discount d;
	for(int i=0;i<discount.size();i++){
		d = discount.get(i);
		data[i][0] = d.getDiscountcode();
		data[i][1] = d.getDiscountDescription();
		data[i][2] = d.getStartDate();
		data[i][3] = d.getPeriod();
		data[i][4] = d.getPercent();
		data[i][4] = d.getApplicable();
	}
	return data;
}

private JPanel createTopPanel(){
	JPanel p = new JPanel(new BorderLayout());
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	panel.add(new JLabel("Discount List"));
	p.add("Center",panel);
	JButton b = new JButton("Refresh");
	b.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			refreshTable();
		}

	});
	panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	panel.add(b);
	p.add("East",panel);
	
	return p;
}

private Container createMiddlePanel(Object[][] data){
//	String[] columnNames = {"Id","Name","Category","Price","Quality"};
//	Object[][] data = {
//			{"1","cat","animal","$123","5"},
//			{"2","dog","animal","$123","5"},
//			{"3","cat","animal","$123","5"}
//	};
	
	tableModel = new DefaultTableModel(data,columnNames){
		@Override
		public boolean isCellEditable(int row, int column){
			return false;
		}
	};

	discountTable = new JTable(tableModel);
	discountTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	setTableFormat();
	discountTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	discountTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			if(discountTable.getSelectionModel().isSelectionEmpty()){
				modifyButton.setEnabled(false);
				deleteButton.setEnabled(false);
			}else{
				modifyButton.setEnabled(true);
				deleteButton.setEnabled(true);
			}
		}
	});;
	discountTable.setFillsViewportHeight(true);
	discountTable.setAutoCreateRowSorter(true);
	
	JScrollPane p = new JScrollPane(discountTable);
	
	return p;
}

private JPanel createBottomPanel(){
	JPanel p = new JPanel();
	JButton b = new JButton("Add");
	b.addActionListener(new ActionListener() {
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ProductDialog d = new ProductDialog(manager,"Add Product");				
			d.setVisible(true);
		}
	});
	p.add(b);
	
	modifyButton = new JButton("Modify");
	modifyButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			DiscountDialog d = new DiscountDialog(manager,"Modify Discount", discountTable.getSelectedRow());
			d.setVisible(true);
		}
	});
	modifyButton.setEnabled(false);
	p.add(modifyButton);
	
	deleteButton = new JButton("Delete");
	deleteButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int index = discountTable.getSelectedRow();
			tableModel.removeRow(index);
			manager.deleteProduct(index);
			//manager.getStore().getPm().showData();
//			deleteButton.setEnabled(false);
//			modifyButton.setEnabled(false);
		}
	});
	deleteButton.setEnabled(false);
	p.add(deleteButton);
	
	//b = new JButton("Check Threshold");
	//b.addActionListener(new ActionListener() {
		
	//	@Override
	//	public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	//		manager.getStoreWindow().changeCard("checkInventory");
	//	}
	//});
	p.add(b);
	
	b = new JButton("Back");
	b.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			manager.getStoreWindow().changeCard("mainScreen");
		}
	});
	p.add(b);
	return p;
}

private void setTableFormat(){
	TableColumnAdjuster tca = new TableColumnAdjuster(discountTable);
	tca.setColumnHeaderIncluded(true);
	tca.setColumnDataIncluded(true);
	//tca.setOnlyAdjustLarger(true);
	tca.adjustColumns();
}

public void refreshTable(){
	tableModel.setDataVector(loadTableData(manager.getDiscountList()), columnNames);
	tableModel.fireTableDataChanged();
	setTableFormat();
}

public JTable getDiscountTable() {
	return discountTable;
}

public DefaultTableModel getTableModel() {
	return tableModel;
}




}



	



