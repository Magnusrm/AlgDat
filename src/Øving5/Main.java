package Øving5;


import java.util.Date;
import java.util.HashMap;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        //OPPGAVE 1
        String[] navn = {"Almås Annabelle Solem", "Andersson William", "Andersson Vegard", "Andresen Sebastian Martin", "Aune Jostein Johansen", "Axell Christian", "Daniel Larsen",
                "Bakhmadov Magomed Khatujevitsj", "Braathen Mathias", "Bui Aria Thuy Dung", "Bø Halvor Fladsrud", "Christiansen Herman", "Dahl Magnus", "Dalseth Christian Mathias", "Debik Karol Jerzy",
                "Elvemo Sebastian Aanesland", "Fossland Ole-Henrik", "Frantzen Odd-Erik", "Fridheim Marius", "Fylling Johan-Henrik", "Garmann Ingelin", "Gram Hans-Jeiger", "Habeeb Khaled Mohammad",
                "Halvarsson Kevin Mentzoni", "Haugum Terje", "Helgeland Kevin Andre", "Hestnes Håkon Dalen", "Hjelle Sara", "Holt Eyvind Nikolai", "Hynne Sigurd", "Iversen Anders Hallem",
                "Jacobsen Sigurd Lø¸ite", "Jacobsen William Chakroun", "Johansen Aleksander", "Johansen Kristaver Birkeland", "Johansen Eivind Alfsvåg", "Kampenhå y Kristian", "Knutsen Yair Day",
                "Knutsen Mathias", "Koteng Markus Thomassen", "Kristoffersen Jonas", "Larsen Knut Johan", "Larsen Albert Ohrem", "Larsson, Øivind Haugerø", "Lervik Eivind Hestnes",
                "Li Jingyi", "Lilleeng Simon", "Martinsen Magnus Revheim", "Martinsen Herman Ryen", "Mediå Fredrik", "Mellemseter Michael", "Midttun Jonathan", "Moan Martin Andreas", "Monsen Fredrik",
                "Nicolausson Sander", "Nordseth Morten Nyang", "Nygård Marius", "Nystuen Ådne", "Opsahl Elisabeth Marie", "Paulshus Sindre Haugland", "Rad Saadat Ilia", "Ramberg Håvard Hammer", "Roll Erling",
                "Rondestvedt Trond Jacob", "Rø stgård Kim Richard", "Sandnes Martin", "Siiri Anette Olli", "Skaug Oscar Tideman Borgerud", "Stavseng Ådne Eide", "Strand Snorre Kristoffer", "Strø mhylden Ben Oscar",
                "Sundø y Erlend", "Søther Ane", "Sørlie Lars", "Teiler-Johnsen Mari", "Tengs Simen Sølevik", "Thomassen Sindre", "Thorkildsen Patrick", "Timdal Eivind Rui", "Tokvam Balder",
                "Tran Quan Nguyen", "Tverfjell Julie Isabelle Malmedal", "Ullah Mona", "Valen Ruben Solvang", "Valstadsve Øyvind", "Vatle Jan-Marius", "Vedøy Rune", "Vesterlid Ørjan Bostad",
                "Wangensteen Kim Anners", "Wichstrøm Brage", "Worren Magne", "Østtveit Bjørnar", "Øverland Sveinung", "Øvsthus Vebjørn Hansen", "Ådnanes Stian", "Aasvestad Jørgen"};

        int antLinjer = navn.length;
        antLinjer = (int) Math.floor((antLinjer/75) * 100);
        HashArray hashtabell = new HashArray(101);
        for (int i = 0; i < navn.length; i++) {
            if (hashtabell.allocate(navn[i]) != -1) {

            } else {
                System.out.println("Array full?: " + navn[i] + " " + i);
            }
        }

        System.out.println("Load factor: " + hashtabell.getLastFactor());
        System.out.println("Collisions: " + hashtabell.getNumberCollisions());
        System.out.println("Magnus Revheim Martinsen's position:: " + hashtabell.findPosition("Magnus Revheim Martinsen"));


        //OPPGAVE 2
        int lengde = 5000000;
        int[] tilfeldigTabell = genererTilfeldigTabell(lengde);
        int storrelse = (int)(lengde*1.25 +1);

        int antallGjK = 10;

        Date startTime;
        Date endTime;

        startTime = new Date();
        for(int i = 0; i < antallGjK; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for(int k = 0; k < lengde; k++) {
                hashMap.put(k, tilfeldigTabell[k]);
            }
        }
        endTime = new Date();
        System.out.println("HashMap: " + (endTime.getTime() - startTime.getTime())/(double)antallGjK);

        startTime = new Date();
        for(int j = 0; j < antallGjK; j++) {
            HashArrayIntegers hashtabellHeltall = new HashArrayIntegers(storrelse);
            for (int i = 0; i < tilfeldigTabell.length; i++) {
                // System.out.println(tilfeldigTabell[i]);
                hashtabellHeltall.allocate(tilfeldigTabell[i]);
            }
        }
        endTime = new Date();
        System.out.println("\n\nOppgave 2: \nMin heltallsHasjfunksjon: " + (endTime.getTime() - startTime.getTime())/(double)antallGjK);

    }

    private static int[] genererTilfeldigTabell(int lengde) {
        Random random = new Random();
        int[] tilfeldigTabell = new int[lengde];
        for (int i = 0; i < lengde; i++) {
            tilfeldigTabell[i] = random.nextInt() * Integer.MAX_VALUE;
        }
        return tilfeldigTabell;
    }

}//end class