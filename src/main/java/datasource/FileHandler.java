package datasource;

import domain_model.AgeGroup;
import domain_model.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {

    // === Attributter ===
    // HEADER
    // String fileName
    // int skippedLineCount

    private String fileName;
    private int skippedLineCount;
    private static final String HEADER = "name;dateOfBirth;memberId;isActive;isCompetitive";


    // === Constructor (String fileName) ===
    // skippedLineCount = 0;

    public FileHandler(String fileName) {
        this.fileName = fileName;
        this.skippedLineCount = 0;
    }


    // 1) === Metode til at skrive TIL CSV filen ===
    // public void saveMembers(Arraylist<Member> members) + exception
    // PrintStream
    // Husk at skrive HEADER til fil
    // enhanced for-loop, hvor objekterne skrives til CSV-linje
    // Husk at lukke PrintStream

    public void saveMembers(ArrayList<Member> members) throws FileNotFoundException {
        PrintStream output = new PrintStream(fileName);
        output.println(HEADER);

        for (Member member : members) {
            output.println(toCsvLine(member));
        }

        output.close();
    }



    // 2) === Metode til at omskrive objekt til CSV linje ===
    // private String toCSVLine(Member member)
    // String name = member.getName(); ... getters ...
    // return String.join(";", name....)

    private String toCsvLine(Member member) {
        String name = member.getName();
        String dateOfBirth = String.valueOf(member.getDateOfBirth());
        String memberId = String.valueOf(member.getMemberId());
        String isActive = String.valueOf(member.isActive());
        String isCompetitive = String.valueOf(member.isCompetitive());

        return String.join(";", name, dateOfBirth, memberId, isActive, isCompetitive);
    }


    // 3) === Metode til at læse FRA CSV filen ===
    // public ArrayList<Member> loadMembers() + exception
    // ArrayList<Member> members = new ArrayList<>();
    // Scanner(new File(fileName));
    // skippedLineCount = 0;
    /* Hvis filen ikke er tom, skip første linje som er header

    if (scanner.hasNextLine()) {
            scanner.nextLine();
        } else {
            return movies;
        }

     */

    // while-loop som kører CSV-linjerne igennem og gemmer dem i String line (som bruges i parseMember)
    // Derefter omdannes string til Member-objekt gennem parseMember()

    public ArrayList<Member> loadMembers() throws FileNotFoundException {
        ArrayList<Member> members = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        skippedLineCount = 0;

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        else {
            return members;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Member member = parseMember(line);

            if (member != null) {
                members.add(member);
            }
            else {
                skippedLineCount++;
            }
        }
        scanner.close();
        return members;
    }


    // 4) === Metode til at konvertere en CSV-linje til et Member-objekt ===
    // static Member parseMember(String line)
    // Opret et String-array (fx String[] fields = ...) som splitter CSV-filen i fx alder, fødselsdato osv. (line.split(";", -1));
    /*

    if (fields.length != [antal af attributter]) {
            return null;
        }

     */

    // try/catch: String name = fields[0]; osv.) + DateTimeParseException || IllegalArgumentException (return null)
    // return new Member(name, osv...)

    static Member parseMember(String line) {
        String[] fields = line.split(";", -1);

        if (fields.length != 5) {
            return null;
        }

        try {
            String name = fields[0];
            LocalDate dateOfBirth = LocalDate.parse(fields[1]);
            int memberId = Integer.parseInt(fields[2]);
            boolean isActive = Boolean.parseBoolean(fields[3]);
            boolean isCompetitive = Boolean.parseBoolean(fields[4]);


            return new Member(name, dateOfBirth, memberId, isActive, isCompetitive);

        } catch (DateTimeException | IllegalArgumentException e) {
            return null;
        }
    }


    // 5) === Metode til at udskrive skippedLineCount (getter) ===
    // public int getSkippedLineCount() { return skippedLineCount }

    public int getSkippedLineCount() {
        return skippedLineCount;
    }
}
