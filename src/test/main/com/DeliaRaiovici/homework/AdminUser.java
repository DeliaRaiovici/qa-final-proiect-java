public class AdminUser extends User {
    private String permissionLevel;

    public AdminUser(String username, int age, String permissionLevel) throws InvalidUserDataException {
        super(username, age);
        if (permissionLevel == null || permissionLevel.isEmpty()) {
            throw new InvalidUserDataException("Nivelul de permisiune nu poate fi gol!");
        }
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "username='" + getUsername() + '\'' +
                ", age=" + getAge() +
                ", permissionLevel='" + permissionLevel + '\'' +
                '}';
    }
}