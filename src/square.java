import java.util.concurrent.ThreadLocalRandom;

public class square {
    private String type;
    private int number;
    private int exitSquare;

    public square(String type, int number) {
        this.type = type;
        this.number = number;

        if(type == "Snake"){
            exitSquare = ThreadLocalRandom.current().nextInt(1,number);
        }
        else if(type == "Ladder"){
            exitSquare = ThreadLocalRandom.current().nextInt(number,100);
        }
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
}
