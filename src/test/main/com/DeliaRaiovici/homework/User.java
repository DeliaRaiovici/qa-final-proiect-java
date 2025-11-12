public class User {
    private String username;
    private int age;

    public User(String username, int age) throws InvalidUserDataException {
        if (username == null || username.isEmpty()) {
            throw new InvalidUserDataException("Username nu poate fi gol!");
        }
        if (age < 0) {
            throw new InvalidUserDataException("Vârsta nu poate fi negativă!");
        }
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}