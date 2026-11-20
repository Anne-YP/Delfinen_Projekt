package userinterface;

import controller.Controller;

import java.util.Scanner;

public class Userinterface {

   private Controller controller;
   private Scanner scanner;

   public Userinterface(Controller controller) {
       this.scanner = new Scanner(System.in);
       this.controller = controller;
   }

   public void startProgram() {
       boolean Running = true;

       while (Running) {

       }
   }
}
