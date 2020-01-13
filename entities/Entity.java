package entities;

import items.*;

import java.util.ArrayList;
import java.util.List;


public class Entity {
    private String name;
    private int x;
    private int y;


    public class Inventory{
        private List<Item> Inventory = new ArrayList<Item>();// координаты менять

        public Inventory(Item item){
            this.Inventory.add(item);
        }

        public void addItem(Item item){
            Inventory.add(item);
        }
        public void removeItem(Item item){
//exception if no item
            Inventory.remove(item);
        }
        public void trade(Entity.Inventory traderInv, Item item){
            traderInv.addItem(item);
        }

    }


    public Entity(int x, int y,String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void move(int x,int y){
        this.setX(x);
        this.setY(y);
    }

    public String talk(String phrase){
        return phrase;
    }

    public void eat(Apple item){
        System.out.println(item.getName() + "- это вкусно !");
    }

}


