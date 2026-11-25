package datasource;

public class FileHandler {
    private FileHandler filename;
    // === Attributter ===
    // HEADER
    // String fileName
    // int skippedLineCount

    // === Constructor (String fileName) ===
    // skippedLineCount = 0;


    // 1) === Metode til at skrive TIL CSV filen ===
    // public void saveMembers(Arraylist<Member> members) + exception
    // PrintStream
    // Husk at skrive HEADER til fil
    // enhanced for-loop, hvor objekterne skrives til CSV-linje
    // Husk at lukke PrintStream


    // 2) === Metode til at omskrive objekt til CSV linje ===
    // private String toCSVLine(Member member)
    // String name = member.getName(); ... getters ...
    // return String.join(";", name....)


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


    // 5) === Metode til at udskrive skippedLineCount (getter) ===
    // public int getSkippedLineCount() { return skippedLineCount }
}
