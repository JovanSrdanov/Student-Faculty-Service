package view;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelNepolozeni extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7253935615210747657L;

	@Override
	public int getRowCount() {
		return StudentDijalog.getRowCount();
	}

	@Override
	public int getColumnCount() {
		return StudentDijalog.getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return StudentDijalog.getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentDijalog.getValueAt(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

}
