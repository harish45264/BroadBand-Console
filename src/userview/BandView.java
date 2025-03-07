package userview;
import java.util.Scanner;
public class BandView {
    private Scanner r = new Scanner(System.in);
    public void displayMenu() {
        System.out.println("\nBand Management System!!!");
        System.out.println("1. User Register");
        System.out.println("2. User Login");
        System.out.println("3. View Service Plans");
        System.out.println("4. View Feedbacks and Ratings");
        System.out.println("5. Exit");
    }
    public void displayMenuWithUser() {
        System.out.println("\nBand Management System!!!");
        System.out.println("1. View Service Plans");
        System.out.println("2. Subscribe to a Plan");
        System.out.println("3. View Account");
        System.out.println("4. View Billing & Payments");
        System.out.println("5. Provide Feedback");
        System.out.println("6. View Current Subscription");
        System.out.println("7. View Feedbacks and Ratings");
        System.out.println("8. Log Out");
        System.out.println("9. Exit");
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
