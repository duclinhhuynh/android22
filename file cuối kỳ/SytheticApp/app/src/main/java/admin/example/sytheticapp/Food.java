package admin.example.sytheticapp;

public class Food {
    private String name;
    private String Detail;
    private int Shape;

    public Food(String name, String detail, int shape) {
        this.name = name;
        Detail = detail;
        Shape = shape;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return Detail;
    }

    public int getShape() {
        return Shape;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public void setShape(int shape) {
        Shape = shape;
    }
}
