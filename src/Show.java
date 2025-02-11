import java.util.ArrayList;

public class Show {
    static void all(ArrayList<CreatureStep1> creatures1, ArrayList<CreatureStep2> creatures2, ArrayList<CreatureStep3> creatures3, ArrayList<CreatureStep4> creatures4) {
        System.out.println("Kreaturen Stufe 1 (gewöhnlich):\n");
        for (int i = 0; i < creatures1.size(); i++) {
            System.out.print(i + ")");
            creatures1.get(i).ShowCreature();
        }
        System.out.println("Kreaturen Stufe 2 (spezial):\n");
        for (int i = 0; i < creatures2.size(); i++) {
            System.out.print(i + ")");
            creatures2.get(i).ShowCreature();
        }
        System.out.println("Kreaturen Stufe 3 (episch):\n");
        for (int i = 0; i < creatures3.size(); i++) {
            System.out.print(i + ")");
            creatures3.get(i).ShowCreature();
        }
        System.out.println("Kreaturen Stufe 4 (legendär):\n");
        for (int i = 0; i < creatures4.size(); i++) {
            System.out.print(i + ")");
            creatures3.get(i).ShowCreature();
        }
    }


    static void names(ArrayList<Creature> creatures) {
        System.out.println("Stufe 1:");
        int num = 0; //can be used to list all creatures with conscutive numbers (looks nices but indices are wrong to pick a creature)
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==1) {
                System.out.println(i + ") " + creatures.get(i).name);
                num++;
            }
        }
        System.out.println("Stufe 2:");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==2) {
                System.out.println(i + ") " + creatures.get(i).name);
                num++;
            }
        }
        System.out.println("Stufe 3:");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==3) {
                System.out.println(i + ") " + creatures.get(i).name);
                num++;
            }
        }
        System.out.println("Stufe 4:");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==4) {
                System.out.println(i + ") " + creatures.get(i).name);
                num++;
            }
        }
    }
}
