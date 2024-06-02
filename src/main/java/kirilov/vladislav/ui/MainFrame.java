package kirilov.vladislav.ui;

import kirilov.vladislav.ui.canvas.CanvasPanel;
import kirilov.vladislav.ui.navigation.NavigationPanel;
import kirilov.vladislav.ui.navigation.PaintMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private final CanvasPanel canvas;

    public MainFrame() throws HeadlessException {
        super("Paint");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new CanvasPanel();

        NavigationPanel navigationPanel = new NavigationPanel(canvas);
        add(navigationPanel, BorderLayout.PAGE_START);

        PaintMenuBar menuBar = new PaintMenuBar(navigationPanel);
        setJMenuBar(menuBar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(canvas);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        pack();

        int width = 640;
        int height = 480;
        setSize(width, height);
        setVisible(true);
    }

    public void addCanvasImage() {
        SwingUtilities.invokeLater(() -> {
            canvas.initCanvas();
            canvas.repaint();
        });

    }

    public void addResizeListener() {
        Timer timer = new Timer(50, e -> {
            canvas.resizeCanvas();
        });

        timer.setRepeats(false);
        timer.setCoalesce(false);
        SwingUtilities.invokeLater(() -> addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                timer.restart();
            }
        }));
    }
}
