package view;
import java.util.Scanner;
public class BandView {
    private Scanner r = new Scanner(System.in);
    public void displayMenu() {
        System.out.println("\nBand Management System!!!");
        System.out.println("1. User Registration");
        System.out.println("2. View Service Plans");
        System.out.println("3. Subscribe to a Plan");
        System.out.println("4. Manage Account");
        System.out.println("5. View Billing & Payments");
        System.out.println("6. Provide Feedback");
        System.out.println("7. View Current Subscription");
        System.out.println("7. Exit");
    }
    public int getInput(){
        System.out.print("\nEnter your choice : ");
        return r.nextInt();
    }
    public void display(String m){
        System.out.print("\n"+m);
    }
    public void display(Double m){
        System.out.print("\n"+m);
    }
    public void display(int m){
        System.out.print("\n"+m);
    }
}
