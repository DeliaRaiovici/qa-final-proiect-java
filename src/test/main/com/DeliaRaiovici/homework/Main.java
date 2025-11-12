public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        // 1. User valid
        try {
            User user1 = new User("testuser", 25);
            repo.addUser(user1);
            System.out.println("User adăugat: " + user1);
        } catch (InvalidUserDataException e) {
            System.err.println("Eroare la adăugare: " + e.getMessage());
        }

        // 2. AdminUser valid
        try {
            AdminUser admin = new AdminUser("admin", 30, "full_access");
            repo.addUser(admin);
            System.out.println("AdminUser adăugat: " + admin);
        } catch (InvalidUserDataException e) {
            System.err.println("Eroare la adăugare: " + e.getMessage());
        }

        // 3. User cu username prea scurt
        try {
            User badUser1 = new User("ab", 22);
            repo.addUser(badUser1);
            System.out.println("User adăugat: " + badUser1);
        } catch (InvalidUserDataException e) {
            System.err.println("Eroare la adăugare: " + e.getMessage());
        }

        // 4. User cu age negativ
        try {
            User badUser2 = new User("baduser", -5);
            repo.addUser(badUser2);
            System.out.println("User adăugat: " + badUser2);
        } catch (InvalidUserDataException e) {
            System.err.println("Eroare la adăugare: " + e.getMessage());
        }

        // 5. User duplicat
        try {
            User duplicateUser = new User("testuser", 40);
            repo.addUser(duplicateUser);
            System.out.println("User adăugat: " + duplicateUser);
        } catch (InvalidUserDataException e) {
            System.err.println("Eroare la adăugare: " + e.getMessage());
        }

        // Afișează utilizatorii validați
        System.out.println("\nUtilizatori validați în repository:");
        for (User u : repo.getUsers()) {
            System.out.println(u);
        }
    }
}
