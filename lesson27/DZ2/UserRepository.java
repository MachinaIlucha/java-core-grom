package lesson27.DZ2;

import lesson27.DZ2.exception.BadRequestExeption;
import lesson27.DZ2.exception.InternalServerExeption;
import lesson27.DZ2.exception.UserNotFoundException;

import java.util.ArrayList;

public class UserRepository<E extends IdEntity> {
    private ArrayList<E> users;

    public UserRepository(ArrayList<E> arrayList) {
        this.users = arrayList;
    }

    public ArrayList<E> getUsers() {
        return users;
    }

    public E findById(long id) throws UserNotFoundException {
        for (E t : users) {
            if (t != null && id == t.getId())
                return t;
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public E save(E e) throws Exception {
        if (e == null)
            throw new BadRequestExeption("Can't save null object");

        if (users.contains(e))
            throw new BadRequestExeption("user with id: " + e.getId() + " already in storage");

        users.add(e);
        return e;
    }

    public E update(E e) throws Exception {
        if (e == null)
            new BadRequestExeption("Can't update null user");

        if (!users.contains(e)) {
            findById(e.getId());
            int index = 0;
            for (E t : users) {
                if (t != null && t.getId() == e.getId())
                    break;
                index++;
            }

            users.set(index, e);
            return e;
        }

        throw new InternalServerExeption("Unexpected error");
    }

    public void delete(long id) throws Exception {
        E user = findById(id);
        users.remove(user);
    }
}

