package starter.gorest.users;

public class UsersPayload {
    public String name;
    public String email;
    public String gender;
    public String status;

    public UsersPayload(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
}
