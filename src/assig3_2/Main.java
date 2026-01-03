//Afik Ifrach - 314940081 , Shilat Maymon - 213249618
package assig3_2;

public class Main {

    public static void main (String[] args){
        GamePlay gamePlay=new GamePlay();

        Judge judge=new Judge(gamePlay);
        Gamer player1=new Gamer(gamePlay);
        Gamer player2=new Gamer(gamePlay);

        Thread tj=new Thread(judge);
        Thread t1=new Thread(player1);
        Thread t2=new Thread(player2);

        tj.start();
        t1.start();
        t2.start();

        try {
            t1.join();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        try {
            t2.join();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        tj.interrupt();

        if(player1.getScore()>player2.getScore()){
            System.out.println("player 1 wins");
        } else if (player1.getScore()<player2.getScore()) {
            System.out.println("player 2 wins");
        } else {
            System.out.println("tie");
        }
    }

}
