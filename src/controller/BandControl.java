package controller;
import java.time.LocalDate;
import java.util.*;
import model.*;
import view.BandView;

public class BandControl {
    protected  BandView view;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Service_plan> plans = new ArrayList<>();
    private ArrayList<Billing> bills = new ArrayList<>();
    private ArrayList<Feedback> feedbacks = new ArrayList<>();
    private ArrayList<Subscription> subscriptions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public BandControl(BandView view){
        this.view = view;
    }
    static int ucount = 0, scount = 0, bcount = 0;
    public void start(){
        while(true){
            view.displayMenu();
            int ch = view.getInput();
            switch(ch){
                case 1:
                    register();
                    break;
                case 2:
                    viewplans();
                    break;
                case 3:
                    subscribe();
                    break;
                case 4:
                    viewacc();
                    break;
                case 5:
                    viewpayments();
                    break;
                case 6:
                    addfeedback();
                    break;
                case 7:
                    viewsubscription();
                    break;
                case 8:
                    System.out.println("Exiting....!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
        public void register(){
            view.display("Enter user name: ");
            String name = sc.nextLine();
            view.display("Enter user email: ");
            String email = sc.nextLine();
            view.display("Enter user password: ");
            String password = sc.nextLine();
            view.display("Enter mobile number: ");
            String number = sc.nextLine();
            view.display("Enter address: ");
            String address = sc.nextLine();
            view.display("Billing address: ");
            String billing = sc.nextLine();
            users.add(new User(++ucount, name, email, password, number, address, billing));
            view.display("User registered successfully!");
         }
         private void viewplans(){
            if(plans.size() == 0){
                view.display("No plans available!");
            }
            else{
                for(Service_plan i : plans){
                    view.display("Plan ID: "+i.getPlan_id());
                    view.display("Plan name: "+i.getPlan_name());
                    view.display("Price: "+i.getPrice());
                    view.display("Speed: "+i.getSpeed());
                    view.display("Data Limit: "+i.getData_limit());
                    view.display("Duration(Months): "+i.getDuration());
                }
            }
         }
         private void subscribe(){
            view.display("Enter UserId: ");
            int id = sc.nextInt();
            view.display("Select PlanId: ");
            int pid = sc.nextInt();
            for(Service_plan i : plans){
                if(i.getPlan_id() == pid){
                    Subscription s = new Subscription(++scount, id, pid, LocalDate.now().toString(), LocalDate.now().plusMonths(i.getDuration()).toString(), "Active");
                    Billing b = new Billing(id, ++bcount, scount, i.getPrice(),null, LocalDate.now().toString(), "Paid");
                    bills.add(b);
                    subscriptions.add(s);
                    break;
                }
            }
         }
         private void viewacc(){
            view.display("Enter UserId: ");
            int uid = sc.nextInt();
            for(User i : users){
                if(i.getUserID() == uid){
                    view.display("User ID: "+i.getUser_name());
                    view.display("User Email: "+i.getEmail());
                    view.display("User Phone Number: "+i.getNumber());
                    view.display("User Address: "+i.getAddress());
                }
            }
         }
         private void viewpayments(){
            view.display("Enter User Id: ");
            for(Billing i : bills){
                if(i.getUser_id() == sc.nextInt()){
                    view.display("User Bill Id: "+i.getBill_id());
                    view.display("User Id: "+i.getUser_id());
                    view.display("Subscription ID: "+i.getSubscription_id());
                    view.display("Due Amount: "+i.getAmount());
                    view.display("Due Date: "+i.getDue_date());
                    view.display("Payment Date: "+i.getPayment_date());
                    view.display("Current Status: "+i.getPayment_status());
                }
                break;
            }
         }
         private void addfeedback(){
            view.display("Enter User Id: ");
            int uid = sc.nextInt();
            view.display("Enter Feedback: ");
            String t = sc.nextLine();
            view.display("Enter ratings: ");
            int rate = sc.nextInt();
            Feedback f = new Feedback(uid, rate, t);
            feedbacks.add(f);
         }
         public void addplans(){
            plans.add(new Service_plan(1, "Basic", "50 MB/s", 599.0, "100GB", 3));
            plans.add(new Service_plan(2, "Standard", "100 MB/s", 899.0, "300GB", 6));
            plans.add(new Service_plan(3, "Premium", "140 MB/s", 1399.0, "600GB", 4));
         }
         public void viewsubscription(){
            view.display("Enter User Id: ");
            int uid = sc.nextInt();
            for(Subscription i : subscriptions){
                if(i.getUser_id() == uid){
                    view.display("Subscription ID: "+i.getSubscription_id());
                    view.display("Plan ID: "+i.getPlan_id());
                    view.display("Subscription Status: "+i.getStatus());
                    view.display("Subscription Start Date: "+i.getStart_date());
                    view.display("Subscription End Date: "+i.getEnd_date());
                    break;
                }
            }
         }
}
