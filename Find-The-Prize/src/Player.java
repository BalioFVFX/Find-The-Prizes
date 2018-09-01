public class Player {
    private String name;

    private int points;
    private int positionX;
    private int positionY;
    private int numOfPrizes = 0;

    public int getNumOfPrizes() {
        return this.numOfPrizes;
    }

    public int getPoints(){
        return this.points;
    }

    public void increasePointsBy(int points){
        this.points += points;
    }

    public void decreasePointsBy(int points){
        this.points -= points;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getName(){
        return name.charAt(0);
    }

    public void move(Environment environment, Prize[] prizes){
        environment.stepOnArea(this.positionX, this.positionY);
        while(true) {
            int randPos = (int)(Math.random() * 4);
            int newX = this.positionX;
            int newY = this.positionY;
            switch (randPos) {
                case 0:
                    newY--;
                    break;
                case 1:
                    newY++;
                    break;
                case 2:
                    newX--;
                    break;
                case 3:
                    newX++;
                    break;
                default:
                    break;
            }

            if (newX < 0 || newX > 9 || newY < 0 || newY > 9) {
                continue;
            } else {
                this.positionX = newX;
                this.positionY = newY;
                break;
            }
        }
        for (int i = 0; i < prizes.length; i++) {
            if(prizes[i].getPositionX() == this.positionX && prizes[i].getPositionY() == this.positionY && prizes[i].founded == false){
                prizes[i].founded = true;
                this.numOfPrizes++;
                this.points += prizes[i].getValue();
                break;
            }

        }
    }

    public Player(String name){
        this.name = name;
        this.points = 0;
    }
}
