package lesson6.table2;

import java.util.Date;

public class ForumPollsOptionsVotes {
    int ID;
    ForumPollsOptions pollsOption;
    Users user;
    Date DateCreated;
    String IP;

    public ForumPollsOptionsVotes(int ID, ForumPollsOptions pollsOption, Users user, Date dateCreated, String IP) {
        this.ID = ID;
        this.pollsOption = pollsOption;
        this.user = user;
        DateCreated = dateCreated;
        this.IP = IP;
    }
}
