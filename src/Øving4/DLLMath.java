package Øving4;
import java.util.Random;

public class DLLMath {
    public static Random r = new Random();

    public static DLL dllAdd(DLL n1, DLL n2){
        int carry = 0;
        int sum = 0;
        DLL res = new DLL();
        DLL.Node digit1 = n1.tail;
        DLL.Node digit2 = n2.tail;
        int length = n1.length;
        if (n1.length < n2.length){
            digit1 = n2.tail;
            digit2 = n1.tail;
            length = n2.length;
            while (n1.length < length) n1.push(0);
        }
        while (n2.length < length) n2.push(0);

        while (digit1 != null || digit2 != null){
            sum = digit1.data + digit2.data + carry;
            if (sum > 9) {
                res.push((sum - 10));
                carry = 1;
            } else {
                res.push(sum);
                carry = 0;
            }
            digit1 = digit1.prev;
            digit2 = digit2.prev;
        }
        if (carry > 0) res.push(carry);
        return res;
    }

    public static DLL dllSub(DLL n1, DLL n2){
        int carry = 0;
        int sum = 0;
        DLL res = new DLL();
        DLL.Node digit1 = n1.tail;
        DLL.Node digit2 = n2.tail;
        int length = n1.length;
        boolean negAns = false;
        if (n1.length < n2.length || (n1.length == n2.length && n1.toString().compareTo(n2.toString()) < 0)){
            digit1 = n2.tail;
            digit2 = n1.tail;
            negAns = true;
            length = n2.length;
            while (n1.length < length) n1.push(0);
        }
        while (n2.length < length) n2.push(0);

        while (digit1.prev != null || digit2.prev != null){
            sum = digit1.data - digit2.data - carry;
            if (sum < 0) {
                res.push((sum + 10));
                carry = 1;
            } else {
                res.push(sum);
                carry = 0;
            }
            digit1 = digit1.prev;
            digit2 = digit2.prev;
        }
        sum = digit1.data - digit2.data - carry;
        DLL.Node n;
        if (negAns) {
            res.push(sum * -1);
            n = res.head;
            while (n.data == 0){
                n.next.data *= -1;
                n = n.next;
            }
        } else {
            res.push(sum);
        }

        return res;
    }

    public static DLL createRandomDLL(int length){
        DLL res = new DLL();
        for (int i = 0; i < length; i++){
            res.push(r.nextInt(10));
        }
        return res;
    }

    public static DLL createDLLFromString(String number){
        DLL res = new DLL();
        for (int i = 0; i< number.length(); i++){
            res.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        return res;
    }

    public static void main(String[] args) {


        DLL dll1 = createRandomDLL(20);
        DLL dll2 = createRandomDLL(20);

        DLL dll3 = createDLLFromString("90000");
        DLL dll4 = createDLLFromString("2000000");

       // System.out.println("\nList1: " + dll1.toString());
       // System.out.println("List2: " + dll2.toString());
        System.out.println("List3: " + dll3.toString());
        System.out.println("List4: " + dll4.toString());

       // System.out.println("List1 + List2 = " + dllAdd(dll1, dll2));
       // System.out.println("List3 + List4 = " + dllAdd(dll3, dll4));

       // System.out.println("List1 - List2 = " + dllSub(dll1, dll2));
        System.out.println("List3 - List4 = " + dllSub(dll3, dll4));
    }
}
