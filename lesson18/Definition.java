package lesson18;

public class Definition {
    private void notification(String[] usersEmails) {
        for (String email : usersEmails) {

            //обработка ошибки
            try {
                //send email to user - error
                System.out.println("Email " + email + " was sent");
            } catch (Exception e) {
                System.err.println("Email " + email + " was not sent");
                //how should I handle exception
            } finally {
                //updateStatus
            }


        }
    }
}
