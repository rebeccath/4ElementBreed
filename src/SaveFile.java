import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFile {


    static void write1(int counter, ArrayList<CreatureStep1> cr1){
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("MyBeasts.csv", false));
        writer.append("Name, Stufe, HP, Armor, Angriff, Geschwindigkeit, typ, typ2, code, Geschlecht\n");
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

    static void write2(int counter, ArrayList<CreatureStep2> cr1){//heißt auf cr1 weil ist egal
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("MyBeasts.csv", true));
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

    static void write3(int counter, ArrayList<CreatureStep3> cr1){//heißt auf cr1 weil ist egal
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("MyBeasts.csv", true));
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
    static void write4(int counter, ArrayList<CreatureStep4> cr1){//heißt auf cr1 weil ist egal
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("MyBeasts.csv", true));
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
}
