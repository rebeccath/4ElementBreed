import java.util.ArrayList;

public class Show {
    static void all(ArrayList<CreatureStep1> creatures1, ArrayList<CreatureStep2> creatures2, ArrayList<CreatureStep3> creatures3, ArrayList<CreatureStep4> creatures4) {
        System.out.println("Creatures Stufe 1 (common):\n");
        for (int i = 0; i < creatures1.size(); i++) {
            System.out.print(i + ")");
            creatures1.get(i).ShowCreature();
        }
        System.out.println("Creatures Stufe 2 (special):\n");
        for (int i = 0; i < creatures2.size(); i++) {
            System.out.print(i + ")");
            creatures2.get(i).ShowCreature();
        }
        System.out.println("Creatures Stufe 3 (epic):\n");
        for (int i = 0; i < creatures3.size(); i++) {
            System.out.print(i + ")");
            creatures3.get(i).ShowCreature();
        }
        System.out.println("Creatures Stufe 4 (legendary):\n");
        for (int i = 0; i < creatures4.size(); i++) {
            System.out.print(i + ")");
            creatures3.get(i).ShowCreature();
        }
    }

    static void names(ArrayList<CreatureStep1> creatures1, ArrayList<CreatureStep2> creatures2, ArrayList<CreatureStep3> creatures3, ArrayList<CreatureStep4> creatures4) {
        System.out.println("Stufe 1:");
        int num = 0;
        for (int i = 0; i < creatures1.size(); i++) {
            System.out.println(num + ") " + creatures1.get(i).name);
            num++;
        }
        System.out.println("Stufe 2:");
        for (int i = 0; i < creatures2.size(); i++) {
            System.out.println(num + ") " + creatures2.get(i).name);
            num++;
        }
        System.out.println("Stufe 3:");
        for (int i = 0; i < creatures3.size(); i++) {
            System.out.println(num + ") " + creatures3.get(i).name);
            num++;
        }
        System.out.println("Stufe 4:");
        for (int i = 0; i < creatures4.size(); i++) {
            System.out.println(num + ") " + creatures4.get(i).name);
            num++;
        }
    }
}
