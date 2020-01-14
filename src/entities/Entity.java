package entities;

import items.*;
import mapping.Prostranstvo;

import java.util.ArrayList;
import java.util.List;


public class Entity extends Item{
    private String name;
    private int x;
    private int y;


    public class Inventory {
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
        super(x,y,name);
    }



    public void move(int x,int y){
        this.setX(x);
        this.setY(y);
    }

    public String talk(String phrase){
        return phrase;
    }





    public void eat(Apple apple) {
        if (apple.isBaked() == true) {
            apple.decreaseSizeOfApple();

            if (apple.size < 0) {
                System.out.println(" Кумшать нечего( ");
            } else {
                System.out.println(apple.getName() + " - это вкусно !");
            }
        }
        else{
            System.out.println(apple.getName() + " нужно запечь ");
        }
    }
}


