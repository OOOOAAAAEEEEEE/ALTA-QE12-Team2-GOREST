package starter.gorest.users;

public class UserPayload {
    public String name;
    public String email;
    public String gender;
    public String status;

    public UserPayload(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
}
