import items.DepletableLightSource;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Action {
    public int actions(Supplier<Integer> f){
        return f.get();
    }
    //private ArrayList<Object> Changeable_vars = new ArrayList<Object>();
    private ArrayList<DepletableLightSource> Light_sources = new ArrayList<DepletableLightSource>();
    public void addLightToList(DepletableLightSource dls){
        Light_sources.add(dls);
    }
    public void refresh_env(){
        for (DepletableLightSource i : Light_sources){
            i.burn_fuel();
        }
        /*
        for (map i : MAP){
            i.do_fall();
        }
         */
    }
}
