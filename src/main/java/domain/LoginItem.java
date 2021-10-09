package domain;

public class LoginItem {
    private String username;
    private String realname;
    private int age;
    private String address;
    private String hobby;

    public LoginItem() {
    }

    public LoginItem(String username, String realname, int age, String address, String hobby) {
        this.username = username;
        this.realname = realname;
        this.age = age;
        this.address = address;
        this.hobby = hobby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "LoginItem{" +
                "username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
