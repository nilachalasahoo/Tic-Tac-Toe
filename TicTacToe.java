import java.util.*;
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