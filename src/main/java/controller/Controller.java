package controller;

import domain_model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import userinterface.UserInterface;

public class Controller {
    private MemberAdministration memberAdministration;
    private QuotaAdministration quotaAdministration;
    private TrainingAdministration trainingAdministration;

    public Controller(MemberAdministration memberAdministration, QuotaAdministration quotaAdministration, TrainingAdministration trainingAdministration) {
        this.memberAdministration = memberAdministration;
        this.quotaAdministration = quotaAdministration;
        this.trainingAdministration = trainingAdministration;
    }

    public void startMenu() {
    }

    public UserRole selectUserRole(int choice) {
        return switch (choice) {
            case 1 -> UserRole.CHAIRMAN;
            case 2 -> UserRole.TREASURER;
            case 3 -> UserRole.COACH;
            default -> throw new IllegalArgumentException("Ugyldigt valg");
        };

    }

    // Add member()
    public void addMember(String name, LocalDate dateOfBirth, boolean isActive, boolean isCompetitive, ArrayList<Discipline> disciplines) {
        memberAdministration.addMember(name, dateOfBirth, isActive, isCompetitive, disciplines);
    }

    public ArrayList<Member> getMembers() {
        return memberAdministration.getMembers();
    }

    public int calculateTotalExpectedIncome() {
        return quotaAdministration.calculateTotalExpectedIncome(memberAdministration.getMembers());
    }
}
