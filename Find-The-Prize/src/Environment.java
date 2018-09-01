import java.util.Arrays;

public class Environment {
    private char[][] area;

    private void fillArea(){
        for (char[] row: area){
            Arrays.fill(row, '*');
        }
    }

    public void stepOnArea(int x, int y){
        area[y][x] = 'x';
    }

    public void draw(Player player, Prize[] prizes){
        System.out.println("------------------------------");
        reloadMap(prizes, player);
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                System.out.print("|" + this.area[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    private Prize getPrizeAt(int x, int y, Prize[] prizes){
        for (int i = 0; i < prizes.length; i++) {
            if(prizes[i].getPositionX() == x && prizes[i].getPositionY() == y) {
                return prizes[i];
            }
        }
        return null;
    }

    private boolean isEmpty(int x, int y, Prize[] prizes){
        for (int i = 0; i < prizes.length; i++) {
            if(prizes[i] == null){
                return true;
            }
            if(x == prizes[i].getPositionX() &&
                    y == prizes[i].getPositionY()){
                return false;
            }
        }
        return true;
    }

    public Prize[] generatePrizes(){
        Prize[] prizes = new Prize[5];
        int counter = 0;
        while(prizes[4] == null){
            int prizeType = (int)(Math.random() * 2);

            int prizePositionX = (int)(Math.random() * 9);
            int prizePositionY = (int)(Math.random() * 9);

            if(isEmpty(prizePositionX, prizePositionY, prizes) == false){
                continue;
            }

            // Diamond else Nothing
            if(prizeType == 0){
                int value = (int)(Math.random() * 101);
                prizes[counter] = new Diamond(prizePositionX, prizePositionY, value);
            }else{
                prizes[counter] = new Nothing(prizePositionX, prizePositionY, 0);
            }
            counter++;
        }

        return prizes;
    }

    public void reloadMap(Prize[] prizes, Player player){
        this.area[player.getPositionY()][player.getPositionX()] = player.getName();
        for (int i = 0; i < prizes.length; i++) {
            if(prizes[i].founded == true){
                this.area[prizes[i].getPositionY()][prizes[i].getPositionX()] = prizes[i].getName();
            }
        }

    }

    public Environment(int size){
        this.area = new char[size][size];
        fillArea();
    }
}
