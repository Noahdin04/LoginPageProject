public class User {
    String username;
    String password;
    String email;

    public User(String a, String b, String c){
        username = a;
        password = b;
        email = c;
    }

    public String toString(){
        return (username + ',' + password + "," + email);
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
