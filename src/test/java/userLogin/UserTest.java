package userLogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private LoginSystem loginSystem;

    @BeforeEach
    public void setup() {
        loginSystem = new LoginSystem();
    }

    @Test
    public void testLogin_ValidCredentials_StaffUser() {
        User staffUser = loginSystem.login("Ong", "ongpw");
        assertNotNull(staffUser);
        assertEquals(Role.STAFF, staffUser.getRole());
    }

    @Test
    public void testLogin_ValidCredentials_ManagerUser() {
        User managerUser = loginSystem.login("Alexander", "managerpw");
        assertNotNull(managerUser);
        assertEquals(Role.MANAGER, managerUser.getRole());
    }

    @Test
    public void testLogin_InvalidUsername() {
        User user = loginSystem.login("InvalidUsername", "password");
        assertNull(user);
    }

    @Test
    public void testLogin_InvalidPassword() {
        User user = loginSystem.login("Ong", "invalidPassword");
        assertNull(user);
    }

    @Test
    public void testVerifyPassword_ValidPassword() {
        User user = new User("username", "password", Role.STAFF);
        assertTrue(user.verifyPassword("password"));
    }

    @Test
    public void testVerifyPassword_InvalidPassword() {
        User user = new User("username", "password", Role.STAFF);
        assertFalse(user.verifyPassword("invalidPassword"));
    }

    @Test
    public void testGetUsername() {
        User user = new User("username", "password", Role.STAFF);
        assertEquals("username", user.getUsername());
    }

    @Test
    public void testGetPasswordHash() {
        User user = new User("username", "password", Role.STAFF);
        assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", user.getPasswordHash());
    }

    @Test
    public void testGetRole() {
        User user = new User("username", "password", Role.STAFF);
        assertEquals(Role.STAFF, user.getRole());
    }
}
