package sg.edu.nus.iss.usstore.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

public class CheckOut extends JFrame {
	private boolean DEBUG = true;
	// ����и��е����ݱ����ڶ�ά����data��
	private final static Object[][] data= {
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) },
		{ "***", "***",0,0.00,new Boolean(false) }};
	
	public CheckOut() { // ʵ�ֹ��췽��
		super("CheckOut!"); // ���ȵ��ø���JFrame�Ĺ��췽������һ������
		
		//OPeration
		JPanel jpOperation = new JPanel();
		getContentPane().add(jpOperation,BorderLayout.NORTH);
		//Title
		JLabel jlTitle = new JLabel("Check Out!");
		jlTitle.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpOperation.setLayout(new GridLayout(3,1));
		jpOperation.add(jlTitle);
		JPanel jpInput = new JPanel();
		JPanel jpOutput = new JPanel();
		jpOperation.add(jpInput);
		jpOperation.add(jpOutput);
		
		//Input
		jpOperation.add(jpInput);
		jpInput.setLayout(new GridLayout(2,2));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();

		//jp1
		JLabel JlMemberID = new JLabel("MEMBER ID");
		JTextField JtMemberID = new JTextField(24);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.add(JlMemberID);
		jp1.add(JtMemberID);
		jpInput.add(jp1);
		
		//jp2
		JLabel JlMemberName = new JLabel("MEMBER  NAME");
		JLabel JlgetMemberName = new JLabel("PUBLIC");
		JLabel JlLoyalPoint = new JLabel("LOYAL POINT");
		JLabel JlLoyalPointNum = new JLabel("0");
		jp2.setLayout(new GridLayout(1,2));
		JPanel jp2_1 = new JPanel();
		JPanel jp2_2 = new JPanel();
		jp2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2_1.add(JlMemberName);
		jp2_1.add(JlgetMemberName);
		jp2_2.add(JlLoyalPoint);
		jp2_2.add(JlLoyalPointNum);
		jp2.add(jp2_1);
		jp2.add(jp2_2);
		jpInput.add(jp2);
		
		//jp3
		JLabel JlBarCodeID = new JLabel("Bar   Code  ");
		JTextField JtBarCodeID = new JTextField(24);
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3.add(JlBarCodeID);
		jp3.add(JtBarCodeID);
		jpInput.add(jp3);
		
		//jp4
		jp4.setLayout(new GridLayout(1,2));
		JPanel jp4_1 = new JPanel();
		JPanel jp4_2 = new JPanel();
		jp4_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp4_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel jlQuantity = new JLabel("QUANTITY");
		JTextField jtQuantity = new JTextField(6);
		JButton jbQuantity = new JButton("Submit");
		jp4_1.add(jlQuantity);
		jp4_1.add(jtQuantity);
		jp4_2.add(jbQuantity);
		jp4.add(jp4_1);
		jp4.add(jp4_2);
		jpInput.add(jp4);
		
		//output
		jpOperation.add(jpOutput);
		jpOutput.setLayout(new GridLayout(2,4));
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		JPanel jp8 = new JPanel();
		JPanel jp9 = new JPanel();
		JPanel jp10 = new JPanel();
		JPanel jp11 = new JPanel();
		JPanel jp12 = new JPanel();
		
		//jp5
		jp5.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlTotalPrice = new JLabel("Total Price:");
		JLabel JlTotalPriceNum = new JLabel("00.00");
		jp5.add(JlTotalPrice);
		jp5.add(JlTotalPriceNum);
		jpOutput.add(jp5);
		
		//jp6
		jp6.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlDiscount = new JLabel("Discount:");
		JLabel JlDiscountNum = new JLabel("00.00");
		jp6.add(JlDiscount);
		jp6.add(JlDiscountNum);
		jpOutput.add(jp6);
		
		//jp7
		jp7.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlDiscountedPrice = new JLabel("Discountd:");
		JLabel JlDiscountedPriceNum = new JLabel("00.00");
		jp7.add(JlDiscountedPrice);
		jp7.add(JlDiscountedPriceNum);
		jpOutput.add(jp7);
		
		//jp8
		jp8.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlPaid = new JLabel("Use Point");
		JTextField JtPaidNum = new JTextField(6);
		jp8.add(JlPaid);
		jp8.add(JtPaidNum);
		jpOutput.add(jp8);
		
		//jp9
		jp9.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlRest = new JLabel("REST:");
		JLabel JlRestNum = new JLabel("00.00");
		jp9.add(JlRest);
		jp9.add(JlRestNum);
		jpOutput.add(jp9);
		
		//jp10
		jp10.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlCash = new JLabel("Cash:");
		JTextField JtCashNum = new JTextField(6);
		jp10.add(JlCash);
		jp10.add(JtCashNum);
		jpOutput.add(jp10);
		
		//jp11
		jp11.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel JlChange = new JLabel("CHANGE:");
		JLabel JlChangeNum = new JLabel("00.00");
		jp11.add(JlChange);
		jp11.add(JlChangeNum);
		jpOutput.add(jp11);
		
		//jp12
		jp12.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton jbFinish = new JButton("Finish");
		jp12.add(jbFinish);
		jpOutput.add(jp12);
		
		//Table
		MyTableModel myModel = new MyTableModel();// myModel��ű�������
		JTable table = new JTable(myModel);// ������table��������Դ��myModel����
		table.setPreferredScrollableViewportSize(new Dimension(500, 400));// ������ʾ�ߴ�
		// ����һ���������������
		JScrollPane scrollPane = new JScrollPane(table);
		// �������������������봰����
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {// ע�ᴰ�ڼ�����
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// ��Ҫ��ʾ�ڱ���е����ݴ����ַ��������Object������
	class MyTableModel extends AbstractTableModel {
		// ����е�һ����Ҫ��ʾ�����ݴ�����ַ�������columnNames��
		final String[] columnNames = { "Num", "Product", "Quan",
				"Price", "Del" };
		
		// ������������дAbstractTableModel�еķ���������Ҫ��;�Ǳ�JTable������ã��Ա��ڱ������ȷ����ʾ����������Ա������ݲ��õ��������ͼ���ǡ��ʵ�֡�

		// ����е���Ŀ
		public int getColumnCount() {
			return columnNames.length;
		}

		// ����е���Ŀ
		public int getRowCount() {
			return data.length;
		}

		// ���ĳ�е����֣���Ŀǰ���е����ֱ������ַ�������columnNames��
		public String getColumnName(int col) {
			return columnNames[col];
		}

		// ���ĳ��ĳ�е����ݣ������ݱ����ڶ�������data��
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		// �ж�ÿ����Ԫ�������
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		// ���������Ϊ�ɱ༭��
		public boolean isCellEditable(int row, int col) {

			if (col ==2||col ==4) {
				return true;
			} else {
				return false;
			}
		}

		// �ı�ĳ�����ݵ�ֵ
		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("Setting value at " + row + "," + col
						+ " to " + value + " (an instance of "
						+ value.getClass() + ")");
			}

			if (data[0][col] instanceof Integer && !(value instanceof Integer)) {
				try {
					data[row][col] = new Integer(value.toString());
					fireTableCellUpdated(row, col);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(CheckOut.this, "The \""
							+ getColumnName(col)
							+ "\" column accepts only integer values.");
				}
			} else {
				data[row][col] = value;
				fireTableCellUpdated(row, col);
			}

			if (DEBUG) {
				System.out.println("New value of data:");
				printDebugData();
			}
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print(" row " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print(" " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
	}

	public static void main(String[] args) {
		CheckOut frame = new CheckOut();
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 600);
		//frame.setResizable(false);
		frame.setTitle("CheckOut!");
		}
}
