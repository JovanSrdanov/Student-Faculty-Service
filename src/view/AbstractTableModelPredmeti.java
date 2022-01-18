package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaProfesora;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		
		if(MyFrame.getInstance().isPretraga()) {
			if (BazaPredmeta.getInstance().getPredmetiPretraga() == null) {
				return 1;
			}
			return BazaPredmeta.getInstance().getPredmetiPretraga().size();
		}
		else {
			if (BazaPredmeta.getInstance().getPredmeti() == null) {
				return 1;
			}
			return BazaPredmeta.getInstance().getPredmeti().size();
		}
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
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(BazaPredmeta.getInstance().getPredmeti().isEmpty())
			return Object.class;
		return getValueAt(0, columnIndex).getClass();
	}

}
