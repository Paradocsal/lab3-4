import entities.*;
import items.BirchFirewood;
import items.*;
//import mapping.LightMapp;
import mapping.Prostranstvo;
//import mapping.Prostranstvo;


public class Main {
    public static void main(String[] args){
        Action act = new Action();



        Karlson karl = new Karlson(1,10,"Karl");
        Entity mal = new Entity(22,1,"Malish");
        AlarmClock alarm = new AlarmClock(2,2,false,"Kogsvort");
        Wire wire = new Wire(5,10,3,3,"Provoloka");
        Apple apple1 = new Apple(14,6,1,"apple1");
        Apple apple2 = new Apple(10,6,2,"apple2");
        Apple apple3 = new Apple(14,3,3,"apple3");
        Fireplace fireplace = new Fireplace(1,1,true,2);
        act.addlighttolist(fireplace);

        BirchFirewood birch1 = new BirchFirewood(15,11,2);
        BirchFirewood birch2 = new BirchFirewood(16,12,2);
        KerosineLamp lamp = new KerosineLamp(48,22,false,0);

        Workbench workbench = new Workbench(29,49,1,7,"Verstak"); //learn to map big objects

        Tool hammer = new Tool(2,4,"hammer","To provide strong blunt force");
        Tool scissors = new Tool( 1,5,"scissors","To cut through surfaces");
        Prostranstvo map = new Prostranstvo();

        map.addItemOnWorkbench(hammer,workbench,3);
        map.addItemOnWorkbench(scissors,workbench,5);
        map.addItemOnWorkbench(alarm,workbench,4);



        try {
            map.addOnMap(apple1);
            map.addOnMap(apple2);
            map.addOnMap(apple3);
            map.addOnMap(birch1);
            map.addOnMap(birch2);
            map.addOnMap(mal);
            map.addMultlObjOnMap(wire);
            map.addOnMap(karl);
            map.addMultlObjOnMap(workbench);
        }
        catch (NotEnoughSpaceException ex){
            System.err.println("Место уже занятой!");
        }
        catch (ArrayIndexOutOfBoundsException  e){
            System.err.println("Объект размещён за пределами карты!");
        }


        map.showMap();
//        try {
//            map.addIstSveta(fireplace, 5);
//        }
//        catch (ArrayIndexOutOfBoundsException ex){
//            System.err.println("Объект размещён за пределами карты!");
//        }
//        catch (NotEnoughSpaceException e){
//            System.err.println(e.getMessage());
//        }



        System.out.println();
//        try {
//            map.addOnWire(apple1, wire);
//            map.addOnWire(apple2, wire);
//            map.addOnWire(apple3, wire);
//        }
//        catch (ArrayIndexOutOfBoundsException ex){
//
//        }
        mal.eat(apple1);
        karl.bake(apple1);
        karl.bake(apple2);
        karl.bake(apple3);
        mal.eat(apple1);
        mal.eat(apple1);
        mal.eat(apple1);
        karl.eat(apple2);
        act.refresh_env();
        //karl.go;
        mal.talk("Как хорошо, когда трещат поленья! -- Дни стали холодными. По всему видно, что пришла осень");

        fireplace.refuel(birch1,1);
        map.deleteObj(birch1);
        map.showLightMap();
        act.refresh_env();
        fireplace.refuel(birch1);
        map.deleteObj(birch2);
        map.showLightMap();
        act.refresh_env();

        while(fireplace.isActive()){
            map.showLightMap();
            act.refresh_env();
            //fireplace.emitLight(Light_map);

        }

        lamp.activate();
        act.addlighttolist(lamp);

        map.leaveLightFrom(lamp);
        try {
            map.addIstSveta(lamp, 3);
        }
        catch (ArrayIndexOutOfBoundsException  ex){
            System.err.println("Объект размещён за пределами карты!");
        }
        catch (NotEnoughSpaceException e){
            System.err.println(e.getMessage());
        }
        act.refresh_env();
        map.showLightMap();
        mal.talk("Карлсон, не хочешь поиграть в трейдеров?");
        karl.talk("Всегда Готов!");


        karl.repair(alarm);
}

}
