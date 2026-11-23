import domain_model.MemberAdministration;
import controller.Controller;
import domain_model.QuotaAdministration;
import domain_model.TrainingAdministration;
import userinterface.UserInterface;

public class Main {
    public static void main(String[] args) {
        MemberAdministration memberAdministration = new MemberAdministration();
        QuotaAdministration quotaAdministration = new QuotaAdministration();
        TrainingAdministration trainingAdministration = new TrainingAdministration();

        Controller controller = new Controller(memberAdministration, quotaAdministration, trainingAdministration);

        UserInterface ui = new UserInterface(controller);

        // Viser menuen i UserInterface
        ui.showStartMenu();
    }
}
