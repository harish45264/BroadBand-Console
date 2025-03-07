package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Feedback;
import userview.BandView;
import util.DBManager;

public class FeedbackDAO {
    public void addFeedBack(Feedback fb, BandView view){
        // Add feedback to database
        String q = "INSERT INTO feedback(User_id, Ratings, Comments) VALUES(?, ?, ?)";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, fb.getUser_id());
            pstmt.setDouble(2, fb.getRatings());
            pstmt.setString(3, fb.getComments());
            pstmt.executeUpdate();
            con.close();
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
    }
    public String getCommentsByUser(int uid, BandView view){
        String q = "SELECT Comments FROM Feedback WHERE User_id = ?";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, uid);
            ResultSet res = pstmt.executeQuery();
            if(res.next()){
                return res.getString("Comments");
            }
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return "No Comments";
    }
    public ArrayList<Feedback> viewFeedBacks(BandView view){
        String q = "SELECT * FROM Feedback";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            ResultSet res = pstmt.executeQuery();
            ArrayList<Feedback> list = new ArrayList<>();
            while(res.next()){
                list.add(new Feedback(res.getInt("user_id"), res.getDouble("ratings"), res.getString("comments")));
            }
            return list;
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return new ArrayList<>();
    }
}
