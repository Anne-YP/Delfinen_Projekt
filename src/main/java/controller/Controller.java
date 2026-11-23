package controller;

import domain_model.MemberAdministration;
import domain_model.QuotaAdministration;
import domain_model.TrainingAdministration;
import domain_model.UserRole;

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
            case 1 -> UserRole.FORMAND;
            case 2 -> UserRole.KASSERER;
            case 3 -> UserRole.TRÆNER;
            default -> throw new IllegalArgumentException("Ugyldigt valg");
        };

    }
}
