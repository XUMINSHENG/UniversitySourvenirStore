//package sg.edu.nus.iss.usstore.gui;
//
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//import javax.swing.SwingConstants;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;
//
//import sg.edu.nus.iss.usstore.domain.Discount;
//
//public class DiscountListPanel extends JPanel{
//
//	private StoreApplication manager;
//	private final String[] columnNames = {"Code","Description","Start date","Period","Percentage","Applicable"};
//	private JButton modifyButton;
//	private JButton deleteButton;
//	private JTextField filterText;
//	private JTable productTable;
//	private DefaultTableModel tableModel;
//	private TableRowSorter<DefaultTableModel> sorter;
//	
//	public DiscountListPanel(StoreApplication manager){
//		this.manager = manager;
//		setLayout(new BorderLayout());
//		add("North",createTopPanel());
//		add("Center",createMiddlePanel());
//		add("South",createBottomPanel());
//		setVisible(true);
//	}
//	
//	private Object[][] loadTableData(ArrayList<Discount> discounts){
//		Object[][] data =  new Object[discounts.size()][5];
//		Discount d;
//		for(int i=0;i<discounts.size();i++){
//			d = discounts.get(i);
//			data[i][0] = d.getDiscountcode();
//			data[i][1] = d.getDiscountDescription();
//			data[i][2] = d.get;
//			data[i][3] = d.getPercent();
//			data[i][4] = d.getQuantityAvailable();
//		}
//		return data;
//	}
//	
//	private JPanel createTopPanel(){
//		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		panel.add(new JLabel("Product List"));	
//		return panel;
//	}
//	
//	private Container createMiddlePanel(){
//		Object[][] data = loadTableData(manager.getDiscountList());
//		
//		JPanel panel = new JPanel(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.BOTH;
//		
//		tableModel = new DefaultTableModel(data,columnNames){
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//			@Override
//			public boolean isCellEditable(int row, int column){
//				return false;
//			}
//			@SuppressWarnings({ "unchecked", "rawtypes" })
//			@Override
//			public Class getColumnClass(int column){
//				Class returnValue;
//				if ((column >= 0) && (column < getColumnCount())) {  
//		            returnValue = getValueAt(0, column).getClass();  
//		        } else {  
//		            returnValue = Object.class;  
//		        }  
//				return returnValue;
//			}
//		};
//		productTable = new JTable(tableModel);
//		sorter = new TableRowSorter<DefaultTableModel>(tableModel);
//		productTable.setRowSorter(sorter);
//		productTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		setTableFormat();
//		productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent arg0) {
//				// TODO Auto-generated method stub
//				if(productTable.getSelectionModel().isSelectionEmpty()){
//					modifyButton.setEnabled(false);
//					deleteButton.setEnabled(false);
//				}else{
//					modifyButton.setEnabled(true);
//					deleteButton.setEnabled(true);
//				}
//			}
//		});
//		productTable.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				int i = productTable.getSelectedRow();
//				if(arg0.getClickCount() == 2 && i>=0){
//					int rowIndex = productTable.convertRowIndexToModel(i);
//					int columnIndex = productTable.getColumnModel().getColumnIndex("Id");
//					String id = (String)tableModel.getValueAt(rowIndex, columnIndex);
//					ProductDialog d = new ProductDialog(manager,"Modify Product", id);
//					d.setVisible(true);
//				}
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		//productTable.setFillsViewportHeight(true);
//		productTable.setAutoCreateRowSorter(false);
//		
//		JLabel label = new JLabel("Filter Search: ",SwingConstants.TRAILING);
//		//label.setBorder(BorderFactory.createLineBorder(Color.black));
//		
//		filterText = new JTextField(10);
//		filterText.getDocument().addDocumentListener(new DocumentListener() {
//			
//			@Override
//			public void removeUpdate(DocumentEvent arg0) {
//				// TODO Auto-generated method stub
//				newFilter();
//			}
//			
//			@Override
//			public void insertUpdate(DocumentEvent arg0) {
//				// TODO Auto-generated method stub
//				newFilter();
//			}
//			
//			@Override
//			public void changedUpdate(DocumentEvent arg0) {
//				// TODO Auto-generated method stub
//				newFilter();
//			}
//		});
//		label.setLabelFor(filterText);
//		
//		JButton b = new JButton("Refresh");
//		b.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				refreshTable();
//			}
//		});
//		
//		JScrollPane p = new JScrollPane(productTable);
//		
//		c.gridx = 0;
//		c.gridy = 0;
//		c.weightx = 0;
//		panel.add(label,c);
//		c.gridx = 1;
//		c.weightx = 1;
//		panel.add(filterText,c);
//		c.gridx = 2;
//		c.weightx = 0;
//		panel.add(b,c);
//		c.gridx = 0;
//		c.gridy = 1;
//		c.weightx = 1;
//		c.gridwidth = 3;
//		panel.add(p,c);
//		
//		return panel;
//	}
//	
//	private JPanel createBottomPanel(){
//		JPanel p = new JPanel();
//		return p;
//	}
//}
