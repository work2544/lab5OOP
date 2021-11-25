import Accessory.armo.boots;
import Accessory.armo.cloth;
import Accessory.armo.helmet;
import Accessory.weapon.Staff;
import Accessory.weapon.Sword;
import Character.Player;
import Character.job.melee.fighter;
import Character.job.melee.warrior;
import Character.job.range.archer;
import Character.job.range.necromancer;
import Character.job.job;
public class LAB05 {//forinteraction
    public static void main(String[] args) throws Exception {
        //ไอเทมบนพื้น
        Sword sw=new Sword();
        Staff sf=new Staff();
        helmet h=new helmet();
        cloth c=new cloth();
        boots b=new boots();
        //jobบนโลก
        job fighter=new fighter();
        job warrior=new warrior();
        job archer=new archer();
        job necromancer=new necromancer();
        //ผู้เล่น
        Player[] player=new Player[2];
        player[0] = new Player( "human",warrior, "Warrior", 100, 100, sw,c,b, h);
        player[1] = new Player( "human",necromancer, "Magician", 100, 100,sf, c,b, h);
        //interation
        player[1].talk(); 
        player[1].equipment();
        player[1].statuswindow();
        player[1].Unequipped(sf);
        player[1].Unequipped(sf);
        player[1].Unequipped(sf);
        player[1].Unequipped(c);
        player[1].Unequipped(b);
        player[1].Unequipped(h);
        player[1].statuswindow();
        player[1].equip(sf);
        player[1].equip(sf);
        player[1].equip(c);
        player[1].equip(b);
        player[1].equip(h);
        player[1].equip(h);
        player[1].equip(h);
        player[1].statuswindow();
        player[1].Acttack(player[0]);
        player[0].statuswindow();
        player[1].statuswindow();
        player[0].Acttack(player[1]);
        player[0].walk();
        player[0].walk();
        player[0].Acttack(player[1]);
        player[0].statuswindow();
        player[1].statuswindow();
    }
}
