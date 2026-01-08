//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
package assig3_4;

public class T4_D implements Runnable{
    private final Coordinator c;

    public T4_D(Coordinator c){
        this.c=c;
    }

    private void D(){
        System.out.print("D");
    }

    @Override
    public void run(){
        while (true){
            synchronized (c){
                while (c.state!=Coordinator.State.D &&
                        c.state!=Coordinator.State.D_OR_B){
                    try {
                        c.wait();
                    } catch (InterruptedException e){
                        return;
                    }
                }
                D();

                c.state= Coordinator.State.D_OR_B;
                c.notifyAll();
            }
        }
    }
}
