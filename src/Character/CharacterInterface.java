package Character;

import Accessory.AccessoriesInterface;

/**
 * interface for Character
 */
public interface CharacterInterface {
  /**
   *
   * @return player's atk
   */
  int atk();

  /**
   *
   * @return player's def
   */
  int def();

  /**
   *
   * @return position of player
   */
  int pos();

  /**
   *
   * @return player race
   */
  String race();

  /**
   *
   * @return player's job
   */
  String job();

  /**
   *
   * @return player's name
   */
  String name();

  /**
   *
   * @return player's skill
   */
  String skill();

  /**
   *
   * @return player's mana
   */
  int mana();

  /**
   *
   * @return player's hp
   */
  int hp();

  /**
   * player walk
   */
  void walk();

  /**
   * player say hello
   */
  default void talk() {
    System.out.println(this.name() + " Saying \"Hello\" to everyone.");
  }

  /**
   * show player's equipment
   */
  void equipment();

  /**
   * check ว่าถึงระยะโจมตีไหม
   *
   * @param enemy ศัตรูที่จะโจมตี
   * @return ว่าโจมตีได้ไหม true of false
   */
  boolean canattack(Player enemy);

  /**
   * สวมใส่ accessory
   * effects: เปลี่ยนแปลง atk และ def
   * @param ac อุปกรณ์ที่จะสวมใส่
   */
  void equip(AccessoriesInterface ac);

  /**
   * ถอด accessory
   * effects: เปลี่ยนแปลง atk และ def
   * @param ac
   */
  void Unequipped(AccessoriesInterface ac);
  /**
   * 
   * 
   * @param player
   */
  void Acttack(Player player);
/**
 * calculate damage received
 * effects: hpของคนเรียกใช้ลดลง
 * @param player who Acttack
 * @return damage received
 */
  int hitted(Player player);
/**
 * show player status
 */
  default void statuswindow() {
    System.out.println();
    System.out.println("-----------" + this.name() + "------------");
    System.out.println("RACE: " + this.race() + " JOB: " + this.job());
    System.out.println(
      "ATK: " +
      this.atk() +
      " DEF: " +
      this.def() +
      " HP: " +
      this.hp() +
      " MANA: " +
      this.mana()
    );
    System.out.println("------------------------------");
    System.out.println();
  }
}
