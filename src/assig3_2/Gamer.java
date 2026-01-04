//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
package assig3_2;

public class Gamer implements Runnable {
    private int goodFlipsCounter;
    private GamePlay gamePlay;

    public Gamer(GamePlay _gamePlay){
        this.gamePlay=_gamePlay;
        this.goodFlipsCounter=0;
    }

    public void play(){
        while(!Thread.currentThread().isInterrupted() && gamePlay.getNumOfRounds()<=10){
            if(gamePlay.flipCoin()==1){
                goodFlipsCounter++;
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public synchronized int getScore(){
        return goodFlipsCounter;
    }

    @Override
    public void run(){
        play();
    }
}
