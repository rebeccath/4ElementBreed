//Breeding Game main
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Creature> basecreatures = new ArrayList<>();
    static ArrayList<Creature> allcreatures = new ArrayList<>();
//Attention! II could put all creatures into one Array List of the type creature, because the other creatrues are child-classes.
    //I have done that now, I will have to change a lot of code before I can remove ArrayLists1,2,3,4

    public static void main(String[] args) throws IOException {

        int counter = 0; //counter all creatures
        int counterb = 0; //counts basecreatures

        //navigation
        Scanner navigator = new Scanner(System.in);
        int choice = 0;


        //programmstart
        System.out.println("\n\n--------------------------------------------------------------\n\nHello and welcome to 4ElementBreed!\n");

        System.out.print("Vorherige Kreaturen einlesen?(y/n)\n>");
        String input = navigator.next().toLowerCase();
        if (input.equals("y")) {
            allcreatures = SaveFile.read();
        }
        counter = allcreatures.size();//to also count the loaded creatures.

        while (true) {
            //Menu
            System.out.println("MenÜ:");
            System.out.println("Kreatur kreieren (1)");
            System.out.println("Kreaturen auflisten (2)");
            System.out.println("Kämpfen (3)");
            System.out.println("Kreaturen züchten (4)");
            System.out.println("Namen von Kreaturen ändern (5)");
            System.out.println("Kreatur vernichten (6)");
            System.out.println("Speichern und Beenden (7)");
            choice = Navigate.number(">");

            switch (choice) {
                case 1://Create Creature
                    //creates basecreature with random values.
                    basecreatures.add(new Creature());
                    basecreatures.get(counterb).create();
                    //Basecreature is transferred to lvl1. This divides all values by 3 (Because creatures lvl1 are weaker than higher level creatures)
                    // this step also adds a bonus dependig on the element
                    allcreatures.add(new CreatureStep1(basecreatures.get(counterb).name, basecreatures.get(counterb).maxHealth, basecreatures.get(counterb).armor, basecreatures.get(counterb).attack, basecreatures.get(counterb).speed, basecreatures.get(counterb).type));

                    System.out.println("\nFolgende Kreatur wurde kreiert:\n");
                    allcreatures.getLast().showCreature();
                    counter++;
                    counterb++;
                    break;

                case 2://List your Creatures
                    //Lists all creatures names by step. Lists details on demand
                    System.out.println("Deine Kreaturen:");
                    Show.names(allcreatures);

                    System.out.println("Deteils anzeigen? (y/n)");
                    input = navigator.next().toLowerCase();
                    if (input.equals("y")) {
                        Show.all(allcreatures);
                    }
                    break;

                case 3://Fight
                    Show.names(allcreatures);
                    System.out.print("Welche Kreaturen sollen kämpfen?\nKreatur 1:\n>");
                    int cr1 = navigator.nextInt();
                    System.out.print("Kreatur 2:\n>");
                    int cr2 = navigator.nextInt();
                    if(cr1 < allcreatures.size()-1 || cr2 < allcreatures.size()-1) {
                        Creature.fight(allcreatures.get(cr1), allcreatures.get(cr2));
                    }
                    else {
                        System.out.println("Diese Kreaturen existieren nicht. Bitte wähle eine existierende Nummer aus.");
                    }

                    break;

                case 4://Breed
                    System.out.println("Alle Kreaturen anzeigen? (y/n)");
                    input = navigator.next().toLowerCase();
                    if (input.equals("y")) {
                        Show.all(allcreatures);
                    }

                    //only creatures of the same step can be bred.
                    choice = Navigate.number("Welche Stufe sollen die Monster haben, die du kreuzen möchtest?\n>");

                    //I would like to export the following into a method. Previously I had problems with passing the right variables along
                    //I know it is a nightmare :D
                    switch (choice) {
                        case 1:
                            System.out.println("Zwei Stufe 1 Kreaturen mit einander kreuzen");
                            int c1 = Navigate.number("Wähle Kreatur 1\n>");
                            int c2 = Navigate.number("Wähle Kreatur 2\n>");
                            if (c1 > allcreatures.size() - 1 || c2 > allcreatures.size() - 1) {
                                System.out.println("***Du hast eine Nummer ausgewählt, die nicht existiert. Bitte versuche es erneut.***");
                                break;
                            }
                            if (Creature.checkForBreeding(allcreatures.get(c1), allcreatures.get(c2), 1)) {
                                allcreatures.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).breed1(allcreatures.get(c1), allcreatures.get(c2)));
                                allcreatures.getLast().showCreature();
                                counter++;
                            }
                            break;
                        case 2:
                            System.out.println("Zwei Stufe 2 Kreaturen mit einander kreuzen");
                            c1 = Navigate.number("Wähle Kreatur 1\n>");
                            c2 = Navigate.number("Wähle Kreatur 2\n>");
                            if (c1 > allcreatures.size() - 1 || c2 > allcreatures.size() - 1) {
                                System.out.println("***Du hast eine Nummer ausgewählt, die nicht existiert. Bitte versuche es erneut.***");
                                break;
                            }
                            if (Creature.checkForBreeding(allcreatures.get(c1), allcreatures.get(c2), 2)) {
                                allcreatures.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).breed2(allcreatures.get(c1), allcreatures.get(c2)));
                                allcreatures.getLast().showCreature();
                                counter++;
                            }
                            break;
                        case 3:
                            System.out.println("Zwei Stufe 3 Kreaturen mit einander kreuzen");
                            c1 = Navigate.number("Wähle Kreatur 1\n>");
                            c2 = Navigate.number("Wähle Kreatur 2\n>");
                            if (c1 > allcreatures.size() - 1 || c2 > allcreatures.size() - 1) {
                                System.out.println("***Du hast eine Nummer ausgewählt, die nicht existiert. Bitte versuche es erneut.***");
                                break;
                            }
                                if (Creature.checkForBreeding(allcreatures.get(c1), allcreatures.get(c2), 3)) {
                                    allcreatures.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).breed3(allcreatures.get(c1), allcreatures.get(c2)));
                                    allcreatures.getLast().showCreature();
                                    counter++;
                                }
                                break;
                                default:
                                    System.out.println("Du kannst nur Kreaturen der Stufe 1-3 mit einander kreuzen.");
                            }
                            break;

                        case 5: //Change Name

                            Scanner text = new Scanner(System.in);
                            Show.all(allcreatures);
                            int creaturenum = Navigate.number("Welchen Namen möchtest du ändern?\nNummer der Kreatur\n>");
                            if (creaturenum > allcreatures.size() - 1) {
                                System.out.println("Diese Nummer existiert leider nicht. Bitte wähle eine andere.");
                                break;
                            }
                            System.out.print("Bitte gib einen neuen Namen ein\n>");
                            String name = text.nextLine();
                            allcreatures.get(creaturenum).name = name;

                            System.out.println("Der Name wurde erfolgreich zu " + name + " geändert.");
                            break;

                            case 6:
                                System.out.println("Welche Kreatur möchtest du gerne vernichten?");
                                Show.names(allcreatures);
                                int destroy = Navigate.number("Nummer\n>");
                                try {
                                    allcreatures.remove(destroy);
                                }
                                catch (Exception e) {
                                    System.out.println("Diese Kreatur existiert nicht.");
                                }
                                counter--;
                                break;


                        case 7:
                            SaveFile.write(counter, allcreatures);
                            System.out.println("Kreaturen wurden gespeichert. Bis zum nächsten Mal!\n\n");
                            System.exit(0);

                        default:
                            System.out.println("***Dies ist keine Option***");
                    }
            }
        }
    }


