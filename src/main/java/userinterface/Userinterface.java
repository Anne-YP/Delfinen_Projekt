package userinterface;

import controller.ChairmanController;

import java.util.Scanner;

public class Userinterface {

   private ChairmanController controller;
   private Scanner scanner;

   public Userinterface(ChairmanController controller) {
       this.scanner = new Scanner(System.in);
       this.controller = controller;
   }

   public void startProgram() {
       boolean Running = true;

       while (Running) {

       }
   }
}
