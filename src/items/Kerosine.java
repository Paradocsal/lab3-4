package items;

public class Kerosine extends Item {
    private int size;
    private static final String NAME = "Firewood";
    private static int burniness = 40;
    public Kerosine(int x, int y, int size){
        super(x,y, NAME);
        this.size = size;
    };
    public int getBurntime() {
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }
}
