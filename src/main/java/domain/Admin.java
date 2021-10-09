package domain;

public class Admin {
    private String adminName;
    private String adminPwd;

    public Admin(String adminName, String adminPwd) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
    }

    public Admin() {
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                '}';
    }
}
