package lesson36.service;

import lesson36.exception.BadRequestExeption;
import lesson36.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public void bookRoom(long roomId, long userId) throws Exception {
        orderRepository.bookRoom(roomId, userId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        orderRepository.cancelReservation(roomId, userId);
    }
}
