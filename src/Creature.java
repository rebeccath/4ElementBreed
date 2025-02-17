import java.util.ArrayList;
import java.util.Random;

public class Creature {
    String[] types = {"Feuer", "Luft", "Wasser", "Erde"}; //Contains all possible Elements so they can later be assigned at random
    String name;
    int health; //1-1000
    int maxHealth; //1-1000
    float armor; //0-0.8
    int attack; //1-100
    float speed; //0.2-2
    int step = 0; //1-4; A sort of Breeding level. All Creatures start at step 1. when 2 cr. of the same step are bred the childs step will be one higher
    String type; //Elemental Type
    String type2 = "/"; //Type 2 is only availeble for creatures step 3 and 4
    String code; //Unique, random Code is used to pass on to children to prevent beeding related creatures
    ArrayList<String> ancestors = new ArrayList<>(); //Will contain parents and grandparents codes

    //I tried to set Sex in constructor but somehow only created male creatures. Sueley makes sense...
    Random rand = new Random(); //used to set sex in constructor
    boolean sex = rand.nextBoolean(); //ture=female; false=male



    /**
     * constructor creates a basic creature with random values within the set boundaries
     * All Creatures are currently called Stacey. Random name generation can be implemented here.
     *
     *!!!random sex feels male heavy. Check that out.!!!
     */
    void create() {
        type = types[(int) (Math.random()*4)];
        name = "Stacey";
        maxHealth = (int) (Math.random()*Constants.MAXHP);
        armor = (float) (Math.round(((Math.random()*Constants.MAXARMOR)*10)))/10;
        attack = (int) (Math.random()*Constants.MAXDAMAGE);
        speed = (float) (Math.round(((Math.random()*(Constants.MAXSPEED-0.2F)+0.2)*10)))/10;
    }

    /**
     * Prints out all user relevant features of a creature
     */
    void showCreature() {
        System.out.println("Name: " + name);
        System.out.print("Hitpoints: " + maxHealth);
        for(int i=0; i<Creature.checkHP(step, maxHealth); i++) {
            System.out.print("*");
        }
        System.out.print("\nRüstung: " + armor);
        for(int i=0; i<Creature.checkArmor(step, armor); i++) {
            System.out.print("*");
        }
        System.out.print("\nGeschwindigkeit: " + speed);
        for(int i=0; i<Creature.checkSpeed(step, speed); i++) {
            System.out.print("*");
        }
        System.out.print("\nSchaden: " + attack);
        for(int i=0; i<Creature.checkAttack(step, attack); i++) {
            System.out.print("*");
        }
        System.out.println("\nTyp: " + type);
        System.out.println("Typ 2: " + type2);
        if (sex){
            System.out.println("Geschlecht: f");
        }
        else{
            System.out.println("Geschlecht: m");
        }
        System.out.println("Stufe: " + step + "\n");
    }

    /**
     * The 4 follwing functions check wether the creatures values are higher
     * than half the max value for that step or higher than the max vlaue (this is possible
     * when the creature has the corresponding element.
     * it returns a 1 for higher than half and a 2 for higher than max
     *
     * @param step
     * @param maxHP
     * @return
     */
    static int checkHP(int step, int maxHP) {
        int star=0;
        if (step == 1) {
            if (maxHP > (Constants.MAXHP*Constants.STEP1Factor)/2) {
                star = 1;
            }
            if (maxHP > Constants.MAXHP*Constants.STEP1Factor) {
                star = 2;
            }
        }
        if (step == 2) {
            if (maxHP > (Constants.MAXHP*Constants.STEP2Factor)/2) {
                star = 1;
            }
            if (maxHP > Constants.MAXHP*Constants.STEP2Factor) {
                star = 2;
            }
        }
        if (step == 3) {
            if (maxHP > (Constants.MAXHP*Constants.STEP3Factor)/2) {
                star = 1;
            }
            if (maxHP > Constants.MAXHP*Constants.STEP3Factor) {
                star = 2;
            }
        }
        if (step == 4) {
            if (maxHP > (Constants.MAXHP*Constants.STEP4Factor)/2) {
                star = 1;
            }
            if (maxHP > Constants.MAXHP*Constants.STEP4Factor) {
                star = 2;
            }
        }
        return star;
    }
    static int checkArmor(int step, float armor) {
        int star=0;
        if (step == 1) {
            if (armor > (Constants.MAXARMOR*Constants.STEP1Factor)/2) {
                star = 1;
            }
            if (armor > Constants.MAXARMOR*Constants.STEP1Factor) {
                star = 2;
            }
        }
        if (step == 2) {
            if (armor > (Constants.MAXARMOR*Constants.STEP2Factor)/2) {
                star = 1;
            }
            if (armor > Constants.MAXARMOR*Constants.STEP2Factor) {
                star = 2;
            }
        }
        if (step == 3) {
            if (armor > (Constants.MAXARMOR*Constants.STEP3Factor)/2) {
                star = 1;
            }
            if (armor > Constants.MAXARMOR*Constants.STEP3Factor) {
                star = 2;
            }
        }
        if (step == 4) {
            if (armor > (Constants.MAXARMOR*Constants.STEP4Factor)/2) {
                star = 1;
            }
            if (armor > Constants.MAXARMOR*Constants.STEP4Factor) {
                star = 2;
            }
        }
        return star;
    }
    static int checkAttack(int step, int attack) {
        int star=0;
        if (step == 1) {
            if (attack > (Constants.MAXDAMAGE*Constants.STEP1Factor)/2) {
                star = 1;
            }
            if (attack > Constants.MAXDAMAGE*Constants.STEP1Factor) {
                star = 2;
            }
        }
        if (step == 2) {
            if (attack > (Constants.MAXDAMAGE*Constants.STEP2Factor)/2) {
                star = 1;
            }
            if (attack > Constants.MAXDAMAGE*Constants.STEP2Factor) {
                star = 2;
            }
        }
        if (step == 3) {
            if (attack > (Constants.MAXDAMAGE*Constants.STEP3Factor)/2) {
                star = 1;
            }
            if (attack > Constants.MAXDAMAGE*Constants.STEP3Factor) {
                star = 2;
            }
        }
        if (step == 4) {
            if (attack > (Constants.MAXDAMAGE*Constants.STEP4Factor)/2) {
                star = 1;
            }
            if (attack > Constants.MAXDAMAGE*Constants.STEP4Factor) {
                star = 2;
            }
        }
        return star;
    }
    static int checkSpeed(int step, float speed) {
        int star=0;
        if (step == 1) {
            if (speed > (Constants.MAXSPEED*Constants.STEP1Factor)/2) {
                star = 1;
            }
            if (speed > Constants.MAXSPEED*Constants.STEP1Factor) {
                star = 2;
            }
        }
        if (step == 2) {
            if (speed > (Constants.MAXSPEED*Constants.STEP2Factor)/2) {
                star = 1;
            }
            if (speed > Constants.MAXSPEED*Constants.STEP2Factor) {
                star = 2;
            }
        }
        if (step == 3) {
            if (speed > (Constants.MAXSPEED*Constants.STEP3Factor)/2) {
                star = 1;
            }
            if (speed > Constants.MAXSPEED*Constants.STEP3Factor) {
                star = 2;
            }
        }
        if (step == 4) {
            if (speed > (Constants.MAXSPEED*Constants.STEP4Factor)/2) {
                star = 1;
            }
            if (speed > Constants.MAXSPEED*Constants.STEP4Factor) {
                star = 2;
            }
        }
        return star;
    }

    /**
     * Compares 2 creatures ancestors by looping through the arrayLists.
     * Is used when breeding Step 2 and Step 3 to prevent breeding related creatures.
     *
     * @param c1 one creature of any step whos ancestors you want to compare with anothers
     * @param c2 the other cresture of any step
     * @return returns integer. This reflects the amount of common ancestors found
     */
    static int compareAncestors(Creature c1, Creature c2) {
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

    /**
     * Makes 2 Creatures fight one another.
     * wether a creature wins or loses has no cinsequences for the game so far.
     * Shows a nice grafic representation of the fight.
     * Creates health variable for creature 1 and 2 to display current health
     * fight continues until one creatures health falls below 0
     * each round creature 1 and 2 attack are calculated as attackvalue * speed * 1-enemyArmor * random factor betewwn 0.9-1.1
     * each round prints name, hitpoints, hitpointbar and attack
     * HPbar is created with helpvariable showHP !!!export this step to method!!!
     * After fight sequence message shows creature with higher hitpoints as winner
     *
     * @param creature1
     * @param creature2
     * @return returns an integer. Either 1 or 2 depending on which creature won.
     */
    static int fight(Creature creature1, Creature creature2) {
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
                return 1;
            }
            else{
                System.out.println(creature2.name + "  won!\n");
                return 2;
            }
    }

    /**
     * Compares 2 Creatures sex and step. Returns boolean true = can breed, false = can not breed
     * breed is set to false when step of either creatures is not equal to breeding step.
     * breed is set to false when sex of both creatures is the same
     *Also returns Message, when creatures cannot be bred
     *
     * @param creature1
     * @param creature2
     * @param breedingStep step that is supposed to be bred. This has to be checkt because breeding is slightly different for every step.
     *                     Also creatures have to be of the same Step to breed together.
     * @return breed boolean that shows wether creatuers can be bred together. (true = can breed; false = can not breed)
     */
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

    /**
     * Breeds 2 creatures of step 1 and returns creature of step 2.
     * Any Step creature can be entered so Main Programm has to make shure the right step is entered. (Uses checkForBreed method)
     * it could also be specified in input but this might cause Error if wrong creature is entered. (maybe a good thing?)
     * !!!check this!!!
     *
     * max health, armor, attack and speed are calculated as mean of parents values
     * One type is selected randomly from parents types
     * To track ancestors parents codes are passed down to CreatureStep2 (They will be added to an ArrayList)
     * Prnints Message and returns relevant values to new CreatureStep2
     *
     * @param creature Parent 1
     * @param creature2 Parent 2
     * @return CreatureStep2
     */
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

    /**
     * Breeds 2 creatures of step 2 and returns creature of step 3
     * like breed1
     * Differences:
     * Compares Parents ancestors. If any relations are revealed creatures health and attack are weakened by 1/2.
     * Aslo informs user via message
     * adds parents and grandparents codes do ArrayList, returns thsi ArrayList to Child
     *
     * @param creature
     * @param creature2
     * @return CreatureStep3
     */
    CreatureStep3 breed2(Creature creature, Creature creature2) {
        this.maxHealth = (int) ((creature.maxHealth + creature2.maxHealth)/2);
        this.armor = (creature.armor + creature2.armor)/2;
        this.attack = (int) ((creature.attack + creature2.attack)/2);
        this.speed = (creature.speed + creature2.speed)/2;
        this.type = creature.type;
        this.type2 = creature2.type;
        if (Creature.compareAncestors(creature, creature2) > 0) {
            System.out.println("***Achtung die Kreaturen sind Verwandt. Ihr Nachkomme wird schwächer sein.***");
            maxHealth = (int) (maxHealth/2);
            attack = (int) (attack/2);
        }
        this.ancestors = new ArrayList<String>();
        this.ancestors.addAll(creature.ancestors);
        this.ancestors.addAll(creature2.ancestors);
        this.ancestors.add(creature.code);
        this.ancestors.add(creature2.code);
        System.out.println("Folgende Kreatur wurde kreiert:\n");
        return new CreatureStep3("Monster", this.maxHealth, this.armor, this.attack, this.speed, this.type, this.type2, this.ancestors);
    }

    /**
     * Breeds two Step3 Creatures and returns Step 4 Creature
     * Like breed1 and breed 2
     * Differences:
     * -Does not pass on ancestors as these are irrelevant to Step 4 Creatures since they can not be bred.
     *  This might become relevant when I want to be able to save and display the Family tree
     * -Differenciates between degrees of relationship. Creatures with one common ancestor are reduced by 1.2 with 2 or more by 1.6
     *
     *
     * @param creature
     * @param creature2
     * @return CreatureStep4
     */
    CreatureStep4 breed3(Creature creature, Creature creature2) {
        maxHealth = (int) ((creature.maxHealth + creature2.maxHealth)/2);
        armor = (creature.armor + creature2.armor)/2;
        attack = (int) ((creature.attack + creature2.attack)/2);
        speed = (creature.speed + creature2.speed)/2;
        type = creature.type;
        type2 = creature2.type;
        if (Creature.compareAncestors(creature, creature2) == 1) {
            System.out.println("***Achtung die Kreaturen sind entfernt Verwandt.***");
            maxHealth = (int) (maxHealth/1.2);
            attack = (int) (attack/1.2);
        }
        if (Creature.compareAncestors(creature, creature2) > 1) {
            System.out.println("***Achtung die Kreaturen sind Verwandt.***");
            maxHealth = (int) (maxHealth/1.6);
            attack = (int) (attack/1.6);
        }
        System.out.println("Folgende Kreatur wurde kreiert:\n");
        return new CreatureStep4("Legend", maxHealth, armor, attack, speed, type, type2);
    }

}
