import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveFile {


    static void write(int counter, ArrayList<Creature> cr1){
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("MyBeasts.csv", false));
        writer.append("Name, Stufe, HP, Rüstung, Angriff, Geschwindigkeit, typ, typ2, code, Geschlecht\n");
        for (int i = 0; i < counter; i++) {

            writer.append(String.valueOf(cr1.get(i).name)).append(",");
            writer.append(String.valueOf(cr1.get(i).step)).append(",");
            writer.append(String.valueOf(cr1.get(i).maxHealth)).append(",");
            writer.append(String.valueOf(cr1.get(i).armor)).append(",");
            writer.append(String.valueOf(cr1.get(i).attack)).append(",");
            writer.append(String.valueOf(cr1.get(i).speed)).append(",");
            writer.append(String.valueOf(cr1.get(i).type)).append(",");
            writer.append(String.valueOf(cr1.get(i).type2)).append(",");
            writer.append(String.valueOf(cr1.get(i).code)).append(",");
            writer.append(String.valueOf(cr1.get(i).sex)).append("\n");
        }
            writer.close();
            } catch (IOException e) {
                System.out.println("Fehler beim schreiben der Datei.");
            }
    }


    //This is the read function of another Programm of mine. I plan to fit it to this
    //Programm to be able to read previous Monsters.
    static ArrayList<Creature> read() throws IOException {
        ArrayList<Creature> creatures = new ArrayList<>();
        String helpline;
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("MyBeasts.csv"));
            helpline = reader.readLine(); //this reads the first line and then trows it away (it contains the titles)
            while ((helpline = reader.readLine()) != null) {
                creatures.add(new Creature());
                creatures.get(i).name = helpline.split(",")[0];
                creatures.get(i).step = Integer.parseInt(helpline.split(",")[1]);
                creatures.get(i).maxHealth = Integer.parseInt(helpline.split(",")[2]);
                creatures.get(i).armor = Float.parseFloat(helpline.split(",")[3]);
                creatures.get(i).attack = Integer.parseInt(helpline.split(",")[4]);
                creatures.get(i).speed = Float.parseFloat(helpline.split(",")[5]);
                creatures.get(i).type = helpline.split(",")[6];
                creatures.get(i).type2 = helpline.split(",")[7];
                creatures.get(i).code = helpline.split(",")[8];
                creatures.get(i).sex = Boolean.parseBoolean(helpline.split(",")[9]);
                i++;
            }
            reader.close();
            System.out.println("Alle Kreaturen eingelesen.\n\n");
        }
        catch (FileNotFoundException e) {
            System.out.println("\n*** Fehler! Datei nicht gefunden.***\n");
        }
        return creatures;
    }
}
