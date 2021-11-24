import Accessory.armo.boots;
import Accessory.armo.cloth;
import Accessory.armo.helmet;
import Accessory.weapon.Staff;
import Accessory.weapon.Sword;
import Character.Player;

public class LAB05 {//forinteraction
    public static void main(String[] args) throws Exception {
        //ไอเทมบนพื้น
        Sword sw=new Sword();
        Staff sf=new Staff();
        helmet h=new helmet();
        cloth c=new cloth();
        boots b=new boots();
        //ผู้เล่น
        Player[] player=new Player[2];
        player[0] = new Player(sw, "human","warrior", "player1", 100, 100, c,b, h);
        player[1] = new Player(sf, "human","necromancer", "player2", 100, 100, c,b, h);
        //interation
        // player[1].talk(); 
        // player[1].statuswindow();
        // player[0].Acttack(player[1]);
        // player[0].statuswindow();
        // player[1].statuswindow();
        player[1].Unequipped(sf);
        player[1].Unequipped(sf);
        player[1].equip(sf);
        player[1].equip(sf);
        do{

        }while(false);

    }
}
