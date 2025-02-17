import java.util.Objects;

public class CreatureStep4 extends Creature {

    CreatureStep4(String name, int maxHealth, float armor, int attack, float speed, String type, String type2) {
        this.name = name;
        this.maxHealth = (int) (maxHealth*1.11);
        if (Objects.equals("Wasser", type)){
            this.maxHealth += 100;
        }
        if (Objects.equals("Wasser", type2)){
            this.maxHealth += 50;
        }
        this.armor = (float) (armor*1.11);
        if (Objects.equals("Erde", type)){
            this.armor += 0.2F;
        }
        if (Objects.equals("Erde", type2)){
            this.armor += 0.1F;
        }
        this.attack = (int) (attack*1.11);
        if (Objects.equals("Feuer", type)){
            this.attack += 40;
        }
        if (Objects.equals("Feuer", type2)){
            this.attack += 20;
        }
        this.speed = (float) (speed*1.11);
        if (Objects.equals("Luft", type)){
            this.speed += 0.6F;
        }
        if (Objects.equals("Luft", type2)){
            this.speed += 0.3F;
        }
        this.type = type;
        this.type2 = type2;
        code = Randomizer.randomString(10);
        step = 4;
    }
}
