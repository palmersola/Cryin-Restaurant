package userLogin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class User {
    private String username;
    private String passwordHash;
    private Role role;

    public User(String username, String password, Role role) {
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public boolean verifyPassword(String password) {
        String hashedPassword = hashPassword(password);
        return passwordHash.equals(hashedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

