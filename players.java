public class players {
    private String name;
    private char symbol;
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
