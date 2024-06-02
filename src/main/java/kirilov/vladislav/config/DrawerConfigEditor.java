package kirilov.vladislav.config;

import kirilov.vladislav.ui.input.TextInputWithLabel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class DrawerConfigEditor {
    protected Map<String, TextInputWithLabel> inputs = new HashMap<>();
    protected final JComponent configForm;
    protected final JPanel inputPanel;
    protected JLabel errorLabel = new JLabel("");

    public DrawerConfigEditor() {
        configForm = new JPanel();
        inputPanel = new JPanel();

        configForm.add(errorLabel);
        configForm.add(inputPanel);

        inputPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        inputPanel.setMinimumSize(new Dimension(300, 100));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public JComponent getConfigForm() {
        return configForm;
    }

    public boolean validateAndSet() {
        StringBuilder error = new StringBuilder();

        error.append("<html>");

        for (var input : inputs.values()) {
            if (!input.isRight()) {
                error.append(input.getLabelText()).append(" : ").append(input.getErrorMessage()).append("<br/>");
            }
        }

        error.append("</html>");

        errorLabel.setText(error.toString());
        var res =  error.toString().equals("<html></html>");

        if (res) {
            editDrawer();
        }

        return res;
    }

    protected void editDrawer() {

    }
}
