package sg.edu.nus.iss.usstore.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.exception.DataFileException;

public class CheckOutPanel extends JPanel
{
	private JLabel JlMemberName;
	private JLabel JlTotalPriceNum;
	private JLabel JlDiscountNum;
	private JLabel JlDiscountedPriceNum;
	private JLabel JlLoyalPointNum;
	private JLabel JlRestNum;
	private JLabel JlChangeNum;
	private JTable table;
	private JTextField JtBarCodeID;
	private JTextField jtQuantity;
	private JTextField JtMemberID;
	private JTextField JtPaidNum;
	private JTextField JtCashNum;
	private TableColumn column;

	private DecimalFormat df=new DecimalFormat("#.00");
	private int discount = 10;
	private DefaultTableModel defaultModel = null;
	private Product product = null;
	private boolean DEBUG = true;
	private Vector v;
	private static int i = 1;
	private int flag=0;

	public static int getI()
	{
		return i;
	}

	public static void setI(int i)
	{
		CheckOutPanel.i = i;
	}

	// ����и��е����ݱ����ڶ�ά����data��
	private Object[][] data = {};

	public Object[][] getData()
	{
		return data;
	}

	public void setData(Object[][] data)
	{
		this.data = data;
	}

	public void setOutputValue()
	{
		double totalPrice = 0;
		for (int i = 0; i < table.getModel().getRowCount(); i++)
			totalPrice = totalPrice + (double) table.getValueAt(i, 5);
		JlTotalPriceNum.setText(Double.toString(totalPrice));
		JlDiscountNum.setText(Integer.toString(discount));
		JlDiscountedPriceNum.setText(df.format(totalPrice - totalPrice * 0.1));
	}


	public void cancel()
	{

	}

	public CheckOutPanel()
	{ // ʵ�ֹ��췽��

		// OPeration
		JPanel jpOperation = new JPanel();
		this.add(jpOperation, BorderLayout.NORTH);
		// Title
		JLabel jlTitle = new JLabel("Check Out!");
		jlTitle.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpOperation.setLayout(new GridLayout(3, 1));
		jpOperation.add(jlTitle);
		JPanel jpInput = new JPanel();
		JPanel jpOutput = new JPanel();
		jpOperation.add(jpInput);
		jpOperation.add(jpOutput);

		// Input
		jpOperation.add(jpInput);
		jpInput.setLayout(new GridLayout(2, 2));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();

		// jp1
		JLabel JlMemberID = new JLabel("MEMBER ID");
		JtMemberID = new JTextField(24);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.add(JlMemberID);
		jp1.add(JtMemberID);
		jpInput.add(jp1);

		// jp2
		JlMemberName = new JLabel("MEMBER  NAME");
		JLabel JlgetMemberName = new JLabel("PUBLIC");
		JButton jbMemberSubmit = new JButton("  Enter ");
		jbMemberSubmit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Fine Member & get discount
			}
		});
		jp2.setLayout(new GridLayout(1, 2));
		JPanel jp2_1 = new JPanel();
		JPanel jp2_2 = new JPanel();
		jp2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_1.add(JlMemberName);
		jp2_1.add(JlgetMemberName);
		jp2_2.add(jbMemberSubmit);
		jp2.add(jp2_1);
		jp2.add(jp2_2);
		jpInput.add(jp2);

		// jp3
		JLabel JlBarCodeID = new JLabel("Bar   Code  ");
		JtBarCodeID = new JTextField(24);
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3.add(JlBarCodeID);
		jp3.add(JtBarCodeID);
		jpInput.add(jp3);

		// jp4
		jp4.setLayout(new GridLayout(1, 2));
		JPanel jp4_1 = new JPanel();
		JPanel jp4_2 = new JPanel();
		jp4_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp4_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel jlQuantity = new JLabel("QUANTITY");
		jtQuantity = new JTextField(6);
		JButton jbQuantity = new JButton("Submit");
		jbQuantity.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				flag=1;
				String tempBarCode = JtBarCodeID.getText();
				String tempqty = jtQuantity.getText();
				if (tempBarCode.length() == 0 || tempqty.length() == 0)
					return;
				else
				{
					try
					{
						ProductMgr pm = new ProductMgr();
						product = pm.getProductByBarCode(tempBarCode);
					} catch (IOException | DataFileException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					v = new Vector(5);
					// TODO Auto-generated method stub
					v.add(i++);
					v.add(tempBarCode);
					v.add(product.getName());
					v.add(Integer.parseInt(tempqty));
					v.add(product.getPrice());
					v.add(product.getPrice() * Integer.parseInt(tempqty));
					defaultModel.addRow(v);
					table.revalidate();
					JtBarCodeID.setText(null);
					jtQuantity.setText(null);
					setOutputValue();
				}
				flag=0;
			}
		});
		jp4_1.add(jlQuantity);
		jp4_1.add(jtQuantity);
		jp4_2.add(jbQuantity);
		jp4.add(jp4_1);
		jp4.add(jp4_2);
		jpInput.add(jp4);

		// output
		jpOperation.add(jpOutput);
		jpOutput.setLayout(new GridLayout(2, 4));
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		JPanel jp8 = new JPanel();
		JPanel jp9 = new JPanel();
		JPanel jp10 = new JPanel();
		JPanel jp11 = new JPanel();
		JPanel jp12 = new JPanel();

		// jp5
		jp5.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlTotalPrice = new JLabel("Total Price:");
		JlTotalPriceNum = new JLabel("00.00");
		jp5.add(JlTotalPrice);
		jp5.add(JlTotalPriceNum);
		jpOutput.add(jp5);

		// jp6
		jp6.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlDiscount = new JLabel("Discount:");
		JlDiscountNum = new JLabel("00.00");
		jp6.add(JlDiscount);
		jp6.add(JlDiscountNum);
		jpOutput.add(jp6);

		// jp7
		jp7.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlDiscountedPrice = new JLabel("DiscountedPrice:");
		JlDiscountedPriceNum = new JLabel("00.00");
		jp7.add(JlDiscountedPrice);
		jp7.add(JlDiscountedPriceNum);
		jpOutput.add(jp7);

		// jp8
		jp8.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlLoyalPoint = new JLabel("LOYAL POINT");
		JlLoyalPointNum = new JLabel("0");
		jp8.add(JlLoyalPoint);
		jp8.add(JlLoyalPointNum);
		jpOutput.add(jp8);

		// jp9
		jp9.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlPaid = new JLabel("Use Point");
		JtPaidNum = new JTextField(6);
		JtPaidNum.getDocument().addDocumentListener(new DocumentListener()
		{
			public void insertUpdate(DocumentEvent e)
			{

				// ������д��Ӧ�Ĵ������
				String tempLoyalPaid = JtPaidNum.getText();
				double tempLoyalPaidNum = Double.valueOf(tempLoyalPaid)
						.doubleValue();
				double tempDiscountedPriceNum = Double.valueOf(
						JlDiscountedPriceNum.getText()).doubleValue();
				JlRestNum.setText(df.format(tempDiscountedPriceNum
						- tempLoyalPaidNum / 100));
			}

			public void removeUpdate(DocumentEvent e)
			{
				// ���ϣ�����ı������ݵ�ɾ���¼�������
				// ������д����
			}

			public void changedUpdate(DocumentEvent e)
			{
				// һ���ò����������
			}
		});
		jp9.add(JlPaid);
		jp9.add(JtPaidNum);
		jpOutput.add(jp9);

		// jp10
		jp10.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlRest = new JLabel("REST:");
		JlRestNum = new JLabel("00.00");
		jp10.add(JlRest);
		jp10.add(JlRestNum);
		jpOutput.add(jp10);

		// jp11
		jp11.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlCash = new JLabel("Cash:");
		JtCashNum = new JTextField(6);
		JtCashNum.getDocument().addDocumentListener(new DocumentListener()
		{

			public void insertUpdate(DocumentEvent e)
			{
				// ������д��Ӧ�Ĵ������
				String ScashNum = JtCashNum.getText();
				double DcashNum = Double.valueOf(ScashNum).doubleValue();
				double DchangeNum = Double.valueOf(JlRestNum.getText()).doubleValue();
				double tempChange = DcashNum- DchangeNum;
				
				JlChangeNum.setText(df.format(tempChange));
			}

			public void removeUpdate(DocumentEvent e)
			{
				// ���ϣ�����ı������ݵ�ɾ���¼�������
				// ������д����
			}

			public void changedUpdate(DocumentEvent e)
			{
				// һ���ò����������
			}
		});
		jp11.add(JlCash);
		jp11.add(JtCashNum);
		jpOutput.add(jp11);

		// jp12
		jp12.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlChange = new JLabel("CHANGE:");
		JlChangeNum = new JLabel("00.00");
		jp12.add(JlChange);
		jp12.add(JlChangeNum);
		jpOutput.add(jp12);

		// Table

		String[] tableTitle = { "Num", "Bar Code", "Product", "Quantity",
				"Price", "Total Price" };
		defaultModel = new DefaultTableModel(data, tableTitle)
		{
			public boolean isCellEditable(int row, int column)
			{
				if (column == 3)
					return true;
				else
					return false;
			}
		};
		table = new JTable(defaultModel);// ������table��������Դ��myModel����
		//table.setFont(new Font("Times new Romer", Font.PLAIN, 10));
		for(int i = 0;i<table.getColumnCount();i++)
		{
			column = table.getColumnModel().getColumn(i);
			if (i==1||i==2)
			{
				column.setPreferredWidth(150);
			}
			else
			{
				column.setPreferredWidth(75);
			}
		}
		defaultModel.addTableModelListener(new TableModelListener()
		{

			@Override
			public void tableChanged(TableModelEvent e)
			{
				int row =e.getFirstRow();
				// TODO Auto-generated method stub
				if(flag==0)
				{
//					System.out.println(defaultModel.getValueAt(row,3));
//					System.out.println(defaultModel.getValueAt(row,4));
					int num = Integer.valueOf((String)defaultModel.getValueAt(row,3)).intValue();
					double price =(double) defaultModel.getValueAt(row,4);

				Vector v1 = defaultModel.getDataVector();
				//System.out.print(v1);
				Vector v2 = (Vector) v1.get(e.getFirstRow());
				v2.set(5, num*price);
				//System.out.print(v2);
				table.validate();
				table.repaint();}
				}
		});
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer()
		{
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column)
			{
				// /����ż������ɫ
				if (row % 2 == 0)
					setBackground(Color.white);
				// /������������ɫ
				else if (row % 2 == 1)
					setBackground(new Color(206, 231, 255));
				return super.getTableCellRendererComponent(table, value,
						isSelected, hasFocus, row, column);
			}
		};
		for (int i = 0; i <= 5; i++)
		{
			table.getColumn(tableTitle[i]).setCellRenderer(tcr);
		}

		table.setPreferredScrollableViewportSize(new Dimension(600, 400));// ������ʾ�ߴ�

		// ����һ���������������
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.getViewport().add(table);
		// �������������������봰����
		this.add(scrollPane, BorderLayout.CENTER);

		JPanel jpButton = new JPanel();
		jpButton.setLayout(new GridLayout(7, 1));
		JButton jbDelete = new JButton("    Delete    ");
		JLabel jlBlank1 = new JLabel(" ");
		jbDelete.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				int rowcount = defaultModel.getRowCount();// getRowCount����������rowcount<0�����Ѿ�û���κ����ˡ�
				System.out.print(rowcount);
				if (rowcount > 0)
				{
					defaultModel.removeRow(table.getSelectedRow());
					defaultModel.setRowCount(rowcount - 1);// ɾ���бȽϼ򵥣�ֻҪ��DefaultTableModel��removeRow()�������ɡ�ɾ������Ϻ������������������Ҳ����ʹ��DefaultTableModel��setRowCount()���������õ�ǰ�С�
				}
				table.revalidate();
			}
		});
		JButton jbCancel = new JButton("    Cancel    ");
		jbCancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				cancel();
			}
		});
		JLabel jlBlank2 = new JLabel(" ");
		JLabel jlerror = new JLabel();
		JLabel jlBlank3 = new JLabel(" ");
		JButton jbFinish = new JButton("    Finish     ");
		jbFinish.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				try
				{
					table.print();
				} catch (PrinterException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		jlerror.setText("");
		jpButton.add(jlerror);
		jpButton.add(jlBlank1);
		jpButton.add(jbDelete);
		jpButton.add(jlBlank2);
		jpButton.add(jbCancel);
		jpButton.add(jlBlank3);
		jpButton.add(jbFinish);
		this.add(jpButton, BorderLayout.EAST);
	}

	public static void main(String[] args) throws InterruptedException
	{
		// Object[][] data = { { "***", "***", 0, 0.00, new Boolean(false) },
		// { "***", "***", 0, 0.00, new Boolean(false) },
		// { "***", "***", 0, 0.00, new Boolean(false) } };
		// Object[][] data2 = { { "***", "***", 0, 0.00, new Boolean(false) },
		// { "***", "***", 0, 0.00, new Boolean(false) },
		// { "***", "***", 0, 0.00, new Boolean(false) },
		// { "***", "***", 0, 0.00, new Boolean(false) } };
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(800, 600);
		// frame.setResizable(false);
		CheckOutPanel ck = new CheckOutPanel();
		jf.add(ck);
		ck.updateUI();
		// Thread.sleep(2000);
		// ck.setData(data2);
		// ck.table.repaint();
	}
}
