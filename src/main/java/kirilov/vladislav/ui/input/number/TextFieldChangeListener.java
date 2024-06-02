package kirilov.vladislav.ui.input.number;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.function.Supplier;

public class TextFieldChangeListener implements DocumentListener {
    private final JSlider slider;
    private final JTextField textField;

    private final Supplier<Boolean> isRight;

    public TextFieldChangeListener(JSlider slider, JTextField textField, Supplier<Boolean> isRight) {
        this.slider = slider;
        this.textField = textField;
        this.isRight = isRight;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (isRight.get()) {
            setSliderValue();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (isRight.get()) {
            setSliderValue();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (isRight.get()) {
            setSliderValue();
        }
    }

    private void setSliderValue() {
        SwingUtilities.invokeLater(() -> {
            slider.setValue(Integer.parseInt(textField.getText()));
        });
    }

}
