package Accessory;
public interface AccessoriesInterface {
    int durable();
    int weight();
    int damage();
    int defense();
    default void Equip(){
        System.out.println("Equip");
    };
    default void UnEquipped(){
        System.out.println("UnEquipped");
    };
}
