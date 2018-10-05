package Øving5;

public class HashObject {
    private String value;
    private HashObject next;

    public HashObject(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public void setNext(HashObject newObj){

        if(next == null){
            this.next = newObj;
        } else {
            next.setNext(newObj);
        }
    }

    public HashObject getNext(){
        return next;
    }

    public boolean hasNext(){
        if(next == null){
            return false;
        } else {
            return true;
        }
    }
}
