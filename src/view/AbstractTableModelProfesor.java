package view;


import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfesor extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7581908303391038961L;

	@Override
	public int getRowCount() {
		if(MyFrame.getInstance().isPretraga()) {
			if (BazaProfesora.getInstance().getProfesoriPretraga() == null) {
				return 0;
			}
			return BazaProfesora.getInstance().getProfesoriPretraga().size();
		}
		else {
			if (BazaProfesora.getInstance().getProfesori() == null) {
				return 0;
			}
			return BazaProfesora.getInstance().getProfesori().size();
		}
		
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(BazaProfesora.getInstance().getProfesori().isEmpty())
			return Object.class;
		return getValueAt(0, columnIndex).getClass();
	}
	
}
