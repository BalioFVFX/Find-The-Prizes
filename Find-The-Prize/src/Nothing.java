public class Nothing extends Prize {
    public char name = '0';
    public char getName(){
        return this.name;
    }
    public Nothing(int positionX, int positionY, int value){
        super(positionX, positionY, value);
    }
}
