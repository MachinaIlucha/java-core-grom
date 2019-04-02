package lesson27.DZ2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws Exception {
        User user = new User(3245536,"Kirill","2142352");
        User user2 = new User(6235462,"Illia","562452");
        User user3 = new User(6457647,"Oleg","25342");
        User user4 = new User(532463,"Peter","21752");

        ArrayList<User> arrayList = new ArrayList<>();

        UserRepository<User> userRepository = new UserRepository<>(arrayList);

        System.out.println(arrayList.toString());

        userRepository.save(user);

        System.out.println(arrayList.toString());

        userRepository.save(user2);

        System.out.println(arrayList.toString());

        userRepository.save(user3);

        System.out.println(arrayList.toString());

        userRepository.save(user4);

        System.out.println(arrayList.toString());

        userRepository.delete(532463);

        System.out.println(arrayList.toString());

        user2 = new User(6235462,"Illia222","562452");
        userRepository.update(user2);

        System.out.println(arrayList.toString());
    }
}
