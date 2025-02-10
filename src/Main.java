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
//Achtung! Ich könnte auch alle Kreaturen in eine Array List vom Typ Creature packen, weil die untertypen vererbt sind.
    //Ich mache das hier nicht. weil ich dann alles umscheiben müsste.

    public static void main(String[] args) {

        int i = 0;//Counter für neu Kreierte lvl1 Kreaturen in case 1
        //Navigation:
        Scanner navigator = new Scanner(System.in);
        int choice = 0;
        int counter1 = 0; //counter creaturen lvl1
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;

        System.out.println("\n\n--------------------------------------------------------------\n\nHello and welcome to 4ElementBreed!\n");

        while (true) {
            System.out.println("Menu:");
            System.out.println("create Creature (1)");
            System.out.println("List your creatures (2)");
            System.out.println("Fight (3)");
            System.out.println("Breed (4)");
            System.out.println("Change Creature name (5)");
            System.out.println("Quit (6)");
            choice = Navigate.number(">");

            switch (choice) {
                case 1://Create Creature
                    //Basiskreatur wird mit zufälligen Werten erstellt.
                    basecreatures.add(new Creature());
                    basecreatures.get(i).Create();
                    //Basiskreatur wird in Stufe1 überführt. Hierbei: alle Werte mal 0.5 (Weil stufe1 schwächer ist als die höheren)
                    // und Bonus wird je nach Element addiert
                    creatures1.add(new CreatureStep1(basecreatures.get(i).name, basecreatures.get(i).maxHealth, basecreatures.get(i).armor, basecreatures.get(i).attack, basecreatures.get(i).speed, basecreatures.get(i).type));
                    allcreatures.add(creatures1.get(i));
                    System.out.println("\nThis Creature has been created:\n");
                    creatures1.get(i).ShowCreature();
                    i++;
                    counter1++;
                    break;

                case 2://List your Creatures
                    //Zuerst werden nur die Namen je Stufe aufgelistet und auf nachfrage Deteils zu allen Kreaturen
                    System.out.println("Your Creatures:");
                    Show.names(creatures1, creatures2, creatures3, creatures4);

                    System.out.println("Deteils? (y/n)");
                    String input = navigator.next().toLowerCase();
                    if (input.equals("y")) {
                        Show.all(creatures1, creatures2, creatures3, creatures4);
                    }
                    break;

                case 3://Fight
                    Show.names(creatures1, creatures2, creatures3, creatures4);
                    System.out.print("Welche Kreaturen sollen kämpfen?\nKreatur 1:\n>");
                    int cr1 = navigator.nextInt();
                    System.out.print("Kreatur 2:\n>");
                    int cr2 = navigator.nextInt();
                    Creature.fight(allcreatures.get(cr1), allcreatures.get(cr2));
                    break;

                case 4://Breed
                    System.out.println("Show all Creatures? (y/n)");
                    input = navigator.next().toLowerCase();
                    if (input.equals("y")) {
                        Show.all(creatures1, creatures2, creatures3, creatures4);
                    }

                    //Da nur Kreaturen der gleichen Stufe mit einander gezüchtet werden können, wird hier danach gefragt
                    choice = Navigate.number("Welche Stufe sollen die Monster haben, die du kreuzen möchtest?\n>");

                    //Den folgenden Prozess würde ich gerne in eine Klasse Exportieren aber ich weiß nicht, wie. Ich hatte bei meinem letzten Versuch Probleme
                    //damit, die richtigen Variablen hin und her zu geben.
                    switch (choice) {
                        case 1:
                            System.out.println("Zwei Stufe 1 Kreaturen mit einander kreuzen");
                            int c1 = Navigate.number("Choose Creature 1\n>");
                            int c2 = Navigate.number("Choose Creature 2\n>");
                            if (c1>creatures1.size()-1 || c2>creatures1.size()-1) {
                                System.out.println("***You chose a number that does not exist. Please try again.***");
                                break;
                            }
                            if(creatures1.get(c1).sex == creatures1.get(c2).sex){
                                System.out.println("***You can not breed same sex creatures***");
                            }
                            else {
                                creatures2.add(new CreatureStep2(null, 0, 0, 0, 0, null, null, null).Breed1(creatures1.get(c1), creatures1.get(c2)));
                                System.out.println("This Creature has been created:\n");
                                creatures2.getLast().ShowCreature();
                                allcreatures.add(creatures2.get(creatures2.size() - 1));
                                counter2++;
                            }
                            break;
                        case 2:
                            System.out.println("Zwei Stufe 2 Kreaturen mit einander kreuzen");
                            c1 = Navigate.number("Choose Creature 1\n>");
                            c2 = Navigate.number("Choose Creature 2\n>");
                            if (c1>creatures2.size()-1 || c2>creatures2.size()-1) {
                                System.out.println("***You chose a number that does not exist. Please try again.***");
                                break;
                            }
                            if(creatures2.get(c1).sex == creatures2.get(c2).sex){
                                System.out.println("***You can not breed same sex creatures***");
                            }
                            else {
                                creatures3.add(new CreatureStep3(null, 0, 0, 0, 0, null, null).Breed2(creatures2.get(c1), creatures2.get(c2)));
                                System.out.println("This Creature has been created:\n");
                                creatures3.get(creatures3.size() - 1).ShowCreature();
                                allcreatures.add(creatures3.get(creatures3.size() - 1));
                                counter3++;
                            }
                            break;
                        case 3:
                            System.out.println("Zwei Stufe 3 Kreaturen mit einander kreuzen");
                            c1 = Navigate.number("Choose Creature 1\n>");
                            c2 = Navigate.number("Choose Creature 2\n>");
                            if (c1>creatures3.size()-1 || c2>creatures3.size()-1) {
                                System.out.println("***You chose a number that does not exist. Please try again.***");
                                break;
                            }
                            if(creatures3.get(c1).sex == creatures3.get(c2).sex){
                                System.out.println("***You can not breed same sex creatures***");
                            }
                            else {
                                creatures4.add(new CreatureStep4(null, 0, 0, 0, 0, null, null).Breed3(creatures3.get(c1), creatures3.get(c2)));
                                System.out.println("This Creature has been created:\n");
                                creatures4.get(creatures4.size() - 1).ShowCreature();
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
                    String name = text.nextLine();//Achtung! Nimmt keine Leerzeichen. Aber warum???

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
                    System.out.println("Creaturen wurden gespeichert. Bis zum nächsten Mal!\n\n");
                    System.exit(0);
            }
        }
    }
}
