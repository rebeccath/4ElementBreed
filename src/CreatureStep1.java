public class CreatureStep1 extends Creature {


    CreatureStep1(String name, int maxHealth, float armor, int attack, float speed, String type) {
        this.name = name;
        this.maxHealth = (int) (maxHealth*0.5); //Ich hatte eine Wasserkreatur mit 960HP. Das dürfte ja nicht sein.
        if (type.equals("Wasser")) {
            this.maxHealth = maxHealth + 100;
        }
        this.armor = (float) (armor*0.5);
        if (type.equals("Erde")) {
            this.armor = (float) (armor +0.2);
        }
        this.attack = (int) (attack*0.5);
        if (type.equals("Feuer")) {
            this.attack = attack + 20;
        }
        this.speed = (float) (speed*0.5);
        if (type.equals("Luft")) {
            this.speed = (float) (speed + 0.5);
        }
        this.type = type;
        step = 1;
        code = Randomizer.randomString(10);
    }

}
