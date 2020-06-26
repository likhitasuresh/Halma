package halma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Halma {
    
    String[][] initial;
    ArrayList<pawn> black = new ArrayList<>();
    ArrayList<pawn> white = new ArrayList<>();
    game_node ty;      
       public String terminate(game_node y)
       {
        int b=0,w=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if((i==0 || i==1) || (i==2 && j<4) || (i==3 && j<3) || (i==4 && j<2))
                    if(y.board[i][j]=="B")
                       b++;
                    else if(y.board[i][j]=="W")
                        w++;                                                        
            }
        }
        if(b+w==19 && w!=0)
            return "stop";
        b=0; w=0;
        for(int i=15;i>10;i--)
        {
            for(int j=15;j>10;j--)
            {
                if((i==15 || i==14) || (i==13 && j>11) || (i==12 && j>12) || (i==11 && j>13))
                    if(y.board[i][j]=="B")
                       b++;
                    else if(y.board[i][j]=="W")
                        w++;                                   
            }
        }
        if(b+w==19 && b!=0)
            return "stop"; 
        return "continue";    
       }
       public void print(int d)
       {
           if(d==1)
               System.out.println("GAME OVER");
       }    
public static void main(String[] args) throws FileNotFoundException, IOException
    {          
       FileReader reader = new FileReader("src\\halma\\input.txt");
        BufferedReader in   = new BufferedReader(reader);
        String alg;
        double time;
        alg = in.readLine();                
                game_node ty = new game_node(in); 
                time = ty.time;
                single tu = new single(ty);
                if(time>3)
                 tu.tree_build(ty, 2);
                else
                 tu.tree_build(ty, 1);                                                                                          
    }      
}