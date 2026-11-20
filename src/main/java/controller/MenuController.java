package controller;

import datasource.FileHandler;
import userinterface.UserInterface;

public class MenuController {
    private FileHandler fileHandler;
    private UserInterface ui;

    public MenuController(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.ui = new UserInterface();

    }

    public static void start() {
        throw new UnsupportedOperationException("Endnu ikke implementeret");
        // UserInterface.showStartMenu();
    }

    public static void roleChoice(int input) {
        throw new UnsupportedOperationException("Endnu ikke implementeret");
        // switch (input) { case 1 (Formand) -> new ChairmanAdministration, UserInterface.showChairmanMenu()... }
    }

    // boolean running = true;
    // while (running) ?
}
