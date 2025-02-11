//Breeding Game main
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Creature> basecreatures = new ArrayList<>();
    static ArrayList<CreatureStep1> creatures1 = new ArrayList<CreatureStep1>();
    static ArrayList<CreatureStep2> creatures2 = new ArrayList<CreatureStep2>();
    static ArrayList<CreatureStep3> creatures3 = new ArrayList<CreatureStep3>();
    static ArrayList<CreatureStep4> creatures4 = new ArrayList<>();
    static ArrayList<Creature> allcreatures = new ArrayList<>();
//Attention! II could put all creatures into one Array List of the type creature, because the other creatrues are child-classes.
    //I have done that now, I will have to change a lot of code before I can remove ArrayLists1,2,3,4

    public static void main(String[] args) {

        int counter1 = 0; //counter creatures lvl1
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;

        //navigation
        Scanner navigator = new Scanner(System.in);
        int choice = 0;


        //programmstart
        System.out.println("\n\n--------------------------------------------------------------\n\nHello and welcome to 4ElementBreed!\n");

        while (true) {
            //Menu
            System.out.println("MenÜ:");
            System.out.println("Kreatur kreieren (1)");
            System.out.println("Kreaturen auflisten (2)");
            System.out.println("Kämpfen (3)");
            System.out.println("Kreaturen züchten (4)");
            System.out.println("Namen von Kreaturen ändern (5)");
            System.out.println("Speichern und Beenden (6)");
            choice = Navigate.number(">");

            switch (choice) {
                case 1://Create Creature
                    //creates basecreature with random values.
                    basecreatures.add(new Creature());
                    basecreatures.get(counter1).create();
                    //Basecreature is transferred to lvl1. This divides all values by 3 (Because creatures lvl1 are weaker than higher level creatures)
                    // this step also adds a bonus dependig on the element
                    creatures1.add(new CreatureStep1(basecreatures.get(counter1).name, basecreatures.get(counter1).maxHealth, basecreatures.get(counter1).armor, basecreatures.get(counter1).attack, basecreatures.get(counter1).speed, basecreatures.get(counter1).type));
                    allcreatures.add(creatures1.get(counter1)); //I soon want to do vereything over the allcreatures arraylist.

                    System.out.println("\nFolgende Kreatur wurde kreiert:\n");
                    creatures1.get(counter1).showCreature();
                    counter1++;
                    break;

                    case 2://List your Creatures
                        //Lists all creatures names by step. Lists details on demand
                        System.out.println("Deine Kreaturen:");
                        Show.names(allcreatures);

                        System.out.println("Deteils anzeigen? (y/n)");
                        String input = navigator.next().toLowerCase();
                        if (input.equals("y")) {
                            Show.all(creatures1, creatures2, creatures3, creatures4);
                        }
                        break;

                        case 3://Fight
                            Show.names(allcreatures);
                            System.out.print("Welche Kreaturen sollen kämpfen?\nKreatur 1:\n>");
                            int cr1 = navigator.nextInt();
                            System.out.print("Kreatur 2:\n>");
                            int cr2 = navigator.nextInt();
                            Creature.fight(allcreatures.get(cr1), allcreatures.get(cr2));
                            break;

                            case 4://Breed
                                System.out.println("Alle Kreaturen anzeigen? (y/n)");
                                input = navigator.next().toLowerCase();
                                if (input.equals("y")) {
                                    Show.all(creatures1, creatures2, creatures3, creatures4);
                                }

                                //only creatures of the same step can be bred.
                                choice = Navigate.number("Welche Stufe sollen die Monster haben, die du kreuzen möchtest?\n>");

                                //I would like to export the following into a method. Previously I had problems with passing the right variables along
                                switch (choice) {
                                    case 1:
                                        System.out.println("Zwei Stufe 1 Kreaturen mit einander kreuzen");
                                        int c1 = Navigate.number("Wähle Kreatur 1\n>");
                                        int c2 = Navigate.number("Wähle Kreatur 2\n>");
                                        if (c1>creatures1.size()-1 || c2>creatures1.size()-1) {
                                            System.out.println("***Du hast eine Nummer ausgewählt, die nicht existiert. Bitte versuche es erneut.***");
                                            break;
                                        }
                                        if (c1>creatures1.size()-1 || c2>creatures1.size()-1) {
                                            System.out.println("***You chose a number that does not exist. Please try again.***");
                                            break;
                                        }
                                        if(creatures1.get(c1).sex == creatures1.get(c2).sex){
                                            System.out.println("***Du kannst keine Kreaturen des selben Geschlechtes mit einander kreuzen***");
                                        }
                                        else {
                                            creatures2.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).breed1(creatures1.get(c1), creatures1.get(c2)));
                                            System.out.println("Folgende Kreatur wurde kreiert:\n");
                                            creatures2.getLast().showCreature();
                                            allcreatures.add(creatures2.get(creatures2.size() - 1));
                                            counter2++;
                                        }
                                        break;
                                        case 2:
                                            System.out.println("Zwei Stufe 2 Kreaturen mit einander kreuzen");
                                            c1 = Navigate.number("Wähle Kreatur 1\n>");
                                            c2 = Navigate.number("Wähle Kreatur 2\n>");
                                            if (c1>creatures2.size()-1 || c2>creatures2.size()-1) {
                                                System.out.println("***Du hast eine Nummer ausgewählt, die nicht existiert. Bitte versuche es erneut.***");
                                                break;
                                            }
                                            if(creatures2.get(c1).sex == creatures2.get(c2).sex){
                                                System.out.println("***Du kannst keine Kreaturen des selben Geschlechtes mit einander kreuzen***");
                                            }
                                            else {
                                                creatures3.add(new CreatureStep3(null, 0, 0, 0, 0, null, null, null).breed2(creatures2.get(c1), creatures2.get(c2)));
                                                System.out.println("Folgende Kreatur wurde kreiert:\n");
                                                creatures3.get(creatures3.size() - 1).showCreature();
                                                allcreatures.add(creatures3.get(creatures3.size() - 1));
                                                counter3++;
                                            }
                                            break;
                                            case 3:
                                                System.out.println("Zwei Stufe 3 Kreaturen mit einander kreuzen");
                                                c1 = Navigate.number("Wähle Kreatur 1\n>");
                                                c2 = Navigate.number("Wähle Kreatur 2\n>");
                                                if (c1>creatures3.size()-1 || c2>creatures3.size()-1) {
                                                    System.out.println("***Du hast eine Nummer ausgewählt, die nicht existiert. Bitte versuche es erneut.***");
                                                    break;
                                                }
                                                if(creatures3.get(c1).sex == creatures3.get(c2).sex){
                                                    System.out.println("***Du kannst keine Kreaturen des selben Geschlechtes mit einander kreuzen***");
                                                }
                                                else {
                                                    creatures4.add(new CreatureStep4(null, 0, 0, 0, 0, null, null).breed3(creatures3.get(c1), creatures3.get(c2)));
                                                    System.out.println("Folgende Kreatur wurde kreiert:\n");
                                                    creatures4.get(creatures4.size() - 1).showCreature();
                                                    allcreatures.add(creatures4.get(creatures4.size() - 1));
                                                    counter4++;
                                                }
                                                break;
                                }
                                break;

                case 5: //Change Name

                    Scanner text = new Scanner(System.in);
                    Show.all(creatures1, creatures2, creatures3, creatures4);
                    int Stufe = Navigate.number("Welchen Namen möchtest du ändern?\nStufe\n>");
                    int creaturenum = Navigate.number("Nummer der Kreatur\n>");
                    System.out.print("Bitte gib einen Namen ein\n>");
                    String name = text.nextLine();

                    if (Stufe == 1){
                        creatures1.get(creaturenum).name = name;
                    }
                    if (Stufe == 2){
                        creatures2.get(creaturenum).name = name;
                    }
                    if (Stufe == 3){
                        creatures3.get(creaturenum).name = name;
                    }
                    if (Stufe == 4){
                        creatures4.get(creaturenum).name = name;
                    }
                    System.out.println("Der Name wurde erfolgreich zu " + name + " geändert.");
                    break;

                case 6:
                    SaveFile.write1(counter1,creatures1);
                    SaveFile.write2(counter2,creatures2);
                    SaveFile.write3(counter3,creatures3);
                    SaveFile.write4(counter4,creatures4);
                    System.out.println("Kreaturen wurden gespeichert. Bis zum nächsten Mal!\n\n");
                    System.exit(0);
            }
        }
    }
}
