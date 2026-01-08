//Afik Ifrach - 314940081 , Shilat Maymon - 213249618

package assig3_4;

public class T3_C implements Runnable {
    private final Coordinator c;

    public T3_C(Coordinator c){
        this.c=c;
    }

    private void c(){
        System.out.print("C");
    }

    @Override
    public void run(){
        while (true){
            synchronized (c){
                while (c.state!=Coordinator.State.B_OR_C &&
                        c.state!=Coordinator.State.C){
                    try {
                        c.wait();
                    } catch (InterruptedException e){
                        return;
                    }
                }
                if (c.state==Coordinator.State.B_OR_C){
                    c.state=Coordinator.State.C;
                    c.cCount=0;
                }
                c();
                c.cCount++;

                if (c.cCount==2){
                    c.state=Coordinator.State.D;
                    c.notifyAll();
                }
            }
        }
    }
}
