package controller;
import dao.*;
import java.time.LocalDate;
import java.util.*;
import model.*;
import userview.BandView;

public class BandControl {
    protected  BandView view;
    final private UserDAO userdb = new UserDAO();
    final private PlanDAO plandb = new PlanDAO();
    final private BillingDAO billdb = new BillingDAO();
    final private SubscribeDAO sub = new SubscribeDAO();
    final private FeedbackDAO feedback = new FeedbackDAO();
    final private Scanner sc = new Scanner(System.in);

    public BandControl(BandView view){
        this.view = view;
    }
    static int currentUserId = -1;
    public void start(){
        while(true){
            view.display("-------------------------");
            view.displayMenu();
            int ch = view.getInput();
            switch(ch){
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    viewplans();
                    break;
                case 4:
                    viewfeedbacks();
                    break;
                case 5:
                    view.display("Exiting....!");
                    return;
                default:
                    view.display("Enter Valid Option: ");
                    break;
            }
        }
    }
    public void startWithUser(){
        while(true){
            view.display("-------------------------");
            view.displayMenuWithUser();
            int ch = view.getInput();
            switch(ch){
                case 1:
                    viewplans();
                    break;
                case 2:
                    subscribePlan();
                    break;
                case 3:
                    viewacc();
                    break;
                case 4:
                    viewBill();
                    break;
                case 5:
                    addfeedback();
                    break;
                case 6:
                    viewsubscription();
                    break;
                case 7:
                    viewfeedbacks();
                    break;
                case 8:
                    return;
                case 9:
                    view.display("Exiting....!");
                    view.display("-------------------------");
                    return;
                default:
                    view.display("Enter Valid Option: ");
                    break;
            }
        }
    }
        public void register(){
            view.display("-------------------------");
            view.display("Enter user name: ");
            String name = sc.nextLine();
            if(userdb.checkUserName(name, view))
            {
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
                User tmp = new User(name, email, password, number, address, billing);
                userdb.addUser(tmp, view);
                view.display("User registered successfully!");
                currentUserId = userdb.getUserIdByName(name, view);
                startWithUser();
            }
            else{
                view.display("User name already exists!");
                register();
            }
         }
         private void login(){
            view.display("-------------------------");
            view.display("Enter user name: ");
            String name = sc.nextLine();
            view.display("Enter user email: ");
            String email = sc.nextLine();
            view.display("Enter user password: ");
            String password = sc.nextLine();
            if(userdb.checkUserInDb(email, view)){
                if(userdb.checkUser(email, password, view)){
                    view.display("Login successful!");
                    currentUserId = userdb.getUserIdByName(name, view);
                    startWithUser();
                }
                else{
                    view.display("Invalid email or password!");
                    login();
                }
            }
            else{
                view.display("No Such User Found Login Again!");
                register();
            }
         }
         private void viewplans(){
            view.display("Available plans: ");
            view.display("#######################");
            ArrayList<Service_plan> plans = plandb.ViewPlans(view);
            for(Service_plan p : plans){
                view.display("--------------------------");
                view.display(p.toString());
            }
         }
         private void subscribePlan(){
            view.display("-------------------------");
            plandb.ViewPlans(view);
            view.display("Enter plan id: ");
            int pid = sc.nextInt();
            Service_plan plan = plandb.getPlanById(pid, view);
            LocalDate today = LocalDate.now();
            Subscription sb = new Subscription(currentUserId, pid, today.toString(), today.plusMonths(plan.getDuration()).toString(), "Active");
            sub.subscribe(sb, view);
            view.display("Plan subscribed successfully!");
            Subscription subs = sub.getSubscriptionByUser(currentUserId, view);
            Billing bill = new Billing(currentUserId, subs.getSubscription_id(),plan.getPrice(), today.plusMonths(1).toString(), today.toString(), "Paid");
            billdb.addBill(bill, view);
         }
         private void viewacc(){
            view.display("-------------------------");
            User user = userdb.getUserById(currentUserId, view);
            view.display(user.toString());
         }
         private void viewBill(){
            Billing bill = billdb.getBillByUser(currentUserId, view);
            view.display(bill.toString());
         }
         private void addfeedback(){
            view.display("-------------------------");
            view.display("Comments : ");
            String t = sc.nextLine();
            view.display("Enter ratings(1 to 5) : ");
            int rate = sc.nextInt();
            Feedback fb = new Feedback(currentUserId, rate, t);
            feedback.addFeedBack(fb, view);
         }
         public void viewsubscription(){
            view.display("-------------------------");
            Subscription sb = sub.getSubscriptionByUser(currentUserId, view);
            view.display(sb.toString());
         }
         public void viewfeedbacks(){
            ArrayList<Feedback> fbs = feedback.viewFeedBacks(view);
            for(Feedback f : fbs){
                view.display("-------------------------");
                view.display(f.toString());
            }
         }
}
