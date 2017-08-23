package br.com.web.util.tabela;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class TsboViewTable extends JFrame 
{

	private static final long serialVersionUID = 8772004644126791386L;

	JTable fixedTable, table;

	@SuppressWarnings("serial")
	public TsboViewTable(final Object[][] data,final Object[] column ) 
	{

		super("Posicao");
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setSize(800, 650);

		AbstractTableModel fixedModel = new AbstractTableModel() 
		{

			private static final long serialVersionUID = 1L;



			public int getRowCount() 
			{
				return data.length;
			}

			public String getColumnName(int col) 
			{
				return (String) column[col];
			}

			public Object getValueAt(int row, int col) 
			{
				return data[row][col];
			}

			@Override
			public int getColumnCount() 
			{
				return 0;
			}
		};
		final AbstractTableModel model = new AbstractTableModel() 
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = -6464407367106647964L;

			public int getColumnCount() 
			{
				return column.length ;
			}

			public int getRowCount() 
			{
				return data.length;
			}

			public String getColumnName(int col) 
			{
				return (String) column[col];
			}

			public Object getValueAt(int row, int col)
			{
				return data[row][col ];
			}

			public void setValueAt(Object obj, int row, int col) 
			{
				data[row][col] = obj;
			}

			@SuppressWarnings("unused")
			public boolean CellEditable(int row, int col) 
			{
				return true;
			}
		};

		fixedTable = new JTable(fixedModel) 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				super.valueChanged(e);
				checkSelection(true);
			}
		};
		table = new JTable(model) 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				super.valueChanged(e);
				checkSelection(false);
			}
		};
		fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		fixedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scroll = new JScrollPane(table);
		JViewport viewport = new JViewport();
		// viewport.setView(fixedTable);
		viewport.setPreferredSize(fixedTable.getPreferredSize());
		scroll.setRowHeaderView(viewport);
		scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTable.getTableHeader());

		getContentPane().add(scroll, BorderLayout.CENTER);
		
	 
		ListSelectionModel rowSM = table.getSelectionModel();

		  rowSM.addListSelectionListener(new ListSelectionListener()
		  {
		    @Override
		    public void valueChanged(ListSelectionEvent e) 
		    {
		       
		        
		        final int row = table.getSelectedRow();
	            final int column = table.getSelectedColumn();
	             
		       
	            if (model.getValueAt(row, column) instanceof TsboTable)
				{
	            	TsboTable new_name = (TsboTable) model.getValueAt(row, column);
	            	new_name.viewTable();
				}
	            
		    }
		});
		
	}
	 

	private void checkSelection(boolean isFixedTable) 
	{
		int fixedSelectedIndex = fixedTable.getSelectedRow();
		int selectedIndex = table.getSelectedRow();
		if (fixedSelectedIndex != selectedIndex) 
		{
			if (isFixedTable) 
			{
				table.setRowSelectionInterval(fixedSelectedIndex,
						fixedSelectedIndex);
			}
			else 
			{
				fixedTable
				.setRowSelectionInterval(selectedIndex, selectedIndex);
			}
		}
	}
}