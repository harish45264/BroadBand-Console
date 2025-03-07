package dao;
import java.sql.*;
import model.User;
import userview.BandView;
import util.DBManager;
public class UserDAO {
    public UserDAO(){}
    public void addUser(User tmp, BandView view){
        // Add user to database
        String sql = "INSERT INTO users(user_name, user_email, user_password, phone_number, address) VALUES(?, ?, ?, ?, ?)";
        try(Connection con = DBManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) 
        {
            pstmt.setString(1, tmp.getUser_name());
            pstmt.setString(2, tmp.getEmail());
            pstmt.setString(3, tmp.getUser_password());
            pstmt.setString(4, tmp.getNumber());
            pstmt.setString(5, tmp.getAddress());
            pstmt.executeUpdate();
            con.close();
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
    }
    public int getUserIdByName(String name, BandView view){
        String q = "SELECT user_id FROM users WHERE user_name = ?";
        try(Connection con = DBManager.getConnection()){
        PreparedStatement pstmt = con.prepareStatement(q);
        pstmt.setString(1, name);   
        ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("user_id");
            }
            con.close();
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return 0;
    }
    public User getUserById(int id, BandView view){
        String q = "SELECT * FROM USERS WHERE USER_ID = ?";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            if(res.next()){
                User user = new User(res.getInt("user_id"),res.getString("user_name"),res.getString("user_email"),res.getString("user_password"),res.getString("phone_number"),res.getString("address"),res.getString("billing_address"));
                return user;
            }
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return new User();
    }
    public boolean checkUser(String email, String password, BandView view){
        String q = "SELECT * FROM users WHERE user_email = ?";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,email);
            ResultSet res = pstmt.executeQuery();
            if(res.next()){
                if(res.getString("user_password").equals(password)){
                    return true;
                }
            }
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return false;
    }
    public boolean checkUserInDb(String email, BandView view){
        String q = "SELECT user_email FROM Users";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            ResultSet res = pstmt.executeQuery();
            if(res.next()){
                return true;
            }
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return false;
    }
    public boolean checkUserName(String name, BandView view){
        String q = "SELECT user_name FROM Users WHERE user_name = ?";
        try(Connection con = DBManager.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,name);
            ResultSet res = pstmt.executeQuery();
            if(res.next()){
                return false;
            }
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return true;
    }
}
