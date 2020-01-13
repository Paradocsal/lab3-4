package items;

public class Apple extends Item {
    private String condition = "Свежее";
    public Apple(int x,int y,String name){
        super(x,y,name);
    }
    private int size = 2;
    public void decreaseSizeOfApple(){
        size =- 1;
    }

    public int showAppleSize(){
        return size;
    }

    public void affectApple(String state){
        this.condition = state;
    }


}
