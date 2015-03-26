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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.usstore.domain.*;
import sg.edu.nus.iss.usstore.util.DialogMode;
import sg.edu.nus.iss.usstore.util.TableColumnAdjuster;



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
* cardName: categoryList
* @ Xu Minsheng
*/
public class CategoryListPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String[] columnNames = {"Code","Name"};
	private JButton modifyButton;
	private JButton deleteButton;
	private JTable categoryTable;
	private DefaultTableModel tableModel;
	private StoreApplication manager;
	
	/**
	 * 
	 * @param manager
	 */
	public CategoryListPanel(StoreApplication manager){
		this.manager = manager;
		setLayout(new BorderLayout());
		add("North",createTopPanel());
		add("Center",createMiddlePanel(loadTableData(manager.getCategoryList())));
		add("South",createBottomPanel());
		refreshTable();
		setVisible(true);
	}
	
	/**
	 * 
	 * @param categoryList
	 * @return
	 */
	private Object[][] loadTableData(ArrayList<Category> categoryList){
		Object[][] data =  new Object[categoryList.size()][2];
		Category category;
		for(int i=0;i<categoryList.size();i++){
			category = categoryList.get(i);
			data[i][0] = category.getCode();
			data[i][1] = category.getName();
		}
		return data;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel createTopPanel(){
		JPanel p = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("Category List"));
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
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	private Container createMiddlePanel(Object[][] data){

		tableModel = new DefaultTableModel(data,columnNames){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		categoryTable = new JTable(tableModel);
		categoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnAdjuster tca = new TableColumnAdjuster(categoryTable);
		tca.setColumnHeaderIncluded(true);
		tca.setColumnDataIncluded(true);
		//tca.setOnlyAdjustLarger(true);
		tca.adjustColumns();
		categoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(categoryTable.getSelectionModel().isSelectionEmpty()){
					modifyButton.setEnabled(false);
					deleteButton.setEnabled(false);
				}else{
					modifyButton.setEnabled(true);
					deleteButton.setEnabled(true);
				}
			}
		});;
		categoryTable.setFillsViewportHeight(true);
		categoryTable.setAutoCreateRowSorter(true);
		
		JScrollPane p = new JScrollPane(categoryTable);
		
		return p;
	}
	
	private JPanel createBottomPanel(){
		JPanel p = new JPanel();
		JButton b = new JButton("Add");
		b.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CategoryDialog categoryDlg = new CategoryDialog(manager,"Add Category", null, DialogMode.ADD);				
				categoryDlg.setVisible(true);
			}
		});
		p.add(b);
		
		modifyButton = new JButton("Modify");
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String code = (String) categoryTable.getValueAt(categoryTable.getSelectedRow(), 0);
				CategoryDialog categoryDlg = 
						new CategoryDialog(manager,"Modify Category", manager.getCategoryByCode(code), DialogMode.MODIFY);
				
				categoryDlg.setVisible(true);
			}
		});
		modifyButton.setEnabled(false);
		p.add(modifyButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				delCategory();
			}
		});
		deleteButton.setEnabled(false);
		p.add(deleteButton);

		
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
		tableModel.setDataVector(loadTableData(manager.getCategoryList()), columnNames);
		tableModel.fireTableDataChanged();
	}
	
	/**
	 * 
	 */
	private void delCategory(){
		String code = (String) categoryTable.getValueAt(categoryTable.getSelectedRow(), 0);
		manager.deleteCategory(code);
		refreshTable();
	}


}
