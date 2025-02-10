import java.util.Objects;

public class CreatureStep4 extends Creature {

    CreatureStep4(String name, int maxHealth, float armor, int attack, float speed, String type, String type2) {
        this.name = name;
        this.maxHealth = (int) (maxHealth*1.11);
        if (Objects.equals("Wasser", type)){
            this.maxHealth = maxHealth + 100;
        }
        if (Objects.equals("Wasser", type2)){
            this.maxHealth = maxHealth+50;
        }
        this.armor = (float) (armor*1.11);
        if (Objects.equals("Erde", type)){
            this.armor = (float) (armor + 0.2);
        }
        if (Objects.equals("Erde", type2)){
            this.armor = (float) (armor + 0.1);
        }
        this.attack = (int) (attack*1.11);
        if (Objects.equals("Feuer", type)){
            this.attack = attack + 40;
        }
        if (Objects.equals("Feuer", type2)){
            this.attack = attack +20;
        }
        this.speed = (float) (speed*1.11);
        if (Objects.equals("Luft", type)){
            this.speed = (float) (speed + 0.6);
        }
        if (Objects.equals("Luft", type2)){
            this.speed = (float) (speed + 0.3);
        }
        this.type = type;
        this.type2 = type2;
        code = Randomizer.randomString(10);
        step = 4;
    }
}
