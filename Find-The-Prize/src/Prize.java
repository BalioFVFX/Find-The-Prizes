public class Prize {
    public int a = 10;
    private int value;
    private int positionX;
    private int positionY;
    public boolean founded = false;

    public char getName(){
        return 'P';
    }

    public int getPositionX(){
        return this.positionX;
    }

    public int getPositionY(){
        return this.positionY;
    }

    public void setPositionX(int newPositionX){
        this.positionX = newPositionX;
    }

    public void setPositionY(int newPositionY){
        this.positionY = newPositionY;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int newValue){
        this.value = newValue;
    }

    public Prize(){

    }

    public Prize(int positionX, int positionY, int value){
        this.positionX = positionX;
        this.positionY = positionY;
        this.value = value;
    }
}
