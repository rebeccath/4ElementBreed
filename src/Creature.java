import java.util.ArrayList;
import java.util.Random;

public class Creature {
    String[] types = {"Feuer", "Luft", "Wasser", "Erde"};
    String name;
    int health; //1-1000
    int maxHealth; //1-1000
    float armor; //0-0.8
    int attack; //1-100
    float speed = (float) (Math.round(((Math.random()*1.8+0.2)*10)))/10; //0.2-2
    int step = 0; //1-4
    int level; //1-20
    String type;
    String type2 = "/";
    String code; //Einzigartiger, zufälliger Code um Inzest zu vermeiden - Wie Name aber Einzigartig
    ArrayList<String> ancestors = new ArrayList<>();
    Random rand = new Random();
    boolean sex = rand.nextBoolean(); //ture=female; false=male


    void Create() {
        type = types[(int) (Math.random()*4)];
        name = "Stacey";
        maxHealth = (int) (Math.random()*1000);
        armor = (float) (Math.round(((Math.random()*0.8)*10)))/10;
        attack = (int) (Math.random()*100);
        speed = (float) (Math.round(((Math.random()*1.8+0.2)*10)))/10;
    }


    void ShowCreature() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + maxHealth);
        System.out.println("Armor: " + armor);
        System.out.println("Speed: " + speed);
        System.out.println("Damage: " + attack);
        System.out.println("Type: " + type);
        System.out.println("Type2: " + type2);
        if (sex){
            System.out.println("Sex: f");
        }
        else{
            System.out.println("Sex: m");
        }
        System.out.println("Stufe: " + step + "\n");
    }

    static int compare(Creature c1, Creature c2) {
        int rel = 0;//Relation-> Verwandheitsgrad (je höher, desto verwandter)
        for (int j=0; j<c2.ancestors.size(); j++) {
        for (int i=0; i<c1.ancestors.size(); i++) {
            if (c1.ancestors.get(i) == c2.ancestors.get(j)) {
                rel++;
            }
        }
        }
        return rel;
    }


        static void fight(Creature creature1, Creature creature2) {
            System.out.println("Creature 1: " + creature1.name + "s Health: " + creature1.maxHealth);
            System.out.println("Creature 2: " + creature2.name + "s Health: " + creature2.maxHealth);
            System.out.println("\n3\n2\n1");
            System.out.println("***Fight***");
            int health1 = creature1.maxHealth;
            int health2 = creature2.maxHealth;

            while (health1 > 0 && health2 > 0) {
                int attack1 = Math.round((creature1.attack * creature1.speed * (1 - creature2.armor)));
                health2 = health2-attack1;
                int attack2 = Math.round((creature2.attack * creature2.speed * (1 - creature1.armor)));
                health1 = health1-attack2;
                System.out.println(creature1.name + "s Attack: " + attack1);
                System.out.println(creature2.name + "s Attack: " + attack2);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(creature1.name + "s Health: " + health1);
                System.out.println(creature2.name + "s Health: " + health2);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
    }

    CreatureStep2 Breed1(Creature creature, Creature creature2) {
            maxHealth = (int) ((creature.maxHealth + creature2.maxHealth) / 2);
            armor = (creature.armor + creature2.armor) / 2;
            attack = (int) ((creature.attack + creature2.attack) / 2);
            speed = (creature.speed + creature2.speed) / 2;
            ArrayList<String> choosetype = new ArrayList<>();
            choosetype.add(creature.type);
            choosetype.add(creature2.type);
            type = choosetype.get((int) (Math.random() * 2));
            String ancestor1 = creature.code;
            String ancestor2 = creature2.code;
            return new CreatureStep2("thing", maxHealth, armor, attack, speed, type, ancestor1, ancestor2);
    }
    //Aktuell bekommen Sie einfach den Typ von Kreatur1

    CreatureStep3 Breed2(Creature creature, Creature creature2) {
        maxHealth = (int) ((creature.maxHealth + creature2.maxHealth)/2);
        armor = (creature.armor + creature2.armor)/2;
        attack = (int) ((creature.attack + creature2.attack)/2);
        speed = (creature.speed + creature2.speed)/2;
        type = creature.type;
        type2 = creature2.type;
        if (Creature.compare(creature, creature2) > 0) {
            System.out.println("***Achtung die Kreaturen sind Verwandt.***");
            maxHealth = (int) (maxHealth/2);
            attack = (int) (attack/2);
        }
        return new CreatureStep3("Monster", maxHealth, armor, attack, speed, type, type2);
    }

    CreatureStep4 Breed3(Creature creature, Creature creature2) {
        maxHealth = (int) ((creature.maxHealth + creature2.maxHealth)/2);
        armor = (creature.armor + creature2.armor)/2;
        attack = (int) ((creature.attack + creature2.attack)/2);
        speed = (creature.speed + creature2.speed)/2;
        type = creature.type;
        type2 = creature2.type;
        return new CreatureStep4("Legend", maxHealth, armor, attack, speed, type, type2);
    }

}
