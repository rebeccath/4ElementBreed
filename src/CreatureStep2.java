import java.util.Objects;

public class CreatureStep2 extends Creature {

    CreatureStep2(String name, int maxHealth, float armor, int attack, float speed, String type, String ancestor1, String ancestor2){
        this.name = name;
        this.maxHealth = (int) (maxHealth*1.4);
        if (Objects.equals("Wasser", type)){
            this.maxHealth = maxHealth+50;
        }
        this.armor = (float) (armor*1.4);
        if (Objects.equals("Erde", type)){
            this.armor = (float) (armor + 0.1);
        }
        this.attack = (int) (attack*1.4);
        if (Objects.equals("Feuer", type)){
            this.attack = attack + 5;
        }
        this.speed = (float) (speed*1.4);
        if (Objects.equals("Luft", type)){
            this.speed = (float) (speed + 0.2);
        }
        this.type = type;
        code = Randomizer.randomString(10);
        step = 2;
        this.ancestors.add(ancestor1);
        this.ancestors.add(ancestor2);
    }
}
