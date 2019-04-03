package lesson6.table2;

import java.util.Date;

public class Users {
    int ID;
    String Nick;
    String Password;
    String Email;
    Date DateCreated;
    int Karma;
    String IP;

    public Users(int ID, String nick, String password, String email, Date dateCreated, int karma, String IP) {
        this.ID = ID;
        Nick = nick;
        Password = password;
        Email = email;
        DateCreated = dateCreated;
        Karma = karma;
        this.IP = IP;
    }
}
