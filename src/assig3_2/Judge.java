//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
package assig3_2;

public class Judge implements Runnable {
    private GamePlay gamePlay;

    public Judge(GamePlay _gamePlay){
        this.gamePlay=_gamePlay;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            this.gamePlay.makeCoinAvail(false);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }

            this.gamePlay.makeCoinAvail(true);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}
