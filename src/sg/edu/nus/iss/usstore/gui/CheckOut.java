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
	// 表格中各行的内容保存在二维数组data中
	private final static Object[][] data= {
	{ "***", "***",0,0.00,new Boolean(false) }};
	
	public CheckOut() { // 实现构造方法
		super("CheckOut!"); // 首先调用父类JFrame的构造方法生成一个窗口
		JLabel Title = new JLabel("Check Out!");
		Title.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Title,BorderLayout.NORTH);
		MyTableModel myModel = new MyTableModel();// myModel存放表格的数据
		JTable table = new JTable(myModel);// 表格对象table的数据来源是myModel对象
		//table.setPreferredScrollableViewportSize(new Dimension(500, 400));// 表格的显示尺寸
		// 产生一个带滚动条的面板
		JScrollPane scrollPane = new JScrollPane(table);
		// 将带滚动条的面板添加入窗口中
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {// 注册窗口监听器
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		
	}

	// 把要显示在表格中的数据存入字符串数组和Object数组中
	class MyTableModel extends AbstractTableModel {
		// 表格中第一行所要显示的内容存放在字符串数组columnNames中
		final String[] columnNames = { "Num", "Product", "Quan",
				"Price", "Del" };
		
		// 下述方法是重写AbstractTableModel中的方法，其主要用途是被JTable对象调用，以便在表格中正确的显示出来。程序员必须根据采用的数据类型加以恰当实现。

		// 获得列的数目
		public int getColumnCount() {
			return columnNames.length;
		}

		// 获得行的数目
		public int getRowCount() {
			return data.length;
		}

		// 获得某列的名字，而目前各列的名字保存在字符串数组columnNames中
		public String getColumnName(int col) {
			return columnNames[col];
		}

		// 获得某行某列的数据，而数据保存在对象数组data中
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		// 判断每个单元格的类型
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		// 将表格声明为可编辑的
		public boolean isCellEditable(int row, int col) {

//			if (col < 2) {
//				return false;
//			} else {
//				return true;
//			}
			return true;
		}

		// 改变某个数据的值
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
