import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem3{
    
    static class fish_type implements Runnable {
        ArrayList<String> gender=new ArrayList<>(Arrays.asList("m","m","m","f","m","m","f","f","f","m","m","f","f","f","m","m","f","f","f","m"));   
        @Override
        public void run() {
            // TODO Auto-generated method stub
            synchronized(gender){
                // while(gender.size()>0){} exceeds index bound
                Random random=new Random();
                int pick1=random.nextInt(gender.size());
                int pick2=random.nextInt(gender.size());
                while(pick1==pick2){
                    pick2=random.nextInt(gender.size());
                }
                if ((gender.get(pick1)=="m" && gender.get(pick2)=="f")|| (gender.get(pick2)=="m" && gender.get(pick1)=="f")) {
                    int add1=random.nextInt(gender.size());
                    int add2=random.nextInt(gender.size());
                    gender.add(gender.get(add1));
                    gender.add(gender.get(add2));
                    System.out.println("number of fishes after two fishes are generated"+gender.size());
                }
                else if(gender.get(pick1)=="f" && gender.get(pick2)=="f"){
                    gender.remove(pick2);
                    System.out.println("number of fishes after two female fishes met and one was killed"+gender.size());
                }
                else if(gender.get(pick1)=="m" && gender.get(pick2)=="m"){
                    gender.remove(pick2);
                    gender.remove(pick1);
                    System.out.println("number of fishes left after two male fishes met and killed each other"+gender.size());
                }    
            }                      
        }
}    
    public static void main(String args[]) throws InterruptedException{
        Thread t1=new Thread(new fish_type());
        t1.start();
        Thread t2=new Thread(new fish_type());
        t2.start();
        Thread t3=new Thread(new fish_type());
        t3.start();
        Thread t4=new Thread(new fish_type());
        t4.start();
        Thread t5=new Thread(new fish_type());
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("exit");

    }
}