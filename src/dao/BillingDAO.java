package dao;

import java.sql.*;
import model.Billing;
import userview.BandView;
import util.DBManager;

public class BillingDAO {
    public void addBill(Billing bill, BandView view){
        String q = "INSERT INTO Billing(Subscription_id, user_id, amount, due_date, payment_date, payment_status) VALUES(?, ? ,?, ?, ?, ?)";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, bill.getSubscription_id());
            pstmt.setInt(2, bill.getUser_id());
            pstmt.setDouble(3, bill.getAmount());
            pstmt.setString(4, bill.getDue_date());
            pstmt.setString(5, bill.getPayment_date());
            pstmt.setString(6, bill.getPayment_status());
            pstmt.executeUpdate();
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
    }
    public Billing getBillByUser(int uid, BandView view){
        String q = "SELECT * FROM Billing WHERE user_id = ?";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1,uid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Billing bill = new Billing(rs.getInt("user_id"), rs.getInt("bill_id"), rs.getInt("subscription_id"),rs.getDouble("amount"),rs.getString("due_date"), rs.getString("payment_date"), rs.getString("payment_status"));
                return bill;
            }
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return new Billing();
    }
}
