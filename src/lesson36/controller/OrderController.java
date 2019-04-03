package lesson36.controller;

import lesson36.exception.BadRequestExeption;
import lesson36.model.Session;
import lesson36.service.OrderService;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId) throws Exception {
        if (Session.getUser() != null)
            orderService.bookRoom(roomId, userId);
        else throw new BadRequestExeption("You are not logged in");
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        if (Session.getUser() != null)
            orderService.cancelReservation(roomId, userId);
        else throw new BadRequestExeption("You are not logged in");
    }
}
