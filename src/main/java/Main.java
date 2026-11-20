import controller.MenuController;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("data.csv");
        MenuController controller = new MenuController(fileHandler);

        MenuController.start();
    }
}
