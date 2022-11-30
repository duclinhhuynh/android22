package admin.example.pheptinh_1;

public class TacGia {
    private String ten;
    private String mota;
    private int sao;
    private int hinh;
    private String quocgia;

    public TacGia(String ten, String mota, int hinh, int sao,String quocgia) {
        this.ten = ten;
        this.mota = mota;
        this.hinh = hinh;
        this.sao = sao;
        this.quocgia = quocgia;
    }
    public TacGia() {
    }

    public int getSao() {
        return sao;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public String getMota() {
        return mota;
    }

    public int getHinh() {
        return hinh;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public String getTen() {
        return ten;
    }



    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }
}
