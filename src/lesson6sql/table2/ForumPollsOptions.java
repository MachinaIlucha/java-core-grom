package lesson6.table2;

import java.util.Date;

public class ForumPollsOptions {
    int ID;
    ForumPosts post;
    String Title;
    Date DateCreated;

    public ForumPollsOptions(int ID, ForumPosts post, String title, Date dateCreated) {
        this.ID = ID;
        this.post = post;
        Title = title;
        DateCreated = dateCreated;
    }
}
