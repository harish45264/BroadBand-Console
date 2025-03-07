package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Service_plan;
import userview.*;
import util.*;

public class PlanDAO {
    public ArrayList<Service_plan> ViewPlans(BandView v){
        String query = "SELECT * FROM service_plans";
        try(Connection con = DBManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {
            ArrayList<Service_plan> sp = new ArrayList<>();
            while(rs.next()){
                sp.add(new Service_plan(rs.getInt("PLAN_ID"), rs.getString("PLAN_NAME"), rs.getString("SPEED"), rs.getDouble("PRICE"), rs.getString("DATA_LIMIT"), rs.getInt("DURATION")));
            }
            con.close();
            return sp;
        }
        catch(Exception e){
            v.display(e.getMessage());
        }
        return new ArrayList<>();
    }
    public Service_plan getPlanById(int pid, BandView view){
        String query = "SELECT * FROM service_plans WHERE PLAN_ID = "+String.valueOf(pid);
        try(Connection con = DBManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {
            if(rs.next()){
                Service_plan sp = new Service_plan(rs.getInt("PLAN_ID"), rs.getString("plan_name"), rs.getString("speed"), rs.getDouble("price"), rs.getString("data_limit"), rs.getInt("duration"));
                return sp;
            }
            con.close();
        }
        catch(Exception e){
            view.display(e.getMessage());
        }
        return new Service_plan();
    }
}
