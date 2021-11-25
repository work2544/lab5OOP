package Character;

import Accessory.AccessoriesInterface;
import Accessory.armo.ArmoInterface;
import Accessory.empty;
import Accessory.weapon.WeaponInterface;
import Character.job.job;

public class Player implements CharacterInterface {
  private int atk;
  private int def;
  private String race;
  private String name;
  private job job;
  private int hp;
  private int mana;
  private String skill;
  private int rayaatk;
  private int pos = 20;
  AccessoriesInterface[] equipment = new AccessoriesInterface[4];

  public Player(
    WeaponInterface weapon,
    String race,
    job job,
    String name,
    int hp,
    int mana,
    ArmoInterface cloth,
    ArmoInterface boots,
    ArmoInterface helmet
  ) {
    this.race = race;
    this.name = name;
    this.job = job;
    this.hp = hp;
    this.mana = mana;
    this.skill = job.skill();
    this.rayaatk = job.rayaatk();
    if (job.getClass().getClass().getSimpleName().equals("fighter")) {
      this.hp += 100;
      this.atk += 100;
    } else {
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
    System.out.println("กำลังไปหารอยู่เฉยๆนะ");
    this.pos -= 20;
  }

  @Override
  public void equipment() {
    for (AccessoriesInterface accessoriesInterface : equipment) {
      System.out.print(accessoriesInterface.getClass().getSimpleName() + " ");
    }
    System.out.println();
  }

  @Override
  public void equip(AccessoriesInterface ac) {
    String acname = ac.getClass().getSimpleName();
    int idx;
    switch (acname) {
      case "boots":
        idx = 3;
        break;
      case "helmet":
        idx = 1;
        break;
      case "cloth":
        idx = 2;
        break;
      default:
        idx = 0;
        break;
    }
    if (equipment[idx].getClass().getSimpleName().equals("empty")) {
      if (idx == 0 && this.job() != "fighter") {
        atk += ac.damage();
        equipment[0] = ac;
      } else {
        def += ac.defense();
        if (idx == 1) {
          equipment[1] = ac;
        } else if (idx == 2) {
          equipment[2] = ac;
        } else if (idx == 3) {
          equipment[3] = ac;
        }
      }
      System.out.println(
        "Equipped: " + equipment[idx].getClass().getSimpleName()
      );
    } else {
      System.out.println(
        "You can't Equipped anymore: " +
        equipment[idx].getClass().getSimpleName()
      );
    }
  }

  @Override
  public void Unequipped(AccessoriesInterface ac) {
    String acname = ac.getClass().getSimpleName();
    int idx;
    switch (acname) {
      case "boots":
        idx = 3;
        break;
      case "helmet":
        idx = 1;
        break;
      case "cloth":
        idx = 2;
        break;
      default:
        idx = 0;
        break;
    }
    if (!equipment[idx].getClass().getSimpleName().equals("empty")) {
      System.out.println(
        "Unequipped: " + equipment[idx].getClass().getSimpleName()
      );
      atk -= equipment[idx].damage();
      def -= equipment[idx].defense();
      equipment[idx] = new empty();
    } else {
      System.out.println("Your slot is already empty.");
    }
  }

  @Override
  public String job() {
    return job.getClass().getSimpleName();
  }

  @Override
  public String skill() {
    return skill;
  }

  @Override
  public void Acttack(Player enemy) {
    if (canattack(enemy)) {
      System.out.println(this.name() + " " + skill + " " + enemy.name());
      int dam = enemy.hitted(this);
      System.out.println("Enemy recive " + dam);
    } else {
      System.out.println("YOu too far from your enemy: " + enemy.name);
    }
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
    int dam = (player.atk() - this.def());
    this.hp -= dam;
    return dam;
  }

  @Override
  public int pos() {
    return pos;
  }

  @Override
  public boolean canattack(Player player) {
    return (this.pos() + player.pos()) <= rayaatk;
  }
}
