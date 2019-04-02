package lesson13;

public class UserRepository {
    private User[] users;

    public String[] getUserNames() {
        int p = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null)
                p++;
        }
        String[] names = new String[users.length - p];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                names[i] = users[i].getName();
        }
        return names;
    }

    public long[] getUserIds() {
        int p = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null)
                p++;
        }
        long[] Ids = new long[users.length - p];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                Ids[i] = users[i].getId();
        }
        return Ids;
    }

    public String getUserNameById(long id) {
        String foundedName = "";
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() != 0 && users[i].getId() == id) {
                foundedName = users[i].getName();
                return foundedName;
            }
        }
        return null;
    }

    public User[] getUsers() {
        return users;
    }

    public User getUserByName(String name) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getName() == name && users[i].getName() != null) {
                return users[i];
            }
        }
        return null;
    }

    public User findById(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id && users[i].getId() != 0) {
                return users[i];
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getSessionId() == sessionId && users[i].getSessionId() != null) {
                return users[i];
            }
        }
        return null;
    }

    public User save(User user) {
        if (findById(user.getId()) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User update(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == user.getId() && users[i].getId() != 0) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id && users[i].getId() != 0) {
                users[i] = null;
            }
        }
    }
}
