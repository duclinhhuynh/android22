package admin.example.pheptinh_1;

public class Luu {
    private String so1;
    private String so2;
    private String rs;

    public Luu(String so1, String so2, String rs) {
        this.so1 = so1;
        this.so2 = so2;
        this.rs = rs;
    }
    public Luu(String s1) {
    }

    public String getSo1() {
        return so1;
    }

    public String getSo2() {
        return so2;
    }

    public String getRs() {
        return rs;
    }

    public void setSo1(String so1) {
        this.so1 = so1;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }
}
