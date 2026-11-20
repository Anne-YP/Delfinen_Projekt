package userinterface;

import controller.MenuController;

import java.util.Scanner;

public class UserInterface {
;
   private Scanner scanner;

   public UserInterface() {
       this.scanner = new Scanner(System.in);
   }

   public static void showStartMenu() {
       throw new UnsupportedOperationException("Endnu ikke implementeret");
       // System.out.println("Vælg brugerrolle: ");
       /* System.out.println("""
               1. Formand
               2. ...
               """);
          Int input = scanner.nextLine(Integer.parse(input));
          MenuController.roleChoice(input);
        */

   }
}
