package model;
public class Service_plan {
    int plan_id;
    String plan_name;
    String speed;
    Double price;
    String data_limit;
    int duration;
    public Service_plan(int plan_id, String plan_name, String speed, Double price, String data_limit, int duration){
        this.plan_id = plan_id;
        this.plan_name = plan_name;
        this.speed = speed;
        this.price = price;
        this.data_limit = data_limit;
        this.duration = duration;
    }
    public int getPlan_id(){
        return plan_id;
    }
    public String getPlan_name() {
        return plan_name;
    }
    public Double getPrice() {
        return price;
    }
    public String getData_limit() {
        return data_limit;
    }
    public int getDuration() {
        return duration;
    }
    public String getSpeed() {
        return speed;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setData_limit(String data_limit) {
        this.data_limit = data_limit;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
