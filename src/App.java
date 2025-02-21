import controller.*;
import view.*;

public class App {
    public static void main(String[] args) throws Exception {
        BandView view = new BandView();
        BandControl controller = new BandControl(view);
        controller.addplans();
        controller.start();
    }
}
