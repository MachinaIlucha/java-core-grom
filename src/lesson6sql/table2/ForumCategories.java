package lesson6.table2;

import java.util.Date;

public class ForumCategories {
    int ID;
    String Title;
    String Description;
    Date DateCreated;
    String IP;

    public ForumCategories(int ID, String title, String description, Date dateCreated, String IP) {
        this.ID = ID;
        Title = title;
        Description = description;
        DateCreated = dateCreated;
        this.IP = IP;
    }
}
