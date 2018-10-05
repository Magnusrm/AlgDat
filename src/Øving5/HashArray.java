package Øving5;
public class HashArray {
    private final int ARRAY_SIZE;
    private final int prime = 1931;
    private HashObject[] hashArray;
    private int numberUsed = 0;
    private int numberCollisions = 0;

    public HashArray(int size){
        ARRAY_SIZE = size;
        hashArray = new HashObject[size];
    }


    public int convertToAscii(String text){
        int sum = 0;
        for(int i = 0; i<text.length(); i++){
            int help = text.charAt(i)*(127*(i+1));
            sum += help;
        }
        return sum;
    }


    //Hash
    private int hash(int key){
        return key%ARRAY_SIZE;
    }


    //Step
    private int step(int key){

        return key/(ARRAY_SIZE-1)+1;
    }


    private int probe(int hash, int step, int i){
        return (hash +step*i)%ARRAY_SIZE;
    }

    //Allocate place in array, return -1 the array is full.
    public int allocate(String name){
        int key = convertToAscii(name);
        int hash = hash(key);
        int step = step(key);
        HashObject ho = new HashObject(name);

        for(int i = 0; i<ARRAY_SIZE;i++){
            int allocatedPlace = probe(hash,step,i);
            if(hashArray[allocatedPlace] == null){
                hashArray[allocatedPlace] = ho;
                numberUsed++;
                return allocatedPlace;
            }else{
                System.out.println("Collision when allocating name: " + name + " collides with " + hashArray[allocatedPlace].getValue());
                numberCollisions++;
                hashArray[allocatedPlace].setNext(ho);
                return allocatedPlace;
            }
        }
        return -1;
    }


    public int findPosition(String name){
        int key = convertToAscii(name);
        int hash = hash(key);
        int step = step(key);
        HashObject temp;


        for(int i = 0; i<ARRAY_SIZE;i++){
            int position = probe(hash,step,i);
            if(hashArray[position] == null){
                return -1; //the name is not in the array
            } else {
                temp = hashArray[position];
                if(temp.getValue().equals(name)){
                    return position;
                }
                while(temp.hasNext()){
                    if(temp.getNext().getValue().equals(name)) {
                        return position;
                    } else {
                        temp = temp.getNext();
                    }
                }
            }
        }

        return -1;
    }


    public double getLastFactor(){

        return (double)numberUsed/ARRAY_SIZE;
    }


    public int getNumberCollisions(){
        return numberCollisions;
    }


}