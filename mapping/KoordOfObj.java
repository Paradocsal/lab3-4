package mapping;

public abstract class KoordOfObj {
    private int x;
    private int y;
    private String name;

    public KoordOfObj(int x, int y,String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public KoordOfObj(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private int x1;
    private int y1;
    private int y2;
    private int x2;

    public KoordOfObj(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public KoordOfObj(int x1, int x2,int y1, int y2,String name) {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.name=name;
    }
    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}

    //public void setXYmultiplied(int x1, int x2, int y1, int y2, int numOfPoints){ }
