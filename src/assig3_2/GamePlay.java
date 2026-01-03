//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
package assig3_2;

public class GamePlay {
    private boolean coin_available_;
    private int rounds_counter_;

    public synchronized void makeCoinAvail(boolean val){
        coin_available_=val;
        if(coin_available_){
            notifyAll();
        }
    }

    public synchronized int flipCoin(){
        int flip;
        while(!coin_available_){
            System.out.println(Thread.currentThread().getName()+" is waiting for coin");
            try {
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return 0;
            }
        }
        System.out.println(Thread.currentThread().getName()+" is flipping coin");
        coin_available_=false;
        rounds_counter_++;
        flip=(int)(Math.random()*2);
        coin_available_=true;
        notifyAll();

        return flip;
    }

    public synchronized int getNumOfRounds(){
        return rounds_counter_;
    }
}
