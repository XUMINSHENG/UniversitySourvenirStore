package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sg.edu.nus.iss.usstore.domain.Product;

public class CheckInventoryPanel extends JPanel{

	private StoreApplication manager;
	private JList<Product> list;
	private DefaultListModel<Product> listModel;
	
	public CheckInventoryPanel(StoreApplication manager){
		this.manager = manager;
		setLayout(new BorderLayout());
		add("North",createNorthPanel());
		add("Center",createCenterPanel());
		add("South",createSouthPanel());
		setVisible(true);
	}
	
	public JPanel createNorthPanel(){
		JPanel p = new JPanel(new FlowLayout());
		p.add(new JLabel("Replenish Inventory List"));
		return p;
	}
	
	public Container createCenterPanel(){
		listModel = new DefaultListModel<Product>();
		ArrayList<Product> plist = manager.getStore().getPm().getProductList();
		for(int i=0;i<plist.size();i++){
			listModel.addElement(plist.get(i));
		}
		list = new JList<Product>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setCellRenderer(new ProductListRenderer());
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(list.isSelectionEmpty()){
					System.out.println("unselect "+list.getSelectedIndex());
				}else{
					System.out.println("select "+list.getSelectedIndex());
				}
			}
		});;;
		JScrollPane p = new JScrollPane(list);
		return p;
	}
	
	private JPanel createSouthPanel(){
		JPanel p = new JPanel(new FlowLayout());
		JButton b = new JButton("Generate Order List");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		p.add(b);
		
		b = new JButton("Back");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		p.add(b);
		return p;
	}
}
