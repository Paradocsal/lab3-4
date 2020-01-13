import entities.*;
import items.BirchFirewood;
import items.*;
//import mapping.LightMapp;
import mapping.Prostranstvo;
//import mapping.Prostranstvo;


public class Main {
    public static void main(String[] args){
        Action act = new Action();

        Karlson karl= new Karlson(1,1,"Karl");
        Fireplace fireplace = new Fireplace(1,1,true,2);
        act.addLightToList(fireplace);

        BirchFirewood birch1 = new BirchFirewood(15,11,2);
        BirchFirewood birch2 = new BirchFirewood(16,12,2);
        KerosineLamp lamp = new KerosineLamp(48,22,false,0);

        Workbench workbench = new Workbench(35,49,1,7,"Verstak"); //learn to map big objects

        Tool hammer = new Tool(2,6,"hammer","To provide strong blunt force");
        Tool scissors = new Tool(1,6, "scissors","To cut through surfaces");

        workbench.addItem(hammer, 1);
        workbench.addItem(scissors, 2);

        Prostranstvo map = new Prostranstvo();
        map.AddOnMap(birch1);
        map.AddOnMap(birch2);
        map.AddMultlObjOnMap(workbench);
        map.AddIstSveta(fireplace,5);





        System.out.println();

        act.refresh_env();
        //karl.go;

        System.out.println("dajds");
        fireplace.refuel(birch1,1);
        map.deleteObj(birch1);
        map.ShowLightMap();
        act.refresh_env();
        fireplace.refuel(birch1);
        map.deleteObj(birch2);
        map.ShowLightMap();
        act.refresh_env();

        while(fireplace.isActive()){
            map.ShowLightMap();
            act.refresh_env();
            //fireplace.emitLight(Light_map);

        }

        lamp.activate();
        act.addLightToList(lamp);

        map.leaveLightFrom(lamp);
        map.AddIstSveta(lamp,3);
        act.refresh_env();
        map.ShowLightMap();

}

}
