package school21.spring.service.models;

public class User {
    private Long identifier;
    private String Email;

    public User() {
    }

    public User(Long identifier, String email) {
        identifier = identifier;
        Email = email;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        identifier = identifier;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Identifier=" + identifier +
                ", Email='" + Email + '\'' +
                '}';
    }
}
