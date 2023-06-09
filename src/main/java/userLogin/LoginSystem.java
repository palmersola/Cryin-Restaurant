package userLogin;

import java.util.HashMap;
import java.util.Map;

public class LoginSystem {

    private Map<String, User> users;

    public LoginSystem() {
        users = new HashMap<>();


        User staffUser1 = new User("Ong", "ongpw", Role.STAFF);
        users.put(staffUser1.getUsername(), staffUser1);

        User staffUser2 = new User("Leyla", "leylapw", Role.STAFF);
        users.put(staffUser2.getUsername(), staffUser2);

        User staffUser3 = new User("Palmer", "palmerpw", Role.MANAGER);
        users.put(staffUser3.getUsername(), staffUser3);

        User staffUser4 = new User("Shatt", "shattpw", Role.STAFF);
        users.put(staffUser4.getUsername(), staffUser4);

        User managerUser = new User("Alexander", "managerpw", Role.MANAGER);
        users.put(managerUser.getUsername(), managerUser);
    }

    public User login(String username, String password) {
        User user = users.get(username);

        if (user != null && user.verifyPassword(password)) {
            return user;
        }

        return null;
    }
}