package Accessory.weapon;

public class Bow implements WeaponInterface {

    int durable=100;
    int damage=100;
    int weight=100;

    @Override
    public int durable() {
        // TODO Auto-generated method stub
        return durable;
    }

    @Override
    public int weight() {
        // TODO Auto-generated method stub
        return weight;
    }

    @Override
    public int damage() {
        // TODO Auto-generated method stub
        return damage;
    }

    @Override
    public int defense() {
        // TODO Auto-generated method stub
        return 0;
    }

   
    
}
