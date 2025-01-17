public class Authentication {
    private User user;

    public Authentication(User user) {
        this.user = user;
    }

    // Authenticate user by username and password
    public boolean authenticate(String username, String password) {
        // Null check for user
        if (user == null) {
            return false;
        }

        // Check if the username and password match
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }
}
