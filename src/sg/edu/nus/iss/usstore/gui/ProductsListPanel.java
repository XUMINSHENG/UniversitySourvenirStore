package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sg.edu.nus.iss.usstore.domain.*;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
* cardName: productList
* @ XIE JIABAO
*/
public class ProductsListPanel extends JPanel{
	
	private final String[] columnNames = {"Id","Name","Category","Price","Quality"};
	private JButton modifyButton;
	private JButton deleteButton;
	private JTable productTable;
	private DefaultTableModel tableModel;
	private StoreApplication manager;
	
	public ProductsListPanel(StoreApplication manager){
		this.manager = manager;
		setLayout(new BorderLayout());
		add("North",createTopPanel());
		add("Center",createMiddlePanel(loadData(manager.getStore().getPm().getProductList())));
		add("South",createBottomPanel());
		setVisible(true);
	}
	
	private Object[][] loadData(ArrayList<Product> products){
		Object[][] data =  new Object[products.size()][5];
		for(int i=0;i<products.size();i++){
			data[i][0] = products.get(i).getProductId();
			data[i][1] = products.get(i).getName();
			data[i][2] = products.get(i).getCategory();
			data[i][3] = products.get(i).getPrice();
			data[i][4] = products.get(i).getQuantityAvaible();
		}
		return data;
	}
	
	private JPanel createTopPanel(){
		JPanel p = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("Product List"));
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
//		String[] columnNames = {"Id","Name","Category","Price","Quality"};
//		Object[][] data = {
//				{"1","cat","animal","$123","5"},
//				{"2","dog","animal","$123","5"},
//				{"3","cat","animal","$123","5"}
//		};
		
		tableModel = new DefaultTableModel(data,columnNames);
		productTable = new JTable(tableModel);
		productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(productTable.getSelectionModel().isSelectionEmpty()){
					modifyButton.setEnabled(false);
					deleteButton.setEnabled(false);
				}else{
					modifyButton.setEnabled(true);
					deleteButton.setEnabled(true);
				}
			}
		});;
		productTable.setFillsViewportHeight(true);
		productTable.setAutoCreateRowSorter(true);
		
		JScrollPane p = new JScrollPane(productTable);
		
		return p;
	}
	
	private JPanel createBottomPanel(){
		JPanel p = new JPanel();
		JButton b = new JButton("Add");
		b.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddProductDialog d = new AddProductDialog(manager.getStoreWindow(),manager.getStore().getPm());
				d.setVisible(true);
			}
		});
		p.add(b);
		
		modifyButton = new JButton("Modify");
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ModifyProductDialog d = new ModifyProductDialog(manager.getStoreWindow(), manager.getStore().getPm(), productTable.getSelectedRow());
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
				int index = productTable.getSelectedRow();
				tableModel.removeRow(index);
				manager.getStore().getPm().deleteProduct(index);
				manager.getStore().getPm().showData();
//				deleteButton.setEnabled(false);
//				modifyButton.setEnabled(false);
			}
		});
		deleteButton.setEnabled(false);
		p.add(deleteButton);
		
		b = new JButton("Check Threshold");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("check inventory");
			}
		});
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
	
	public void refreshTable(){
		tableModel.setDataVector(loadData(manager.getStore().getPm().getProductList()), columnNames);
		tableModel.fireTableDataChanged();
	}

	public JTable getProductTable() {
		return productTable;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	

//	class ProductTableModel extends AbstractTableModel{
//
//		private String[] columnNames = {"Id","Name","Category","Price","Quality"};
//		private Object[][] data = {
//				{"1","cat","animal","$123","5"},
//				{"2","dog","animal","$123","5"},
//				{"3","cat","animal","$123","5"}
//		};
//		
//		public ProductTableModel(){
//			super();
//		}
//		
//		public ProductTableModel(Object[][] data){
//			super();
//			//this.columnNames = column;
//			this.data = data;
//			addTableModelListener(new TableModelListener() {
//				
//				@Override
//				public void tableChanged(TableModelEvent arg0) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//			
//		}
//	
//		@Override
//		public int getColumnCount() {
//			// TODO Auto-generated method stub
//			return columnNames.length;
//		}
//		@Override
//		public int getRowCount() {
//			// TODO Auto-generated method stub
//			return data.length;
//		}
//		@Override
//		public String getColumnName(int columnIndex){
//			return columnNames[columnIndex];
//		}
//		@Override
//		public Object getValueAt(int rowIndex, int columnIndex) {
//			// TODO Auto-generated method stub
//			return data[rowIndex][columnIndex];
//		}
//		@Override
//		public boolean isCellEditable(int rowIndex, int columnIndex){
//			return false;
//		}
//		
//	}
}