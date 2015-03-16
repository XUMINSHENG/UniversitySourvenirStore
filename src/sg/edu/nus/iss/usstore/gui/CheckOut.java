package sg.edu.nus.iss.usstore.gui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

public class CheckOut extends JFrame {
	private boolean DEBUG = true;
	// ����и��е����ݱ����ڶ�ά����data��
	private final static Object[][] data= {
	{ "***", "***",0,0.00,new Boolean(false) }};
	
	public CheckOut() { // ʵ�ֹ��췽��
		super("CheckOut!"); // ���ȵ��ø���JFrame�Ĺ��췽������һ������
		JLabel Title = new JLabel("Check Out!");
		Title.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Title,BorderLayout.NORTH);
		MyTableModel myModel = new MyTableModel();// myModel��ű�������
		JTable table = new JTable(myModel);// ������table��������Դ��myModel����
		//table.setPreferredScrollableViewportSize(new Dimension(500, 400));// ������ʾ�ߴ�
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

//			if (col < 2) {
//				return false;
//			} else {
//				return true;
//			}
			return true;
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
		frame.setResizable(false);
		frame.setTitle("CheckOut!");
		
		}
}
