package domain_model;

import java.time.LocalDate;

public class Member {
    private String name;
    private LocalDate dateOfBirth;
    private int memberId;
    private boolean isActive;
    private boolean isCompetitive;

    // AgeGroup - Ved ikke lige hvordan den skal tilkendegives

    public Member (String name, int dateOfBirth, int memberId, boolean isActive, boolean isCompetitive) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.memberId = memberId;
        this.isActive = isActive;
        this.isCompetitive = isCompetitive;
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
}
