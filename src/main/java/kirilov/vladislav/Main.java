package kirilov.vladislav;

import kirilov.vladislav.location.Location;
import kirilov.vladislav.ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Location.centreWindow(mainFrame);
        mainFrame.addResizeListener();
        mainFrame.addCanvasImage();
    }
}