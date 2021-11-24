package Character;

import Accessory.AccessoriesInterface;
import Accessory.armo.ArmoInterface;

import Accessory.weapon.WeaponInterface;
import Character.melee.fighter;
import Character.melee.warrior;
import Character.range.archer;
import Character.range.necromancer;
import Accessory.empty;
public class Player implements CharacterInterface {
    private int atk;
    private int def;
    private String race;
    private String name;
    private String job;
    private int hp;
    private int mana;
    private String skill;
    private int rayaatk;
    AccessoriesInterface[] equipment = new AccessoriesInterface[4];

    // Sword sw;
    // Staff sf;
    // Bow b;
    // helmet h;
    // cloth c;
    // boots bt;
    public Player(WeaponInterface weapon, String race, String job, String name, int hp, int mana, ArmoInterface cloth,
            ArmoInterface boots, ArmoInterface helmet) {
        this.race = race;
        this.name = name;
        this.job = job;
        this.hp = hp;
        this.mana = mana;
        if (job == "warrior") {
            this.skill = warrior.skill;
            this.rayaatk = warrior.rayaatk;

            equipment[0] = weapon;
        } else if (job == "fighter") {
            this.skill = fighter.skill;
            this.rayaatk = fighter.rayaatk;
            this.hp += 100;
            this.atk += 100;
        } else if (job == "archer") {
            this.skill = archer.skill;
            this.rayaatk = archer.rayaatk;

            equipment[0] = weapon;
        } else if (job == "necromancer") {
            this.skill = necromancer.skill;
            this.rayaatk = necromancer.rayaatk;

            equipment[0] = weapon;
        }

        equipment[1] = helmet;
        equipment[2] = cloth;
        equipment[3] = boots;
        this.atk += equipment[0].damage();
        for (int i = 1; i < 4; i++) {
            this.def += equipment[i].defense();
        }
    }

    @Override
    public String race() {

        return race;
    }

    @Override
    public String name() {

        return name;
    }

    @Override
    public int mana() {

        return mana;
    }

    @Override
    public int hp() {

        return hp;
    }

    @Override
    public void walk() {

    }

    @Override
    public void equipment() {

       for (AccessoriesInterface accessoriesInterface : equipment) {
           System.out.print(accessoriesInterface.getClass().getSimpleName()+" ");
       }
       System.out.println();

    }

    @Override
    public void equip(AccessoriesInterface ac) {
        String acname=ac.getClass().getSimpleName();
        int idx;
        switch (acname) {
            case "boots":
                idx=3;
                break;
            case "helmet":
                idx=1;
                break;
            case "cloth":
                idx=2;
                break;
            default:
                idx=0;
                break;
        }
        if (equipment[idx].getClass().getSimpleName().equals("empty")) {
            if (idx == 0 && this.job() != "fighter") {
                atk += ac.damage();
                equipment[0]=ac;
            } else if (idx == 1) {
                def += ac.defense();
                equipment[1]=ac;
            } else if (idx == 2){
                def += ac.defense();
                equipment[2]=ac;
            }
            else if (idx == 3){
                def += ac.defense();
                equipment[3]=ac;
            }
            System.out.println("Equipped: " + equipment[idx].getClass().getSimpleName());
        }
        else
        {
            System.out.println("You can't Equipped anymore: " + equipment[idx].getClass().getSimpleName());
        }
    }

    @Override
    public void Unequipped(AccessoriesInterface ac) {
        String acname=ac.getClass().getSimpleName();
        int idx;
        switch (acname) {
            case "boots":
                idx=3;
                break;
            case "helmet":
                idx=1;
                break;
            case "cloth":
                idx=2;
                break;
            default:
                idx=0;
                break;
        }
        if (equipment[idx] !=new empty()) {
            System.out.println("Unequipped: " + equipment[idx].getClass().getSimpleName());
            atk -= equipment[idx].damage();
            def -= equipment[idx].defense();
            equipment[idx] = new empty();
        }
        else
        {
            System.out.println("Your "+equipment[idx].getClass().getSimpleName()+" already empty.");
        }
    }

    @Override
    public String job() {

        return job;
    }

    @Override
    public String skill() {

        return skill;
    }

    @Override
    public void Acttack(Player enemy) {
        System.out.println(this.name() + " " + skill + " " + enemy.name());
        int dam = enemy.hitted(this);
        System.out.println("Enemy recive " + dam);
    }

    @Override
    public int atk() {

        return atk;
    }

    @Override
    public int def() {

        return def;
    }

    @Override
    public int hitted(Player player) {
        // TODO Auto-generated method stub
        int dam = (player.atk() - this.def());
        this.hp -= dam;
        return dam;
    }
}
