package userinterface;

import controller.Controller;
import domain_model.UserRole;

import java.io.IOException;
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
            int choice = readInt("Vælg brugerrolle:\n" +
                    "1. Formand\n" +
                    "2. Kasserer\n" +
                    "3. Træner\n" +
                    "Valg: ");

            try {
                // Opretter en UserRole gennem metoden selectUserRole fra Controller
                UserRole role = controller.selectUserRole(choice);

                /*
                Switch'en som har ansvar for at sende brugeren til den rigtige menu,
                placerer jeg her i UI i stedet for i Controller, da det er UI's ansvar
                at "styre præsentationen" og vælge, hvilken menu brugeren skal se.
                Controlleren skal derimod håndtere brugerens valg og videresende funktionelle opgaver,
                så vi undgår unødig kobling mellem Controller og UI.
                 */

                switch (role) {
                    case CHAIRMAN -> chairmanMenu();
                    case TREASURER -> treasurerMenu();
                    case COACH -> coachMenu();
                };

                break; // Afslutter while-loopet når der er valgt gyldig brugerrolle. Ellers ville programmet vise startmenuen igen når den valgte menu er "færdig".

            } catch (IllegalArgumentException e) {
                System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }

        // TODO håndtering af brugerrolle og tilhørende menu
        // showSpecificMenu(UserRole role)...

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

    public void chairmanMenu() {
        System.out.println("==== FORMAND ADMINISTRATION ===");
        System.out.println("1. Opret et medlem"); // med navn, fødselsdato og aktivitetsform, samt svømmehold + herunder konkurrencesvømmer og tilhørende disciplin(er)
        System.out.println("2. Rediger medlem");
        System.out.println("3. Slet medlem");
        System.out.println("4. Se medlemsoversigt"); // med navn, alder, junior/senior, aktivitetsform (passiv, motionist eller konkurrence)
    }

    public void treasurerMenu() {
        System.out.println("==== KASSERER ADMINISTRATION ===");
        System.out.println("1. Se et medlems årlige kontingent");
        System.out.println("2. Registrér betaling");
        System.out.println("3. Se liste over medlemmer i restance"); // med medlemsnummer, navn og det beløb de skylder
        System.out.println("4. Se forventet samlet kontingentindtægt");
    }

    public void coachMenu() {
        System.out.println("==== TRÆNER ADMINISTRATION ===");
        System.out.println("1. Se holdoversigt"); // herunder junior eller senior, vis konkurrencesvømmere samt hvilke discipliner de er aktive i
        System.out.println("2. Registrér træningstid"); // for disciplin med dato
        System.out.println("3. Registrér stævneresultat"); // med stævnets navn, dato, disciplin, placering og tid
        System.out.println("4. Se resultater for en bestemt konkurrencesvømmer"); // bedste træningstid i hver disciplin og alle stævneresultater
        System.out.println("5. Se top 5 for disciplin og hold"); // herunder discipliner og junior samt senior
    }
}