package Menu;


import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Color;
import java.util.Set;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    private Set<String> clientesQuePagaram; // Suponha que você use nomes de clientes ou IDs como identificador

    public CustomCellRenderer(Set<String> clientesQuePagaram) {
        this.clientesQuePagaram = clientesQuePagaram;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Supondo que a primeira coluna contenha o nome do cliente
        String nomeCliente = (String) table.getValueAt(row, 0);

        if (clientesQuePagaram.contains(nomeCliente)) {
            c.setBackground(new Color(36, 168, 36));
        } else {
            c.setBackground(new Color(255, 99, 71));
        }
        return c;
    }
}

