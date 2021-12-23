import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int snakes;
    private int ladders;
    private square[][] board = new square[10][10];

    public Board(int snakes, int ladders) {
        this.snakes = snakes;
        this.ladders = ladders;

        int counter = 1;
        int ladderCounter = 0;
        int ladderPerRow = ladders / 10;
        int ladderPerRowCounter = 0;

        int snakesCounter = 0;
        int snakesPerRow = snakes / 10;
        int snakesPerRowCounter = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String type;
                int chooser = ThreadLocalRandom.current().nextInt(0, 3);

                if(chooser == 1){
                    type = "Snake";
                    snakesCounter++;
                    snakesPerRowCounter++;
                    if(snakesCounter > snakes)
                        type = "normal";
                    if(snakesPerRowCounter > snakesPerRow){
                        type = "normal";
                        snakesCounter--;
                    }
                }
                else if(chooser == 2){
                    type = "Ladder";
                        ladderCounter++;
                        ladderPerRowCounter++;
                        if(ladderCounter > ladders)
                            type = "normal";
                        if(ladderPerRowCounter > ladderPerRow){
                            type = "normal";
                            ladderCounter--;
                        }
                }
                else{
                    type = "normal";
                }


                board[i][j] = new square(type, counter);
                counter++;
            }
            ladderPerRowCounter = 0;
            snakesPerRowCounter = 0;
        }
    }


    public void drawBoardConsole(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                square square = board[i][j];
                if(square.getType() == "Snake") {
                    System.out.print("$");
                }
                else if(square.getType() == "Ladder") {
                    System.out.print("H");
                }
                else{
                    System.out.print("#");
                }
            }
            System.out.print("\n");
        }
    }
}
