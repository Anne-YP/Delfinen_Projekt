package userinterface;

import controller.Controller;
import domain_model.Member;
import domain_model.UserRole;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller;

    public UserInterface(Controller controller) {
        this.controller = controller;
    }

        public void showStartMenu () {
        boolean isRunning = true;
            // loadmembers(); --> Vi skal bruge den her til fileHandler
            while (isRunning) {
                System.out.println("Velkommen til Delfinens administrative system");
                // readInt er en metode længere nede, som håndterer brugerinput
                int choice = readInt("Vælg brugerrolle:\n" +
                        "1. Formand\n" +
                        "2. Kasserer\n" +
                        "3. Træner\n" +
                        "0. Afslut\n" +
                        "Valg: ");

                if (choice == 0) {
                    isRunning = false;
                }

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
                    }

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

        public void chairmanMenu () {
            boolean running = true;
            while (running) {
                System.out.println("==== FORMAND ADMINISTRATION ===");
                System.out.println("1. Opret et medlem"); // med navn, fødselsdato og aktivitetsform, samt svømmehold + herunder konkurrencesvømmer og tilhørende disciplin(er)
                System.out.println("2. Rediger medlem");
                System.out.println("3. Slet medlem");
                System.out.println("4. Se medlemsoversigt"); // med navn, alder, junior/senior, aktivitetsform (passiv, motionist eller konkurrence)
                System.out.println("0. Afslut");

                //Skal vi ikke også have en afslut-mulighed?
                // System.out.println("0. Afslut");

                String chairmanChoice = scanner.nextLine();
                switch (chairmanChoice) {
                    case "1" -> createMember();
                    case "4" -> showAllMembers();
                    case "0" -> running = false;
                    default -> System.out.println("Ugyldigt valg.");
                }
            }
            System.out.println("Farvel!");
        }

        public void treasurerMenu () {
            boolean running = true;
            while (running) {
                System.out.println("==== KASSERER ADMINISTRATION ===");
                System.out.println("1. Se et medlems årlige kontingent");
                System.out.println("2. Registrér betaling");
                System.out.println("3. Se liste over medlemmer i restance"); // med medlemsnummer, navn og det beløb de skylder
                System.out.println("4. Se forventet samlet kontingentindtægt");

                // Switch
                //  case "0" -> afslut (running = false)
            }
        }

        public void coachMenu () {
            boolean running = true;
            while (running) {
                System.out.println("==== TRÆNER ADMINISTRATION ===");
                System.out.println("1. Se holdoversigt"); // herunder junior eller senior, vis konkurrencesvømmere samt hvilke discipliner de er aktive i
                System.out.println("2. Registrér træningstid"); // for disciplin med dato
                System.out.println("3. Registrér stævneresultat"); // med stævnets navn, dato, disciplin, placering og tid
                System.out.println("4. Se resultater for en bestemt konkurrencesvømmer"); // bedste træningstid i hver disciplin og alle stævneresultater
                System.out.println("5. Se top 5 for disciplin og hold"); // herunder discipliner og junior samt senior

                // Switch
                //  case "0" -> afslut (running = false)
            }
        }


        // TODO US1: createmember()
        private void createMember () {
            String name = "";
            while (name.isEmpty()) {
                System.out.println("Indtast navn: ");
                name = scanner.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Navn må ikke stå tomt. Indtast navn: ");
                } else if (name.matches("\\d+")) {
                    System.out.println("Navn må ikke kun bestå af tal.");
                }
            }

            LocalDate dateOfBirth = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            while (dateOfBirth == null) {
                System.out.println("Indtast fødselsdato. (dd-mm-yyyy): ");
                String input = scanner.nextLine();
                try {
                    dateOfBirth = LocalDate.parse(input, formatter);
                    if (dateOfBirth.isAfter(LocalDate.now())) {
                        System.out.println("Fødselsdatoen kan ikke ligge i fremtiden.");
                        dateOfBirth = null;
                    } else if (dateOfBirth.isBefore(LocalDate.now().minusYears(100))) {
                        System.out.println("Ugyldig datoformat. For høj alder.");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Ugyldigt datoformat. Brug formatet dd-mm-yyyy.");
                }
            }

            boolean isActive = false;
            boolean validActiveInput = false;
            while (!validActiveInput) {
                System.out.println("Er medlemmet aktivt? (ja/nej): ");
                String activeInput = scanner.nextLine().trim();
                if (activeInput.equalsIgnoreCase("ja") || activeInput.equalsIgnoreCase("j")) {
                    isActive = true;
                    validActiveInput = true;
                } else if (activeInput.equalsIgnoreCase("nej") || activeInput.equalsIgnoreCase("n")) {
                    validActiveInput = true;
                } else {
                    System.out.println("Ugyldigt svar. Skriv ja/j eller nej/n");
                }
            }

            boolean isCompetitive = false;
            if (isActive) {
                boolean validCompetitiveInput = false;
                while (!validCompetitiveInput) {
                    System.out.println("Er medlemmet konkurrencesvømmer? (ja/nej): ");
                    String competitiveInput = scanner.nextLine().trim();
                    if (competitiveInput.equalsIgnoreCase("ja") || competitiveInput.equalsIgnoreCase("j")) {
                        isCompetitive = true;
                        validCompetitiveInput = true;
                    } else if (competitiveInput.equalsIgnoreCase("nej") || competitiveInput.equalsIgnoreCase("n")) {
                        isCompetitive = false;
                        validCompetitiveInput = true;
                    } else {
                        System.out.println("Ugyldigt svar. skriv ja/j eller nej/n.");
                    }
                }
            }
            try {
                controller.addMember(name, dateOfBirth, isActive, isCompetitive);
                System.out.println("Medlemmet er blevet oprettet.\n");

                // TODO tilføj visning af medlemsID
                // System.out.println("Medlemsnummer: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //US4 Se medlemsoversigt
        private void showAllMembers () {
            System.out.println("=== Medlemsoversigt ===");

            ArrayList<Member> members = controller.getMembers();
            for (Member m : members) {
                System.out.println("Navn: " + m.getName());
                System.out.println("Fødselsdato: " + m.getDateOfBirth());
                System.out.println("Medlemsnummer: " + m.getMemberId());
                if (m.isActive()) {
                    System.out.println("Aktiv/Passiv: Aktiv");
                } else {
                    System.out.println("Aktiv/Passiv: Passiv");
                }
                if (m.isCompetitive()){
                    System.out.println("Konkurrencesvømmer: Ja");
                } else {
                    System.out.println("Konkurrencesvømmer: Nej");
                }
                System.out.println("");
            }
            if (members.isEmpty()) {
                System.out.println("Ingen medlemmer oprettet.");
            }
        }
    }