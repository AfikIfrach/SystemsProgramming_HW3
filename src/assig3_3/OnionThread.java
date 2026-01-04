//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
package assig3_3;

public class OnionThread extends Thread {

    private SlicerMachine slicerMachine;

    public OnionThread(SlicerMachine slicerMachine){
        this.slicerMachine=slicerMachine;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            slicerMachine.addOneOnion();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e){
                interrupt();
                break;
            }
        }
    }

}
