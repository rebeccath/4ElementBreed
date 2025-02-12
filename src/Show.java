import java.util.ArrayList;

public class Show {
    static void all(ArrayList<Creature> creatures) {
        System.out.println("Kreaturen Stufe 1 (gewöhnlich):\n");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step == 1) {
                System.out.print(i + ")");
                creatures.get(i).showCreature();
            }
        }
        System.out.println("Kreaturen Stufe 2 (spezial):\n");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step == 2) {
                System.out.print(i + ")");
                creatures.get(i).showCreature();
            }
        }
        System.out.println("Kreaturen Stufe 3 (episch):\n");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step == 3) {
                System.out.print(i + ")");
                creatures.get(i).showCreature();
            }
        }
        System.out.println("Kreaturen Stufe 4 (legendär):\n");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step == 4) {
                System.out.print(i + ")");
                creatures.get(i).showCreature();
            }
        }
    }


    static void names(ArrayList<Creature> creatures) {
        System.out.println("Stufe 1 (gewöhnlich):");
        int num = 0; //can be used to list all creatures with conscutive numbers (looks nices but indices are wrong to pick a creature)
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==1) {
                System.out.print(i + ") " + creatures.get(i).name + " (");
                if (creatures.get(i).sex) {
                    System.out.print("f");
                }
                else{
                    System.out.print("m");
                }
                System.out.println(")");
                num++;
            }
        }
        System.out.println("Stufe 2 (spezial):");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==2) {
                System.out.print(i + ") " + creatures.get(i).name + " (");
                if (creatures.get(i).sex) {
                    System.out.print("f");
                }
                else{
                    System.out.print("m");
                }
                System.out.println(")");
                num++;
            }
        }
        System.out.println("Stufe 3 (episch):");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==3) {
                System.out.print(i + ") " + creatures.get(i).name + " (");
                if (creatures.get(i).sex) {
                    System.out.print("f");
                }
                else{
                    System.out.print("m");
                }
                System.out.println(")");
                num++;
            }
        }
        System.out.println("Stufe 4 (legendär):");
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).step ==4) {
                System.out.print(i + ") " + creatures.get(i).name + " (");
                if (creatures.get(i).sex) {
                    System.out.print("f");
                }
                else{
                    System.out.print("m");
                }
                System.out.println(")");
                num++;
            }
        }
    }
}
