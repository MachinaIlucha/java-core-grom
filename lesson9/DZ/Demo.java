package lesson9.DZ;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User(214124, "Vova", "2");
        User user2 = new User(214145, "Vika", "1");
        User user3 = new User(214235, "Poli", "3");
        User user4 = new User(21434932, "Poret", "6");
        User[] users = {user1,user2,null,user4};
        UserRepository userRepository = new UserRepository(users);

        System.out.println(userRepository.getUserByName("Vika"));
    }
}
