package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();


        User user1 = new User(1001,"Daniil","321315fsfwqeg");
        userRepository.save(user1);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user2 = new User(1002,"Andrey","tertert43512");
        userRepository.save(user2);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user3 = new User(1001,"Test","321315fsfwqeg");
        userRepository.update(user3);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository = new UserRepository();

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

    }
}
