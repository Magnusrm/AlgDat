package Øving1;


import java.util.Random;

public class Aksjeprogram {

    public static Random random = new Random();

    public static int[][] generateData(int antallData){
        int[][] data = new int[2][antallData];
        for (int i = 0; i < antallData; i++){
            data[0][i] = random.nextInt(20) -10;
            data[1][i] = i +1;
        }
        return data;
    }

    public static int[] besteGevinst(int[][] testData){
        int tempBestBuy = -1;                               // 1
        int bestBuy = -1;                                   // 1
        int bestSell = -1;                                  // 1
        int differance = 0;                                 // 1
        int bestDifferance = 0;                             // 1
        int fortjenestedager = 0;                           // 1
        for (int i = 0; i < testData[0].length; i++){       // n + 1
            int data = testData[0][i];                      // 2n
            if (data >= 0 ) {                               // n
                if (fortjenestedager == 0) {                // n
                    tempBestBuy = testData[1][i];           // n
                    fortjenestedager++;                     // n
                    differance += data;                     // n
                }
                else {                                      // n
                    differance += data;                     // n
                }
            }
            else {                                          // n
                if (differance > bestDifferance){           // n
                    bestDifferance = differance;            // n
                    bestBuy = tempBestBuy;                  // n
                    bestSell = i;                           // n
                    fortjenestedager = 0;                   // n
                    differance = 0;                         // n
                } else {                                    // n
                    fortjenestedager = 0;                   // n
                    differance = 0;                         // n
                }
            }
        }
        int[] returnValues = {bestBuy, bestSell, bestDifferance};   // 1
        return returnValues;                                        // 1
    }

    public static void main(String[] args) {
        int antallDager = 100000000;
        int[][] newData = generateData(antallDager);
        /*for (int i = 0; i < antallDager; i++){
            System.out.println(newData[0][i] + "\n");
        }*/
        long startTime = System.currentTimeMillis();
        int[] array= besteGevinst(newData);
        long endTime = System.currentTimeMillis();
        System.out.print("Beste kjøpsdag: " + array[0] + ", beste salgsdato: " +
                                array[1] + ", gevinst: " + array[2] + "\n" +
                            "tidsbruk: " + (endTime - startTime));

    }
}