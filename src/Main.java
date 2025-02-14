/**
 * Description: This is the Main class of the Game Element4Breed. In This textbased Game you can create elemental creatures,
 * breed them and make them fight.
 * Author: Rebecca Theurer
 * Version: 1.0
 * Date: 13.02.2025
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Creature> basecreatures = new ArrayList<>();
    static ArrayList<Creature> allcreatures = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int counter = 0; //counter all creatures. Maybe useless? Only used for filewriter (mabbe just use allcreatures.getsize()
        int counterb = 0; //counts basecreatures
        boolean medal1 = false;
        boolean medal2 = false;
        boolean medal3 = false;
        boolean medal4 = false;

        //navigation
        Scanner navigator = new Scanner(System.in);
        int choice = 0;

        //programmstart
        System.out.println("\n\n--------------------------------------------------------------\n\nHello and welcome to 4ElementBreed!\n");

        //calls previously saved Creatures
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
            System.out.println("Medallien ansehen (7)");
            System.out.println("Speichern und Beenden (8)");
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
                    int winner;
                    System.out.println("Boss Kampf (1)\nKreatur vs. Kreatur(2)");
                    choice = Navigate.number(">");
                    switch (choice) {
                        case 1:
                            System.out.println("Welchen Boss möchtes du bekämpfen? gewöhnlich (1), spezial (2), episch (3), legendär (4)");
                            int bossChoice = Navigate.number(">");
                            System.out.println("Welche deiner Kreaturen soll gegn ihn antreten?");
                            Show.names(allcreatures);
                            int creatureChoice = Navigate.number(">");
                            switch (bossChoice) {
                                case 1:
                                winner = Creature.fight(Constants.boss1, allcreatures.get(creatureChoice));
                                if(winner == 1){
                                    medal1 = true;
                                }
                                break;
                                case 2:
                                    winner = Creature.fight(Constants.boss2, allcreatures.get(creatureChoice));
                                    if(winner == 1){
                                        medal2 = true;
                                    }
                                    break;
                                    case 3:
                                        winner = Creature.fight(Constants.boss3, allcreatures.get(creatureChoice));
                                        if(winner == 1){
                                            medal3 = true;
                                        }
                                        break;
                                        case 4:
                                            winner = Creature.fight(Constants.boss4, allcreatures.get(creatureChoice));
                                            if(winner == 1){
                                                medal4 = true;
                                            }
                                            break;
                                            default:
                                                System.out.println("Du hast keinen Boss ausgewählt. Wähle 1,2,3 oder 4.");
                                                break;

                            }
                            break;
                        case 2:
                            System.out.println("Deine Kreaturen:");
                            Show.names(allcreatures);
                            System.out.print("Welche Kreaturen sollen kämpfen?\nKreatur 1:\n>");
                            int cr1 = navigator.nextInt();
                            System.out.print("Kreatur 2:\n>");
                            int cr2 = navigator.nextInt();
                            if (cr1 < allcreatures.size() - 1 || cr2 < allcreatures.size() - 1) {
                                Creature.fight(allcreatures.get(cr1), allcreatures.get(cr2));
                            } else {
                                System.out.println("Diese Kreaturen existieren nicht. Bitte wähle eine existierende Nummer aus.");
                            }
                    }

                    break;

                case 4://Breed
                    System.out.println("Alle Kreaturen anzeigen? (y/n)");
                    input = navigator.next().toLowerCase();
                    if (input.equals("y")) {
                        Show.names(allcreatures);
                    }

                    //only creatures of the same step can be bred.
                    choice = Navigate.number("Welche Stufe sollen die Monster haben, die du kreuzen möchtest?\n>");

                    System.out.println("Zwei Stufe " + choice + " Kreaturen mit einander kreuzen");
                    int c1 = Navigate.number("Wähle Kreatur 1\n>");
                    int c2 = Navigate.number("Wähle Kreatur 2\n>");
                    if (c1 > allcreatures.size() - 1 || c2 > allcreatures.size() - 1) {
                        System.out.println("***Du hast eine Nummer ausgewählt, die nicht existiert. Bitte versuche es erneut.***");
                        break;
                    }
                    if (Creature.checkForBreeding(allcreatures.get(c1), allcreatures.get(c2), choice)) {
                        switch (choice) {
                            case 1:
                                allcreatures.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).breed1(allcreatures.get(c1), allcreatures.get(c2)));
                                break;
                                case 2:
                                    allcreatures.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).breed2(allcreatures.get(c1), allcreatures.get(c2)));
                                    break;
                                    case 3:
                                        allcreatures.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).breed3(allcreatures.get(c1), allcreatures.get(c2)));
                                        break;
                                        default:
                                            System.out.println("Du kannst nur Kreaturen der Stufe 1,2 oder 3 mit einander Kreuzen.");
                                }
                                allcreatures.getLast().showCreature();
                                counter++;
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
                            //Are you sure einfügen!
                            try {
                                allcreatures.remove(destroy);
                            } catch (Exception e) {
                                System.out.println("Diese Kreatur existiert nicht.");
                            }
                            counter--;
                            break;

                case 7:
                    System.out.println("Deine Medallien:");
                    Show.medals(medal1, medal2, medal3, medal4);
                    break;



                        case 8:
                            SaveFile.write(counter, allcreatures);
                            System.out.println("Kreaturen wurden gespeichert. Bis zum nächsten Mal!\n\n");
                            System.exit(0);

                        default:
                            System.out.println("***Dies ist keine Option***");
                    }
            }
        }
    }



