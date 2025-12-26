package view;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ButtonEditor extends DefaultCellEditor {

    private JButton button;
    private String label;
    private boolean clicked;
    private JTable table;
    private String userId;

    public ButtonEditor(JCheckBox checkBox, JTable table, String userId) {
        super(checkBox);
        this.table = table;
        this.userId = userId;

        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected,
            int row, int column) {

        label = value.toString();
        button.setText(label);
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            String topic = table.getValueAt(table.getSelectedRow(), 0).toString();

            if (label.equals("Study")) {
                new LessonView(topic).setVisible(true);
            } else {
                new TestView(userId, topic).setVisible(true);
            }
        }
        clicked = false;
        return label;
    }
}

