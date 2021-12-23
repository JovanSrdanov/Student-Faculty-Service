package controller;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmeti extends AbstractTableModel {
	
	@Override
	public int getRowCount() {
		if(BazaPredmeta.getInstance().getPredmeti() == null)
		{
			return 1;
		}
		return BazaPredmeta.getInstance().getPredmeti().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
	

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

}
