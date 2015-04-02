package sg.edu.nus.iss.usstore.gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import sg.edu.nus.iss.usstore.domain.Member;
import sg.edu.nus.iss.usstore.domain.Store;


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
public class MemberReport extends javax.swing.JFrame {
	private JScrollPane memReportScrollPane;
	private JTable MemberListReportTable;
	
	private static final int num_col = 3;
	
	private ArrayList<Member> objList;
	private Object[][] objData;
	private String[] columns;
	
	public MemberReport(StoreApplication manager) {
		super("Member Report");
		this.objList=manager.getMemberList();
		columns = new String[num_col];
		objData = new Object[objList.size()][num_col];
		for(int i=0;i<objList.size();i++)
		{
			objData[i][0] = objList.get(i).getMemberID();
			objData[i][1] = objList.get(i).getName();
			objData[i][2] = objList.get(i).getLoyaltyPoint();
		}
		columns[0]="ID";
		columns[1]="Name";
		columns[2]="Loyalty Points";
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				memReportScrollPane = new JScrollPane();
				getContentPane().add(memReportScrollPane, BorderLayout.CENTER);
				memReportScrollPane.setPreferredSize(new java.awt.Dimension(697, 313));
				memReportScrollPane.setAutoscrolls(true);
				{
					TableModel MemberListReportTableModel = new DefaultTableModel(objData,columns)
					{

						@Override
						public boolean isCellEditable(int arg0, int arg1) {
							// TODO Auto-generated method stub
							return false;
						}
						
					};
					MemberListReportTable = new JTable();
					memReportScrollPane.setViewportView(MemberListReportTable);
					MemberListReportTable.setModel(MemberListReportTableModel);
					TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(MemberListReportTable.getModel());
					MemberListReportTable.setRowSorter(sorter);
					List<SortKey> sortKeys = new ArrayList<SortKey>();
					sortKeys.add(new SortKey(0, SortOrder.ASCENDING));
					MemberListReportTable.getRowSorter().setSortKeys(sortKeys);
				}
				Dimension size = MemberListReportTable.getPreferredScrollableViewportSize();
				MemberListReportTable.setPreferredScrollableViewportSize(new Dimension(Math.min(getPreferredSize().width, size.width), size.height));
			}
			resizeTableColumnWidth(MemberListReportTable);
			pack();
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void resizeTableColumnWidth(JTable table)
	{
		for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();

		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);

		        //  We've exceeded the maximum width, no need to check other rows

		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		    TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer(); 
		    Component headerComp = headerRenderer.getTableCellRendererComponent(table, tableColumn.getHeaderValue(), false, false, 0, column);
		    tableColumn.setPreferredWidth(Math.max(preferredWidth,headerComp.getMaximumSize().width));
		}
	}

}
