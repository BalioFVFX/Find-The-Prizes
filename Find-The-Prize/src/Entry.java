import java.util.Scanner;
public class Entry {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Environment environment = new Environment(10);
        Player player = new Player("First player");
        Prize[] prizes = environment.generatePrizes();
        int attempt = 0;
        System.out.print("Select searching speed 0(fast) - 1000(slow): ");
        int speed = input.nextInt();
        while(player.getNumOfPrizes() != prizes.length){
            attempt++;
            Thread.sleep(speed);
            player.move(environment, prizes);
            environment.draw(player, prizes);
        }
        System.out.println("It took you " + attempt + " attempts to find all the " + prizes.length + " prizes!");
        System.out.println("$ - Gives 0 to 100 points");
        System.out.println("O - Gives 0 points");
        System.out.println("Total points: " + player.getPoints());
    }
}
