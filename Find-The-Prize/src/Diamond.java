public class Diamond extends Prize {
    private char name = '$';
    public char getName(){
        return this.name;
    }
    public Diamond(int positionX, int positionY, int value){
        super(positionX, positionY, value);
    }
}
