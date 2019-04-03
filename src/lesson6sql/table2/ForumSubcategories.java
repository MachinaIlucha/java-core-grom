package lesson6.table2;

import java.util.Date;

public class ForumSubcategories {
    int ID;
    ForumCategories category;
    String Title;
    String Description;
    Date DateCreated;
    String IP;

    public ForumSubcategories(int ID, ForumCategories category, String title, String description, Date dateCreated, String IP) {
        this.ID = ID;
        this.category = category;
        Title = title;
        Description = description;
        DateCreated = dateCreated;
        this.IP = IP;
    }
}
