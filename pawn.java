package halma;

import java.util.ArrayList;

public class pawn {
    
    int x,y;
    String color;
    ArrayList <coordinate> path;
    int[][] vis;
    public pawn(int x, int y, String color, ArrayList path)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.path = new ArrayList<>(path);
        vis = new int[16][16];
        for(int i=0;i<16;i++)
            for(int j=0;j<16;j++)
                vis[i][j]=0;
    }
    public pawn(pawn p)
    {
        x = p.x;
        y = p.y;
        color = p.color;
        path = new ArrayList<>(p.path);
        vis = new int[16][16];
        for(int i=0;i<16;i++)
            for(int j=0;j<16;j++)
                vis[i][j]=p.vis[i][j];
    }
    
}
