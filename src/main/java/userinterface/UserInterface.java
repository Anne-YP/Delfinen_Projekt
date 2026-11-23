package userinterface;

import controller.Controller;
import domain_model.UserRole;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller;

    public UserInterface(Controller controller) {
        this.controller = controller;
    }

    public void showStartMenu() {
        System.out.println("Velkommen til Delfinens administrative system");

        while (true) {
            // readInt er en metode længere nede, som håndterer brugerinput
            int choice = readInt("Vælg brugerrolle:\n1. Formand\n2. Kasserer\n3. Træner\nValg: ");
            try {
                // Opretter en UserRole gennem metoden selectUserRole fra Controller
                UserRole role = controller.selectUserRole(choice);
            } catch (IllegalArgumentException e) {
                System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }

        // TODO håndtering af brugerrolle og tilhørende menu

    }

    public int readInt (String prompt){
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input. Indtast venligst et heltal.");
            }
        }
    }
}