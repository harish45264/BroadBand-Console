package model;
public class Subscription {
    int subscription_id;
    int user_id;
    int plan_id;
    String start_date;
    String end_date;
    String status;
    public Subscription(int subscription_id, int user_id, int plan_id, String start_date, String end_date, String status){
        this.subscription_id = subscription_id;
        this.user_id = user_id;
        this.plan_id = plan_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
    }
    public int getSubscription_id() {
        return subscription_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public int getPlan_id() {
        return plan_id;
    }
    public String getEnd_date() {
        return end_date;
    }
    public String getStart_date() {
        return start_date;
    }
    public String getStatus() {
        return status;
    }
    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
