package lesson6.table2;

import java.util.Date;

public class ForumPosts {
    int ID;
    ForumSubcategories Subcategory;
    Users user;
    int ParentPost;
    String Title;
    String Content;
    boolean IsPoll;
    Date DateCreated;
    String IP;

    public ForumPosts(int ID, ForumSubcategories subcategory, Users user, int parentPost, String title, String content, boolean isPoll, Date dateCreated, String IP) {
        this.ID = ID;
        Subcategory = subcategory;
        this.user = user;
        ParentPost = parentPost;
        Title = title;
        Content = content;
        IsPoll = isPoll;
        DateCreated = dateCreated;
        this.IP = IP;
    }
}
