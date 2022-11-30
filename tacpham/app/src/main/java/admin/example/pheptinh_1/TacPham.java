package admin.example.pheptinh_1;

public class TacPham {
    private String ten;
    private String mota;
    private int sao;
    private int hinh;

    public TacPham(String ten, String mota, int sao, int hinh) {
        this.ten = ten;
        this.mota = mota;
        this.sao = sao;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public int getSao() {
        return sao;
    }

    public int getHinh() {
        return hinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
