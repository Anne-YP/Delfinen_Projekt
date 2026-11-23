package domain_model;

public class CompetitiveSwimmer extends Member{
private Discipline discipline;
private int trainingResult;

// En konkurrencesvømmer har vel også attributter for stævner, stævnetid samt træningstid.
// Er en træningstid ikke bare en attribut for en konkurrencesvømmer?

    public CompetitiveSwimmer(String name, int dateOfBirth, int memberId, boolean isActive, boolean isCompetitive, Discipline discipline, int trainingResult) {
        super(name, dateOfBirth, memberId, isActive, isCompetitive);
        this.discipline = discipline;
        this.trainingResult = trainingResult;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getTrainingResult() {
        return trainingResult;
    }

    public void setTrainingResult(int trainingResult) {
        this.trainingResult = trainingResult;
    }
}
