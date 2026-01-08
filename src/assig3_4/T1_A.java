//Afik Ifrach - 314940081 , Shilat Maymon - 213249618

package assig3_4;

public class T1_A implements Runnable {
    private final Coordinator c;

    public T1_A(Coordinator c){
        this.c=c;
    }

    private void A(){
        System.out.print("A");
    }

    @Override
    public void run(){
        synchronized (c){
            while (c.state==Coordinator.State.A && c.aCount<3){
                A();
                c.aCount++;

                if (c.aCount==3){
                    c.state=Coordinator.State.B;
                }
                c.notifyAll();
            }
        }
    }
}
