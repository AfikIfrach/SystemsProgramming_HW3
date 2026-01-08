//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
//https://github.com/AfikIfrach/SystemsProgramming_HW3.git

package assig3_4;

public class Main {
    public static void main(String[] args){
        Coordinator c=new Coordinator();

        Thread t1=new Thread(new T1_A(c));
        Thread t2=new Thread(new T2_B(c));
        Thread t3=new Thread(new T3_C(c));
        Thread t4=new Thread(new T4_D(c));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
