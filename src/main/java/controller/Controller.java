package controller;

import domain_model.MemberAdministration;
import domain_model.QuotaAdministration;
import domain_model.TrainingAdministration;
import domain_model.UserRole;
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
}
