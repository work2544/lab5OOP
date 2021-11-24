package Accessory.weapon;

public class Sword implements WeaponInterface {
    int durable=100;
    int damage=100;
    int weight=100;

    @Override
    public int durable() {

        return durable;
    }

    @Override
    public int weight() {

        return weight;
    }

    @Override
    public int damage() {

        return damage;
    }
    @Override
    public int defense() {
        // TODO Auto-generated method stub
        return 0;
    }
}
