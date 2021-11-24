package Character;

import Accessory.AccessoriesInterface;

public interface CharacterInterface{
    int atk();
    int def();  
    String race();
       String job();
       String name();
       String skill();
       int mana();
       int hp();
       void walk();
       default void talk()
       {
           System.out.println(this.name()+ " Saying \"Hello\" to everyone.");
       };
       void equipment();
      // void skill();
       void equip(AccessoriesInterface ac);
       void Unequipped(AccessoriesInterface ac);
       void Acttack(Player player);
       int hitted(Player player);
       default void statuswindow(){
           System.out.println("-----------"+this.name()+ "------------");
           System.out.println("RACE: "+this.race()+" JOB: "+this.job());
           System.out.println("ATK: "+this.atk()+" DEF: "+this.def()+" HP: "+this.hp()+" MANA: "+this.mana());
           System.out.println("------------------------------");
       };
}
