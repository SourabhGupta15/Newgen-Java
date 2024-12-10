package practice;

public class DivisibleBySeven {
    public static void main(String[] args) {
        seven();
    }

    static void seven(){
        int a = 32;
        if(a % 7 == 0){
            System.out.println(a + " is divisible by 7.");
        } else{
            System.out.println(a + " is not divisible by 7.");
        }
    }
}
