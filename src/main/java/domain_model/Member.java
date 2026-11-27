package domain_model;

import java.time.LocalDate;
import java.time.Period;

public class Member {
    private String name;
    private LocalDate dateOfBirth;
    private int memberId;
    private boolean isActive;
    private boolean isCompetitive;
    private AgeGroup ageGroup;

    // AgeGroup - Ved ikke lige hvordan den skal tilkendegives

    public Member (String name, LocalDate dateOfBirth, int memberId, boolean isActive, boolean isCompetitive) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.memberId = memberId;
        this.isActive = isActive;
        this.isCompetitive = isCompetitive;
        this.ageGroup = calculateAgeGroup(dateOfBirth);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Navn må ikke være tom.");
        }
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMemberId(){
        return memberId;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }
    public void setCompetitive(boolean competitive) {
        isCompetitive = competitive;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public int getAge() {
      return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public AgeGroup calculateAgeGroup(LocalDate dateOfBirth) {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        int age = period.getYears();
        AgeGroup ageGroup;
        if (age < 18) {
            return AgeGroup.JUNIOR;
        } else {
            return AgeGroup.SENIOR;
        }
    }

    @Override
    public String toString(){
        String ActiveMemberText =  isActive ? "Aktiv" : "Passiv";
        String CompetitiveMemberText = isCompetitive ? "Ja" : "Nej";
        return "Navn: " + name
                + "\nFødselsdato: " + dateOfBirth
                + "\nMedlemsnummer: " + memberId
                + "\nAktiv/Passiv: " + ActiveMemberText
                + "\nKonkurrencesvømmer: " + CompetitiveMemberText
                + "\nHoldtype: " + ageGroup + "\n";
    }
}
