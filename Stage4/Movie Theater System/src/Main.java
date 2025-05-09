import io.IOTester;
import netbeans_gui.*;

public class Main {
    public static void main(String[] args) {
        // Run IO tests (for development/debug purposes)
        //IOTester.testCustomerIO();
        //IOTester.testStaffIO();
        //IOTester.testMovieIO();

        // To launch the app normally, use:
        new LoginWindow_GUI().setVisible(true);
    }
}
