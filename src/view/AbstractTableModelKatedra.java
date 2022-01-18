package view;

import javax.swing.table.AbstractTableModel;

import model.BazaKatedri;

public class AbstractTableModelKatedra extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3536086609833619884L;

	@Override
	public int getRowCount() {
		return BazaKatedri.getInstance().getKatedre().size();
	}

	@Override
	public int getColumnCount() {
		return BazaKatedri.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaKatedri.getInstance().getValueAt(rowIndex, columnIndex);
	}

	public String getColumnName(int column) {
		return BazaKatedri.getInstance().getColumnName(column);
	}

}
