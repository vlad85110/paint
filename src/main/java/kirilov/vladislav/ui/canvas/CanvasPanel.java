package kirilov.vladislav.ui.canvas;

import kirilov.vladislav.tool.Drawer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CanvasPanel extends JPanel {
    private BufferedImage canvas;
    private Drawer drawer;
    private int x1, y1, x2, y2;
    private CanvasAction canvasAction = CanvasAction.NOTHING;
    private Color color = Color.BLACK;

    public CanvasPanel() {
        MouseListener canvasMouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();

                canvasAction = CanvasAction.DRAW;
                repaint();
            }
        };

        addMouseListener(canvasMouseListener);
    }


    public void initCanvas() {
        setMinimumSize(getSize());
        this.canvas = new BufferedImage(super.getWidth(), super.getHeight(), BufferedImage.TYPE_INT_RGB);
        var graphics = canvas.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void setImage(File file) {
        SwingUtilities.invokeLater(() -> {
            BufferedImage image;

            try {
                image = ImageIO.read(file);
                this.canvas = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
                canvas.createGraphics().drawImage(image, 0, 0, null);
                setSize(canvas.getWidth(), canvas.getHeight());
                resizeCanvas();
                repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (canvasAction) {
            case DRAW -> drawer.draw(this, x1, y1, x2, y2);
            case CLEAR_SCREEN -> {
                var graphics = canvas.getGraphics();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            }
        }

        canvasAction = CanvasAction.NOTHING;
        g.drawImage(canvas, 0, 0, this);
    }

    public void clearScreen() {
        canvasAction = CanvasAction.CLEAR_SCREEN;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension minSize = getMinimumSize();
        Dimension currentSize = getSize();
        currentSize.width = Math.max(currentSize.width, minSize.width);
        currentSize.height = Math.max(currentSize.height, minSize.height);
        return currentSize;
    }

    public void resizeCanvas() {
        SwingUtilities.invokeLater(() -> {
            var newSize = getPreferredSize();
            var oldCanvas = canvas;
            var width = oldCanvas.getWidth();
            var height = oldCanvas.getHeight();

            if (newSize.getWidth() > width || newSize.getHeight() > height) {
                initCanvas();

                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        canvas.setRGB(i, j, oldCanvas.getRGB(i, j));
                    }
                }

                canvasAction = CanvasAction.RESIZE;
                repaint();
            }
        });
    }

    public BufferedImage getCanvas() {
        return canvas;
    }

    public Drawer getDrawer() {
        return drawer;
    }

    public void setDrawer(Drawer drawer) {
        this.drawer = drawer;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCanvasHeight() {
        return canvas.getHeight();
    }

    public int getCanvasWidth() {
        return canvas.getWidth();
    }

    public Graphics getCanvasGraphics() {
        return canvas.getGraphics();
    }

    public void setRGB(int x, int y) {
        canvas.setRGB(x, y, color.getRGB());
    }

    public int getRGB(int x, int y) {
        return canvas.getRGB(x, y);
    }
}
