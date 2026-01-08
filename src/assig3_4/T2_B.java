//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
package assig3_4;

public class T2_B implements Runnable {
    private final Coordinator c;

    public T2_B(Coordinator c){
        this.c=c;
    }

    private void B(){
        System.out.print("B");
    }

    @Override
    public void run(){
        while (true){
            synchronized (c){
                while (c.state!=Coordinator.State.B &&
                        c.state!=Coordinator.State.B_OR_C &&
                        c.state!= Coordinator.State.D_OR_B){
                    try {
                        c.wait();
                    } catch (InterruptedException e){
                        return;
                    }
                }
                if(c.state==Coordinator.State.D_OR_B){
                    c.state= Coordinator.State.B;
                }
                B();

                c.state= Coordinator.State.B_OR_C;
                c.notifyAll();
            }
        }
    }
}
