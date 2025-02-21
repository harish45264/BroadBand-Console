package model;
public class Billing {
    int user_id;
    int bill_id;
    int subscription_id;
    double amount;
    String due_date;
    String payment_date;
    String payment_status;

    public Billing(int user_id, int bill_id, int subscription_id, double amount, String due_date, String payment_date, String payment_status) {
        this.user_id = user_id;
        this.bill_id = bill_id;
        this.subscription_id = subscription_id;
        this.amount = amount;
        this.due_date = due_date;
        this.payment_date = payment_date;
        this.payment_status = payment_status;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }
    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }
    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public double getAmount() {
        return amount;
    }
    public int getBill_id() {
        return bill_id;
    }
    public int getSubscription_id() {
        return subscription_id;
    }
    public String getDue_date() {
        return due_date;
    }
    public String getPayment_date() {
        return payment_date;
    }
    public String getPayment_status() {
        return payment_status;
    }
}
