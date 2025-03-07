package dao;
import java.sql.*;
import model.Subscription;
import userview.BandView;
import util.DBManager;

public class SubscribeDAO {
    public void subscribe(Subscription sb, BandView view) {
        String q = "INSERT INTO Subscription(USER_ID, PLAN_ID, START_DATE, END_DATE, STATUS) VALUES(?, ?, ?, ?, ?)";
        try (Connection con = DBManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(q)) {
            pstmt.setInt(1, sb.getUser_id());
            pstmt.setInt(2, sb.getPlan_id());
            pstmt.setString(3, sb.getStart_date());
            pstmt.setString( 4, sb.getEnd_date());
            pstmt.setString(5, sb.getStatus());
            int count = pstmt.executeUpdate();
            if(count > 1){
                view.display("Affected rows: "+count);
            }
            con.close();
        }
        catch (SQLException e) {
            view.display(e.getMessage());
        }
    }
    public Subscription getSubscriptionByUser(int uid, BandView view){
        String q = "SELECT * FROM SUBSCRIPTION WHERE USER_ID = ?";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, uid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Subscription sb = new Subscription(rs.getInt("subscription_id"), rs.getInt("user_id"), rs.getInt("Plan_id"), rs.getString("start_date"), rs.getString("end_date"), rs.getString("status"));
                return sb;
            }
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return new Subscription();
    }
}
