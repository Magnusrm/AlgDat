package Øving5;

public class HashArrayIntegers {
    private final int ARRAY_SIZE;
    private final int prime = 1931;
    private int[] hashArray;
    private int numberUsed = 0;
    private int numberCollisions = 0;

    public HashArrayIntegers(int size){
        ARRAY_SIZE = size;
        hashArray = new int[size];
    }

    //hash
    private int hash(int key){
        return key%ARRAY_SIZE;
    }

    //Step
    private int step(int key){
        return key%(ARRAY_SIZE-1)+1;
    }

    private int probe(int hash, int i){
        return Math.abs(hash+i)%ARRAY_SIZE;
    }


    //Allocate place in array, return -1 the array is full.
    public int allocate(int key){
        int step = step(key);
        int hash = hash(key);

        for(int i = 0; i<ARRAY_SIZE;i++){
            int allocatedPlace = probe(step, i);
            if(allocatedPlace > -1){
                if(hashArray[allocatedPlace] == 0) {
                    hashArray[allocatedPlace] = key;
                }
                numberUsed++;
                return allocatedPlace;
            }else if(hashArray[hash] == 0){
                hashArray[hash] = key;
                numberUsed++;
            } else {
                numberCollisions++;
            }
        }
        return -1;
    }

    public int findNumber(int position) {
        return hashArray[position];
    }



    public int getNumberCollisions(){
        return numberCollisions;
    }
}