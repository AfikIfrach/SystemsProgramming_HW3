//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
//https://github.com/AfikIfrach/SystemsProgramming_HW3.git
package assig3_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please Type How Many Salads To Prepare:");
        Scanner scan = new Scanner(System.in);
        final int numOfSaladsToPrepare = scan.nextInt();
        System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

        // YOUR CODE HERE: use threads to prepare N salads (as the user requested)
        SlicerMachine slicerMachine=new SlicerMachine(numOfSaladsToPrepare);
        CucumbersThread c=new CucumbersThread(slicerMachine);
        OnionThread o=new OnionThread(slicerMachine);
        TomatoesThread t=new TomatoesThread(slicerMachine);
        SlicerThread s=new SlicerThread(slicerMachine);

        c.start();
        o.start();
        t.start();
        s.start();

        while (slicerMachine.getNumOfPreparedSalads()<numOfSaladsToPrepare){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }

        s.interrupt();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        c.interrupt();
        o.interrupt();
        t.interrupt();

        try {
            c.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        try {
            o.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        try {
            t.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        try {
            s.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }


        System.out.println("Done");
        scan.close();
    }

}
