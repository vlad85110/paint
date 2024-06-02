package kirilov.vladislav.ui.input;

import javax.swing.*;
import java.awt.*;

public abstract class TextInputWithLabel extends JPanel {
    protected final JTextField textField;
    protected final String labelText;
    protected String errorMessage;

    public TextInputWithLabel(String labelText) {
        this.labelText = labelText;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.RIGHT_ALIGNMENT);

        var textPanel = new JPanel();

        textField = new JTextField();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(labelText);
        textField.setMaximumSize(new Dimension(100, 20));

        textPanel.add(label);
        textPanel.add(textField);


        add(textPanel);
    }

    public boolean isRight() {
        return true;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getLabelText() {
        return labelText;
    }

    public String getText() {
        return textField.getText();
    }
}
