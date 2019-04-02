package lesson36.repository;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Room;
import lesson36.model.Session;
import lesson36.model.User;
import lesson36.model.UserType;

import java.util.*;

public class UserRepository extends GeneralRepository<User> {
    //считывание данный - считывание файла
    //обработка данных - маппинг данных
    public User registerUser(User user) throws Exception {
        //generate id
        String id = UUID.randomUUID().toString();
        user.setId(Integer.parseInt(id));
        //save user to db(file)
        for (User user1 : createDb()) {
            if (user1.getUserName() == user.getUserName())
                throw new BadRequestExeption("You are already registered");
        }

        GeneralDAO.saveToDb(user, "C:\\Users\\Ilucha\\Desktop\\lastTask\\UserDb.txt");
        return user;
    }

    public void login(String userName, String password) throws Exception {
        createDb();

        for (User user : createDb()) {
            if (user.getUserName() == userName && user.getPassword() == password) {
                Session.setUser(user);
                System.out.println("You are logged in");
                break;
            } else throw new BadRequestExeption("Incorrect username or password");
        }
    }

    public void logout() {
        Session.setUser(null);
    }


    /*****************************************************************************************************************/


    private static Set<User> createDb() throws Exception {
        UserRepository userRepository = new UserRepository();
        return GeneralDAO.mapping("C:\\Users\\Ilucha\\Desktop\\lastTask\\UserDb.txt", userRepository);
    }

    public static User findById(long userId) throws Exception {
        for (User user : createDb()) {
            if (user != null && userId == user.getId())
                return user;
        }
        throw new BadRequestExeption("User with id: " + userId + " not found");
    }

    @Override
    public User mapObject(String[] data) throws Exception {
        if (data.length > 4) {
            List<Room> roomsByUser = OrderRepository.findRoomByUserId(Long.parseLong(data[4]));
            User user = new User(Long.parseLong(data[0].trim()), data[1], data[2], data[3], roomsByUser, UserType.valueOf(data[5]));
            return user;
        } else throw new BadRequestExeption("Sorry but not enough data in db");
    }
}
