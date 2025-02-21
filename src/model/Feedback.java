package model;
public class Feedback {
    int user_id;
    int ratings;
    String comments;
    public Feedback(int user_id, int ratings, String comments){
        this.user_id = user_id;
        this.ratings = ratings;
        this.comments = comments;
    }
    public int getRatings() {
        return ratings;
    }
    public int getUser_id() {
        return user_id;
    }
    public String getComments() {
        return comments;
    }
    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
