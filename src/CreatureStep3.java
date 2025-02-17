import java.util.ArrayList;
import java.util.Objects;

public class CreatureStep3 extends Creature {

    CreatureStep3(String name, int maxHealth, float armor, int attack, float speed, String type, String type2, ArrayList<String> ancestors) {
        this.name = name;
        this.maxHealth = (int) (maxHealth*1.286);
        if (Objects.equals("Wasser", type)){
            this.maxHealth += 100;
        }
        if (Objects.equals("Wasser", type2)){
            this.maxHealth += 50;
        }
        this.armor = (float) (armor*1.286);
        if (Objects.equals("Erde", type)){
            this.armor += 0.2F;
        }
        if (Objects.equals("Erde", type2)){
            this.armor += 0.1F;
        }
        this.attack = (int) (attack*1.286);
        if (Objects.equals("Feuer", type)){
            this.attack += 20;
        }
        if (Objects.equals("Feuer", type2)){
            this.attack += 10;
        }
        this.speed = (float) (speed*1.286);
        if (Objects.equals("Luft", type)){
            this.speed += 0.4F;
        }
        if (Objects.equals("Luft", type2)){
            this.speed += 0.2F;
        }
        this.type = type;
        this.type2 = type2;
        code = Randomizer.randomString(10);
        step = 3;
        this.ancestors = ancestors;
    }
}
