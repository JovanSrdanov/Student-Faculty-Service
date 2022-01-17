package view;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredajeProfesor extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return ProfesorDialog.getRowCountPredaje();
	}

	@Override
	public int getColumnCount() {
		return ProfesorDialog.getColumnCountPredaje();
	}

	@Override
	public String getColumnName(int column) {
		return ProfesorDialog.getColumnNamePedaje(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfesorDialog.getValueAtPredaje(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

}
