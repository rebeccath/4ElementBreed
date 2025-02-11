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
    String type;
    String type2 = "/";
    String code; //Einzigartiger, zufälliger Code um Inzest zu vermeiden - Wie Name aber Einzigartig
    ArrayList<String> ancestors = new ArrayList<>();
    Random rand = new Random();
    boolean sex = rand.nextBoolean(); //ture=female; false=male


    void create() {
        type = types[(int) (Math.random()*4)];
        name = "Stacey";
        maxHealth = (int) (Math.random()*1000);
        armor = (float) (Math.round(((Math.random()*0.8)*10)))/10;
        attack = (int) (Math.random()*100);
        speed = (float) (Math.round(((Math.random()*1.8+0.2)*10)))/10;
    }

    void showCreature() {
        System.out.println("Name: " + name);
        System.out.println("Hitpoints: " + maxHealth);
        System.out.println("Rüstung: " + armor);
        System.out.println("Geschwindigkeit: " + speed);
        System.out.println("Schaden: " + attack);
        System.out.println("Typ: " + type);
        System.out.println("Typ 2: " + type2);
        if (sex){
            System.out.println("Geschlecht: f");
        }
        else{
            System.out.println("Geschlecht: m");
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
            int i = 0;

            while (health1 > 0 && health2 > 0) {
                i++;
                int attack1 = (int) ((creature1.attack * creature1.speed * (1 - creature2.armor))*(Math.random()*0.2+0.9));
                int attack2 = (int) ((creature2.attack * creature2.speed * (1 - creature1.armor))*(Math.random()*0.2+0.9));
                System.out.println(("Round " + i + "\n"));
                int showHP1 = (int) (((double)health1/creature1.maxHealth)*10);
                int showHP2 = (int) (((double)health2/creature2.maxHealth)*10);

                //Creature1
                System.out.print(creature1.name + "      ");
                for(int k = 0; k < showHP1; k++){
                    System.out.print("*");
                }
                for(int k = 0; k < 10-showHP1; k++){
                    System.out.print("-");
                }
                System.out.println("    " + health1 + "/" + creature1.maxHealth + " HP   |    Angriff: " + attack1);

                //Creature2
                System.out.print(creature2.name + "      ");
                for(int k = 0; k < showHP2; k++){
                    System.out.print("*");
                }
                for(int k = 0; k < 10-showHP2; k++){
                    System.out.print("-");
                }
                System.out.println("    " + health2 + "/" + creature2.maxHealth + " HP   |    Angriff: " + attack2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                health2 = health2-attack1;
                health1 = health1-attack2;
            }
            if (health1>health2){
                System.out.println(creature1.name + "  won!\n");
            }
            else{
                System.out.println(creature2.name + "  won!\n");
            }
    }

    static boolean checkForBreeding(Creature creature1, Creature creature2, int breedingStep) {
        boolean breed = true;
        if (creature1.step != breedingStep || creature2.step != breedingStep) {
            System.out.println("***Die gewählten Kreaturen haben die falsche Stufe!");
            breed = false;
        }
        if(creature1.sex == creature2.sex){
            System.out.println("***Du kannst keine Kreaturen des selben Geschlechtes mit einander kreuzen***");
            breed = false;
        }
        return breed;

    }

    CreatureStep2 breed1(Creature creature, Creature creature2) {
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
            System.out.println("Folgende Kreatur wurde kreiert:\n");
            return new CreatureStep2("thing", maxHealth, armor, attack, speed, type, ancestor1, ancestor2);
    }

    CreatureStep3 breed2(Creature creature, Creature creature2) {
        this.maxHealth = (int) ((creature.maxHealth + creature2.maxHealth)/2);
        this.armor = (creature.armor + creature2.armor)/2;
        this.attack = (int) ((creature.attack + creature2.attack)/2);
        this.speed = (creature.speed + creature2.speed)/2;
        this.type = creature.type;
        this.type2 = creature2.type;
        if (Creature.compare(creature, creature2) > 0) {
            System.out.println("***Achtung die Kreaturen sind Verwandt.***");
            maxHealth = (int) (maxHealth/2);
            attack = (int) (attack/2);
        }
        // Ich werde jetzt hier mit System out die ancestoers der eltern und kinder ausgeben lassen um zu debuggen und festzustellen, an welcher stelle der fehler liegt.
        this.ancestors = new ArrayList<String>();
        this.ancestors.addAll(creature.ancestors);
        this.ancestors.addAll(creature2.ancestors);
        this.ancestors.add(creature.code);
        this.ancestors.add(creature2.code);
        System.out.println("Folgende Kreatur wurde kreiert:\n");
        return new CreatureStep3("Monster", this.maxHealth, this.armor, this.attack, this.speed, this.type, this.type2, this.ancestors);
    }

    CreatureStep4 breed3(Creature creature, Creature creature2) {
        maxHealth = (int) ((creature.maxHealth + creature2.maxHealth)/2);
        armor = (creature.armor + creature2.armor)/2;
        attack = (int) ((creature.attack + creature2.attack)/2);
        speed = (creature.speed + creature2.speed)/2;
        type = creature.type;
        type2 = creature2.type;
        if (Creature.compare(creature, creature2) == 1) {
            System.out.println("***Achtung die Kreaturen sind entfernt Verwandt.***");
            maxHealth = (int) (maxHealth/1.2);
            attack = (int) (attack/1.2);
        }
        if (Creature.compare(creature, creature2) > 1) {
            System.out.println("***Achtung die Kreaturen sind Verwandt.***");
            maxHealth = (int) (maxHealth/1.6);
            attack = (int) (attack/1.6);
        }
        System.out.println("Folgende Kreatur wurde kreiert:\n");
        return new CreatureStep4("Legend", maxHealth, armor, attack, speed, type, type2);
    }

}
