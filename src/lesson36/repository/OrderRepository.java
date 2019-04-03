package lesson36.repository;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.User;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderRepository extends GeneralRepository<Order> {

    public void bookRoom(long roomId, long userId) throws Exception {
        User user = UserRepository.findById(userId);
        Room room = RoomRepository.findById(roomId);

        String id = UUID.randomUUID().toString();

        Date dateTo = new Date(new Date().getTime() + (1000 * 60 * 60 * 72));

        Order order;
        if (new Date().compareTo(dateTo) == 0 || new Date().compareTo(dateTo) == 1) {
            order = new Order(Integer.parseInt(id), user, room, new Date(), dateTo, room.getPrice());
        } else throw new BadRequestExeption("Sorry but this room with id " + roomId + " already booked on this Date");

        room.setDateAvailableFrom(dateTo);

        //TODO write to Db
        GeneralDAO.saveToDb(order, "C:\\Users\\Ilucha\\Desktop\\lastTask\\OrderDb.txt");
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        for (Order order : createDb()) {
            if (order.getUser().getId() == userId && order.getRoom().getId() == roomId) {
                order.getRoom().setDateAvailableFrom(new Date());
                deleteOrder(order.getId());
                break;
            }
        }
    }

    /********************************************************************************************************************/

    private void deleteOrder(long orderId) throws Exception {
        String str = readFromFile("C:\\Users\\Ilucha\\Desktop\\lastTask\\OrderDb.txt").toString();
        if (!"".equals(str)) {
            Set<Order> orders = createDb();

            orders.remove(findById(orderId));

            clearDb();
            for (Order order : orders) {
                GeneralDAO.saveToDb(order, "C:\\Users\\Ilucha\\Desktop\\lastTask\\OrderDb.txt");
            }
        } else throw new BadRequestExeption("Sorry but no Order with id " + orderId + " in Db");
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            if ((line = br.readLine()) != null)
                res.replace(res.length() - 1, res.length(), " ");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }
        return res;
    }

    public static Order findById(long orderId) throws Exception {
        for (Order order : createDb()) {
            if (order != null && orderId == order.getId())
                return order;
        }
        throw new BadRequestExeption("Order with id: " + orderId + " not found");
    }

    private void clearDb() {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Ilucha\\Desktop\\lastTask\\OrderDb.txt")) {
            writer.print("");
        } catch (IOException e) {
            System.err.println("Can't clear Db");
        }
    }

    private static Set<Order> createDb() throws Exception {
        OrderRepository orderRepository = new OrderRepository();
        return GeneralDAO.mapping("C:\\Users\\Ilucha\\Desktop\\lastTask\\OrderDb.txt", orderRepository);
    }

    public static List findRoomByUserId(long userId) throws Exception {
        List<Room> roomsByUser = new LinkedList<>();

        for (Order order : createDb()) {
            if (order.getUser().getId() == userId)
                roomsByUser.add(order.getRoom());
        }
        return roomsByUser;
    }

    @Override
    public Order mapObject(String[] data) throws Exception {
        if (data.length > 4) {
            DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            Date dateFrom = format.parse(data[3].trim());
            Date dateTo = format.parse(data[4].trim());

            Order order = new Order(Long.parseLong(data[0]), UserRepository.findById(Long.parseLong(data[1])),
                    RoomRepository.findById(Long.parseLong(data[2])), dateFrom, dateTo, Double.parseDouble(data[5]));

            return order;
        } else throw new BadRequestExeption("Sorry but not enough data in db");
    }
}