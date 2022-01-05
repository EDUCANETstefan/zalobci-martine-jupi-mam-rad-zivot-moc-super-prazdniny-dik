package Zalobci;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class ZalobciMain {


    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("C:\\Škola\\PRG\\zalobci\\Disputees\\Zalobci\\naklady.csv");


        ArrayList<Zalobce> list = new ArrayList<>();

        Scanner sc = new Scanner(text);


        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] seperated = line.split(",");
            System.out.println(line);
            Zalobce zalobce;

            if (seperated.length != 3) {

                String namePlus = line.substring(line.indexOf("\""), line.lastIndexOf("\""));

                zalobce = new Zalobce(Integer.parseInt(seperated[0]), namePlus, Double.parseDouble(seperated[3]));

            } else zalobce = new Zalobce(Integer.parseInt(seperated[0]), seperated[1], Double.parseDouble(seperated[2]));

            list.add(zalobce);

        }


        Map<String, Double> hm = new HashMap<>();
        String jmeno;
        double cena;

        for (Zalobce i : list) {
            jmeno = i.getNazev();
            cena = hm.get(jmeno) == null ? 0 : hm.get(jmeno);

            hm.put(jmeno, cena + i.getCastka());
        }

        String richest = " ";
        double currentMaxValuevalue = Integer.MIN_VALUE;
        for (Map.Entry<String, Double> entry : hm.entrySet()) {
            if (entry.getValue() > currentMaxValuevalue) {
                richest = entry.getKey();
                currentMaxValuevalue = entry.getValue();
            }
        }

        System.out.println("Prumer castek je " + Math.floor(getAvarage(list) / 100));
        System.out.println("Nejbohatsi je: jmeno: " + richest + " Hodnota sporu: " + currentMaxValuevalue);

    }


    public static Double getAvarage(ArrayList<Zalobce> zalobce) {
        int sum = 0;
        for (Zalobce z : zalobce) {
            sum += z.getCastka();
        }
        if(zalobce.size() == 0) return 0.0;
        return (double) sum / zalobce.size();
    }
}

