package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitiveSwimmer extends Member{
private ArrayList<Discipline> disciplines;
private int trainingResult;

// En konkurrencesvømmer har vel også attributter for stævner, stævnetid samt træningstid.
// Er en træningstid ikke bare en attribut for en konkurrencesvømmer?

    public CompetitiveSwimmer(String name, LocalDate dateOfBirth, int memberId, boolean isActive, boolean isCompetitive, ArrayList<Discipline> disciplines, int trainingResult) {
        super(name, dateOfBirth, memberId, isActive, isCompetitive);
        this.disciplines = disciplines;
        this.trainingResult = trainingResult;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    public int getTrainingResult() {
        return trainingResult;
    }

    public void setTrainingResult(int trainingResult) {
        this.trainingResult = trainingResult;
    }

    @Override
    public String toString(){
        StringBuilder disciplinesText = new StringBuilder();
        for (Discipline discipline : disciplines) {
            disciplinesText.append(discipline).append(", ");
        }
        if (!disciplines.isEmpty()) {
            disciplinesText.delete(
                    disciplinesText.length() - 2,
                    disciplinesText.length());
        }
        return super.toString() + "Discipliner: " + disciplinesText + "\n";
    }
}
