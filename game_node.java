package halma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class game_node {
    BufferedWriter writer;
    String player;
    int playa,level, terminate;
    double utility;
    float time;
    String board[][];
    ArrayList<pawn> black, white;   
    ArrayList<game_node> children  = new ArrayList<>();
    game_node parent;
    pawn move;
    
    public game_node (game_node r)
    {
        player = r.player;
        playa = r.playa;       
        level = r.level;
        time = r.time;
        board = new String[16][16];
       for(int y=0;y<16;y++)
       {           
           for(int u=0;u<16;u++)
         {
             board[y][u] = r.board[y][u];        
          }
        }
        black = new ArrayList<>(r.black);
        white = new ArrayList<>(r.white);
        children = new ArrayList<>(r.children);
        parent = r.parent;
        move = r.move;
        terminate = r.terminate;        
    }
    public game_node(BufferedReader in) throws IOException
    {
        terminate = 0;
        writer = new BufferedWriter(new FileWriter("output.txt"));       
        player = in.readLine();       
        if(player.equals("WHITE"))
            playa = 1;
        else
            playa = 0;
        time = Float.valueOf(in.readLine());
        board = new String[16][16];
        black = new ArrayList<>();
        white = new ArrayList<>();
        for(int i=0;i<16;i++)
        {
            String temp[] = new String[16];
            temp = in.readLine().split("");
            for(int j=0;j<16;j++)
            {                
            board[j][i] = temp[j];             
            if(temp[j].equals("W"))
            {             
             white.add(new pawn(j,i,"W",new ArrayList<>(Arrays.asList(new coordinate(j,i)))));             
            }
            else if(temp[j].equals("B"))
            {               
              black.add(new pawn(j,i,"B",new ArrayList<>(Arrays.asList(new coordinate(j,i)))));
            }
            }  
            //System.out.println(black.size()+" "+white.size());
        }     
        level = 0;
        parent = null;
    }
    
}

