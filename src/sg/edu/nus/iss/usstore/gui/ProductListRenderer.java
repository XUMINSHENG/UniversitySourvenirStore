package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import sg.edu.nus.iss.usstore.domain.Product;

public class ProductListRenderer extends JPanel implements ListCellRenderer<Object>{

	private JLabel nameLabel = new JLabel();
	private JLabel qtyLabel = new JLabel();
	private JLabel reorderLabel = new JLabel();
	private JLabel orderLabel = new JLabel();
	
	public ProductListRenderer(){
		super(new BorderLayout());
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(nameLabel);
		add(p,BorderLayout.CENTER);
		p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(qtyLabel);
		p.add(reorderLabel);
		p.add(reorderLabel);
		p.add(orderLabel);
		add(p,BorderLayout.EAST);
		setBackground(Color.WHITE);
		setOpaque(true);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Product p = (Product)value;
		nameLabel.setText(p.getName());
		qtyLabel.setText(Integer.toString(p.getQuantityAvaible()));
		reorderLabel.setText(Integer.toString(p.getReorderQuantity()));
		orderLabel.setText(Integer.toString(p.getOrderQuantity()));
		return this;
	}

}
