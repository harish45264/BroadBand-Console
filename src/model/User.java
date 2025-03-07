package model;
public class User{
    int user_id;
    String user_name;
    String user_email;
    String user_password;
    String number;
    String billing_address;
    String address;
    public User(){}
    public User(int user_id, String user_name, String user_email, String user_password, String number, String address,String billing_address){
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.number = number;
        this.billing_address = billing_address;
        this.address = address;
    }
    public User(String user_name, String user_email, String user_password, String number, String address,String billing_address){
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.number = number;
        this.billing_address = billing_address;
        this.address = address;
    }
    public String getUser_password(){
        return user_password;
    }
    public String getBilling_address(){
        return billing_address;
    }
    public int getUserID(){
        return user_id;
    }
    public String getEmail(){
        return user_email;
    }
    public String getUser_name(){
        return user_name;
    }

    public String getAddress() {
        return address;
    }
    public String getNumber() {
        return number;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }
    @Override
    public String toString(){
        return "\nUser Id: "+user_id+"\nUser Name: "+user_name+"\nUser Email: "+user_email+"\nPhone Number: "+number+"\nAddress: "+address;
    }
}