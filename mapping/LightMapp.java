package mapping;

import items.Item;

public class LightMapp extends Prostranstvo {
    private Item[][] myLightMap;
    private Enum[][] enumMap;
    private int sizeX;
    private int sizeY;
    private LightLevel[][] svetMap;
    public LightMapp(){
        super(50,50);

        this.myLightMap = new Item[sizeX][sizeY];
        this.enumMap = new Enum[sizeX][sizeY];
        this.svetMap = new LightLevel[sizeX][sizeY];

    }
    public void AddIstSveta(Item obj, int svetimost){
        for (int i = 0; i <= sizeY - 1; i++) {
            for (int j = 0; j <= sizeX - 1; j++) {

                if (i==obj.getY() && j ==obj.getX()){
                    this.svetMap[i][j] = LightLevel.Daleko;
                }else {
                    if ((Math.abs(-obj.getX() + j)+Math.abs(-obj.getY() + i)) < 3) { // distance from light source to point
                        this.svetMap[i][j] = LightLevel.OchBlizko; //light intensity
                    } else if ((Math.abs(-obj.getX() + j)+Math.abs(-obj.getY() + i)) < 2 * svetimost && this.svetMap[i][j] != LightLevel.OchBlizko) {
                        this.svetMap[i][j] = LightLevel.Blizko;
                    } else if ((Math.abs(-obj.getX() + j)+Math.abs(-obj.getY() + i)) < 4 * svetimost && this.svetMap[i][j] != LightLevel.OchBlizko & this.svetMap[i][j] != LightLevel.Blizko) {
                        this.svetMap[i][j] = LightLevel.NetakNeedak;
                    } else if ((Math.abs(-obj.getX() + j)+Math.abs(-obj.getY() + i)) < 6 * svetimost && this.svetMap[i][j] != LightLevel.OchBlizko & this.svetMap[i][j] != LightLevel.Blizko & this.svetMap[i][j] != LightLevel.NetakNeedak) {
                        this.svetMap[i][j] = LightLevel.Daleko;
                    } else if ((Math.abs(-obj.getX() + j)+Math.abs(-obj.getY() + i)) < 500           && this.svetMap[i][j] != LightLevel.OchBlizko & this.svetMap[i][j] != LightLevel.Blizko & this.svetMap[i][j] != LightLevel.NetakNeedak & this.svetMap[i][j] != LightLevel.Daleko) {
                        this.svetMap[i][j] = LightLevel.OchenDaleko;
                    }
                }
            }

        }
        System.out.println(obj.getName() + " Добавлен на карту света");
        showLightMap();

    }
//    @Override
//    public void AddOnMap{
//
//    }
    public LightLevel getSvetimostInCoord(int x,int y){
        return this.svetMap[x][y];
    }
    public void showLightMap(){
        String s = "";
        for (int i = this.sizeY-1; i >= 0; i--) {
            for (int j = 0; j < this.sizeX; j++) {
                String p = " ";
                LightLevel sv = this.getSvetimostInCoord(j, i);
                Enum en = this.getEnumInCoord(j, i);
                Object obj = this.getObjInCoord(j,i);
                if (obj != null) {
                    p = " " + obj.getClass().getSimpleName().toCharArray()[0]+" ";
                } else {
                    switch (en) {
                        case Wall:
                            p = "|";
                            break;
                        case Surface:
                            p = "‾‾‾";
                            break;
                        case Air:
                            switch (sv) {
                                case OchBlizko:
                                    p = " * ";
                                    break;
                                case Blizko:
                                    p = " & ";
                                    break;
                                case NetakNeedak:
                                    p = " @ ";
                                    break;
                                case Daleko:
                                    p = " . ";
                                    break;
                                case OchenDaleko:
                                    p = " / ";
                                    break;
                            };
                            break;
                    }

                }
                s += p;
            }
            s += "\n";
        }
        System.out.println(s);
    }




}

