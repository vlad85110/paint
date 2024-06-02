package kirilov.vladislav.ui.input.number;

import kirilov.vladislav.ui.input.TextInputWithLabel;

import javax.swing.*;

public class NumberInputWithLabel extends TextInputWithLabel {
    private final int min;
    private final int max;

    public NumberInputWithLabel(String labelText, int min, int max, int value) {
        super(labelText);

        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, min, max, value);
        add(slider);
        slider.addChangeListener(t -> SwingUtilities.invokeLater(() ->
                textField.setText(String.valueOf(slider.getValue()))));

        textField.setText(String.valueOf(value));
        var textFieldChangeListener = new TextFieldChangeListener(slider, textField,
                () -> validateWithErrorSet(false));
        textField.getDocument().addDocumentListener(textFieldChangeListener);

        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isRight() {
        return validateWithErrorSet(true);
    }

    private boolean validateWithErrorSet(boolean isSetError) {
        var textValue = textField.getText();

        if (textValue.isBlank() || textValue.isEmpty()) {
            if (isSetError) {
                errorMessage = "пустое поле";
            }
            return false;
        }

        int intValue;
        try {
            intValue = Integer.parseInt(textValue);
        } catch (NumberFormatException e) {
            if (isSetError) {
                errorMessage = "поле должно иметь числовое значение";
            }
            return false;
        }

        if (intValue < min || intValue > max) {
            if (isSetError) {
                errorMessage = "значение выходит за допустимое множество";
            }
            return false;
        }

        return true;
    }

}
