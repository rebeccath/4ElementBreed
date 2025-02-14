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

    /**
     * Shows medels if won. careful, this art is simply taken from ASCII Art archive. not sure wether I can use it. !!!I have to replace it soon!!!
     *
     *Medals can be won in Boss fight
     *
     * @param m1 shows wether if medal 1 is won
     * @param m2 shows wether if medal 2 is won
     * @param m3 shows wether if medal 3 is won
     * @param m4 shows wether if medal 4 is won
     */
    static void medals(boolean m1, boolean m2, boolean m3, boolean m4) {
        if (m1) {
            System.out.println("  _______\n" +
                    " |       |\n" +
                    "(| BOSS1 |)\n" +
                    " |       |\n" +
                    "  \\     /\n" +
                    "   `---'\n" +
                    "   _|_|_");
        }
        if (m2) {
            System.out.println("     _______________\n" +
                    "    |@@@@|     |####|\n" +
                    "    |@@@@|     |####|\n" +
                    "    |@@@@|     |####|\n" +
                    "    \\@@@@|     |####/\n" +
                    "     \\@@@|     |###/\n" +
                    "      `@@|_____|##'\n" +
                    "           (O)\n" +
                    "        .-'''''-.\n" +
                    "      .'  * * *  `.\n" +
                    "     :  *       *  :\n" +
                    "    : ~ B O S S   ~ :\n" +
                    "    : ~ N O 2     ~ :\n" +
                    "     :  *       *  :\n" +
                    "      `.  * * *  .'\n" +
                    "        `-.....-'");
        }
        if (m3) {
            System.out.println("  _______________\n" +
                    "    |@@@@|     |####|\n" +
                    "    |@@@@|     |####|\n" +
                    "    |@@@@|     |####|\n" +
                    "    \\@@@@|     |####/\n" +
                    "     \\@@@|     |###/\n" +
                    "      `@@|_____|##'\n" +
                    "           (O)\n" +
                    "        .-'''''-.\n" +
                    "      .'  * * *  `.\n" +
                    "     :  *       *  :\n" +
                    "    : ~ B O S S   ~ :\n" +
                    "    : ~ N O 3     ~ :\n" +
                    "     :  *       *  :\n" +
                    "jgs   `.  * * *  .'\n" +
                    "        `-.....-'");
        }
        if (m4) {
            System.out.println("                                  ___________\n" +
                    "                             .---'::'        `---.\n" +
                    "                            (::::::'              )\n" +
                    "                            |`-----._______.-----'|\n" +
                    "                            |              :::::::|\n" +
                    "                           .|               ::::::!-.\n" +
                    "                           \\|               :::::/|/\n" +
                    "                            |               ::::::|\n" +
                    "                            | Final Boss         :|\n" +
                    "                            |                 ::::|\n" +
                    "                            |               ::::::|\n" +
                    "                            |              .::::::|\n" +
                    "                            J              :::::::F\n" +
                    "                             \\            :::::::/\n" +
                    "                              `.        .:::::::'\n" +
                    "                                `-._  .::::::-'\n" +
                    "____________________________________|  \"\"\"|\"_________________________________________\n" +
                    "                                    |  :::|\n" +
                    "                                    F   ::J\n" +
                    "                                   /     ::\\                                        \n" +
                    "                              __.-'      :::`-.__\n" +
                    "                             (_           ::::::_)\n" +
                    "                               `\"\"\"---------\"\"\"'");
        }
        if (m1 != true && m2 != true && m3 != true && m4 != true) {
            System.out.println("Du hast leider noch keine Medallien. Du kannst sie im Bosskampf gewinnen.");
        }
    }
}
