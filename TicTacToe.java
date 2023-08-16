import java.util.*;
class Player{
    private String name;
    private char s;
    public Player(String name,char s){
        if(name!=null)
            this.name=name;
        if(s!='\0')
            this.s=s;
    }
    String getname(){
        return this.name;
    }
    char getsymbol(){
        return this.s;
    }
}
class Board{
    private char b[][]=new char[3][3];
    private char p1s,p2s,em=' ';
    public Board(char p1s,char p2s){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                b[i][j]=em;
        this.p1s=p1s;
        this.p2s=p2s;
    }
    void update(int i,int j,int num){
        if(num==1)
            b[i][j]=p1s;
        else
            b[i][j]=p2s;
    }
    void print(){
        System.out.println("____________________");
        for(int i=0;i<3;i++){
            System.out.print("||");
            for(int j=0;j<3;j++){
                System.out.print("  "+b[i][j]+"  ||");
            }
            System.out.println();
        }
    }
    int check(){
        char x=' ';
        for(int i=0;i<3;i++){
            if(b[i][0]==b[i][1] && b[i][1]==b[i][2]){
                x=b[i][0];
                break;
            }
            if(b[0][i]==b[1][i] && b[1][i]==b[2][i]){
                x=b[0][i];
                break;
            } 

        }
        if(b[0][0]==b[1][1] && b[1][1]==b[2][2]){
            x=b[1][1];
        }
        if(b[0][2]==b[1][1] && b[1][1]==b[2][0]){
            x=b[1][1];
        }
        if(x==p1s)
            return 1;
        if(x==p2s)
            return 2;
        return 0;
    }
    
boolean isfill(int i,int j){
        if(b[i][j]!=' ')
            return true;
        return false;
    }
}
public class TicTacToe{
    private Player p1,p2;
    private Board board;
    public static void main(String args[]){
        TicTacToe t=new TicTacToe();
        t.startgame();
    }
    void startgame(){
        Scanner sc=new Scanner(System.in);
        //input player 
        p1=take(1);
        p2=take(2);
        //craete board
        board=new Board(p1.getsymbol(),p2.getsymbol());
        //play game
        System.out.println("intitally the board is ");
        board.print();

        int n=0;
        while(n!=9){
            if(n%2==0){
                System.out.println(p1.getname()+"'s turn ");
                System.out.print("Enter coordinate : ");
                int i=sc.nextInt();
                int j=sc.nextInt();
                if(i>2 || i<0 || j>2 || j<0){
                    System.out.println("Please Enter Valid Co-ordinate");
                    continue;
                }
                if(board.isfill(i,j)){
                    System.out.println("This co-ordinate is already filled ");
                    System.out.println("Please re-enter your co-ordinate");
                    continue;
                }
                board.update(i,j,1);
            }else{
                System.out.println(p2.getname()+"'s turn ");
                System.out.print("Enter coordinate : ");
                int i=sc.nextInt();
                int j=sc.nextInt();
                if(i>2 || i<0 || j>2 || j<0){
                    System.out.println("Please Enter Valid Co-ordinate");
                    continue;
                }
                if(board.isfill(i,j)){
                    System.out.println("This co-ordinate is already filled ");
                    System.out.println("Please re-enter your co-ordinate");

                    continue;
                }
                board.update(i,j,2);
            }
            board.print();
            if(board.check()==1){
                System.out.println(p1.getname()+" Win ! ");
                break;
            }
            if(board.check()==2){
                System.out.println(p2.getname()+" Win ! ");
                break;
            }
            n++;
        }
        
    }
    Player take(int x){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Name of Player "+x+" : ");
        String name=sc.nextLine();
        System.out.print("Enter Symbol of Player "+x+" : ");
        char s=sc.next().charAt(0);
        Player p=new Player(name,s);
        return p;
    }
}