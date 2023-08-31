public class Player {
    private String name;
    private char symbol;
    public Player(String name2, char s) {
    }
    public void player(String name,char symbol){
        this.name=name;
        this.symbol=symbol;
    }
    public String getname(){
        return this.name;
    }
    public char getsymbol(){
        return this.symbol;
    }
}
