package Accessory;

/**
 * class for empty accessories
 */
public class empty implements AccessoriesInterface {
    int durable = 0;
    int damage = 0;
    int weight = 0;
    int defense = 0;

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

        return defense;
    }
}
