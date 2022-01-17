package view;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPolozeni extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7253935615210747657L;

	@Override
	public int getRowCount() {
		return StudentDijalog.getRowCountPolozeni();
	}

	@Override
	public int getColumnCount() {
		return StudentDijalog.getColumnCountPolozeni();
	}

	@Override
	public String getColumnName(int column) {
		return StudentDijalog.getColumnNamePolozeni(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentDijalog.getValueAtPolozeni(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

}
