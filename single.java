package halma;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class single {
    int hp=0;
    int count=0;
    Halma hob;
    game_node itx;
    pawn pop, kl; 
    int i,j,u=0;
    ArrayList<pawn> q;
    static ArrayList<game_node> track;
    public single(game_node in)
    {
       hob = new Halma();
       q = new ArrayList<>();
       track = new ArrayList<>();
       itx= new game_node(in);
      itx.parent = null;                   
    }
    public int legalMoves(pawn ds, game_node it, int ind)
    {  
       int f=0;        
       game_node temp;
       i=ds.x;
       j=ds.y;
       q.add(ds);
       ds.vis[i][j]=1;       
       if(i>=0 && i<16 && j>=0 && j<16)
       {
       temp = new game_node(it);
       kl = new pawn(ds);
       //kl.path.add(new coordinate(i,j));
       if(i+1<16 && it.board[i+1][j].equals(".") && !inCamp(i+1,j,ds)) //1
       {   
           kl.x= i+1;
           kl.y = j; 
           kl.path.add(new coordinate(i+1,j));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i+1,j,ds))
             {               
              temp.board[i][j]=".";
              temp.board[i+1][j]=ds.color;                      
              if(ds.color.equals("W"))
               {
                 temp.white.set(ind, new pawn(kl));
                 temp.player = "BLACK";
               }
              else if(ds.color.equals("B"))
               {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
               }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp); 
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
             {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           System.out.println("coming");
          //if(hob.terminate(it)=="continue")
           //legalMoves(ds); 
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i+1,j,ds)))
             {
              temp.board[i][j]=".";
              temp.board[i+1][j]=ds.color;                      
              if(ds.color.equals("W"))
                {
                    temp.white.set(ind, new pawn(kl));
                    temp.player = "BLACK";
                }
              else if(ds.color.equals("B"))
                {
                    temp.black.set(ind,new pawn(kl));
                    temp.player = "WHITE";
                }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp); 
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           System.out.println("coming");
          //if(hob.terminate(it)=="continue")
           //legalMoves(ds); 
           f=1;
           }
           
        }
       //it = new game_node(it.parent);
       temp = new game_node(it);
       kl = new pawn(ds);
       kl.path.add(new coordinate(i,j));
       if(i-1>=0 && it.board[i-1][j].equals(".") && !inCamp(i-1,j,ds) ) //2
       {   
          kl.x= i-1;
           kl.y = j;
           kl.path.add(new coordinate(i-1,j));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i-1,j,ds))
           {
               temp.board[i][j]=".";
           temp.board[i-1][j]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp); 
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i-1,j,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i-1][j]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp); 
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }           
        }
       //it = new game_node(it.parent);
       temp = new game_node(it);
       kl = new pawn(ds);
       kl.path.add(new coordinate(i,j));
       if(j+1<16 && it.board[i][j+1].equals("." ) && !inCamp(i,j+1,ds)) //3
       {   
           kl.x= i;
           kl.y = j+1;
           kl.path.add(new coordinate(i,j+1));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i,j+1,ds))
           {
               temp.board[i][j]=".";
           temp.board[i][j+1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp); 
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i,j+1,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i][j+1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp); 
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }           
        }
      // it = new game_node(it.parent);
      temp = new game_node(it);
        kl = new pawn(ds);
        kl.path.add(new coordinate(i,j));
       if( j-1>=0 && it.board[i][j-1].equals(".") && !inCamp(i,j-1,ds)) //4
       {
         kl.x= i;
           kl.y = j-1;
           kl.path.add(new coordinate(i,j-1));
           temp.move = new pawn(kl);
           System.out.println("yes");           
           if(atHome(ds) && atHome(i,j-1,ds))
           {
               temp.board[i][j]=".";
           temp.board[i][j-1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i,j-1,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i][j-1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           
        }
      // it = new game_node(it.parent);
      temp = new game_node(it);
       kl = new pawn(ds);
       kl.path.add(new coordinate(i,j));
       if(i+1<16 && j+1<16 && it.board[i+1][j+1].equals(".") && !inCamp(i+1,j+1,ds) ) //5
       {           
           kl.x= i+1;
           kl.y = j+1;
           kl.path.add(new coordinate(i+1,j+1));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i+1,j+1,ds))
           {
               temp.board[i][j]=".";
           temp.board[i+1][j+1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i+1,j+1,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i+1][j+1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }           
        }
       //it = new game_node(it.parent);
       temp = new game_node(it);
        kl = new pawn(ds);
        kl.path.add(new coordinate(i,j));
       if(i+1<16 && j-1>=0 && it.board[i+1][j-1].equals(".")&& !inCamp(i+1,j-1,ds)  ) //6
       {           
          kl.x= i+1;
           kl.y = j-1;
           kl.path.add(new coordinate(i+1,j-1));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i+1,j-1,ds))
           {
               temp.board[i][j]=".";
           temp.board[i+1][j-1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i+1,j-1,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i+1][j-1]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }          
        }
       //it = new game_node(it.parent);
       temp = new game_node(it);
        kl = new pawn(ds);
        kl.path.add(new coordinate(i,j));
       if(i-1>=0 && j+1<16 && it.board[i-1][j+1].equals(".") && !inCamp(i-1,j+1,ds)) //7
       {         
          kl.x= i-1;
           kl.y = j+1;
           kl.path.add(new coordinate(i-1,j+1));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i-1,j+1,ds))
           {
               temp.board[i][j]=".";
           temp.board[i-1][j+1]=ds.color;          
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i-1,j+1,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i-1][j+1]=ds.color;          
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }           
        }
       //it = new game_node(it.parent);
       temp = new game_node(it);
        kl = new pawn(ds);
        kl.path.add(new coordinate(i,j));
       if(i-1>=0 && j-1>=0 && it.board[i-1][j-1].equals(".") && !inCamp(i-1,j-1,ds)) //8
       {   
          kl.x= i-1;
           kl.y = j-1;
           kl.path.add(new coordinate(i-1,j-1));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i-1,j-1,ds))
           {
               temp.board[i][j]=".";
           temp.board[i-1][j-1]=ds.color;
          if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }           
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }
           else if(!(atHome(ds) && !atHome(i+1,j,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i-1][j-1]=ds.color;
          if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }           
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           }           
        } 
       kl = new pawn(ds);       
       kl.path.add(new coordinate(i,j));
       do
       {         
       pop = q.remove(0);
       i=pop.x;
       j=pop.y;
       temp = new game_node(it);       
       if(i+2<16 && it.board[i+2][j].equals(".") && !it.board[i+1][j].equals(".") && kl.vis[i+2][j]!=1 && !inCamp(i+2,j,ds)) //11
       {                      
           kl.path.add(new coordinate(i+2,j));
           temp.move = new pawn(kl);
           kl.x= i+2;
              kl.y = j;
           if(atHome(ds) && atHome(i+2,j,ds))
           {              
              temp.board[i][j]=".";
              temp.board[i+2][j]=ds.color;           
                if(ds.color.equals("W"))
                  {
                   temp.white.set(ind,new pawn(kl) );
                   temp.player = "BLACK";
                  }
                else if(ds.color.equals("B"))
                  {
                   temp.black.set(ind,new pawn(kl));
                   temp.player = "WHITE";
                  }
              it.children.add(temp);
              temp.parent = it;
              track.add(temp);
              if(temp.terminate==1)//1
                 temp.utility= utility(temp);
              else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
               }
              count++;
              f=1;
              q.add(new pawn(kl));
              kl.vis[i+2][j]=1;              
           }
           else if(!(atHome(ds) && !atHome(i+2,j,ds)))
           {              
              temp.board[i][j]=".";
              temp.board[i+2][j]=ds.color;           
              if(ds.color.equals("W"))
                {
                  temp.white.set(ind,new pawn(kl) );
                  temp.player = "BLACK";
                }
              else if(ds.color.equals("B"))
                {
                  temp.black.set(ind,new pawn(kl));
                  temp.player = "WHITE";
                }
              it.children.add(temp);
              temp.parent = it;
              track.add(temp);
              if(temp.terminate==1)//1
                temp.utility= utility(temp); 
              else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
              count++;
              f=1;
              q.add(new pawn(kl));
              kl.vis[i+2][j]=1;              
           }           
           //System.out.println("Uti track"+ track.get(track.size()-1).utility);
        }
     //  it = new game_node(it.parent);
        temp = new game_node(it);        
       if(i-2>=0 && it.board[i-2][j].equals(".") && !it.board[i-1][j].equals(".") && kl.vis[i-2][j]!=1 && !inCamp(i-2,j,ds) ) //12
          { 
           kl.x= i-2;
              kl.y = j;
           kl.path.add(new coordinate(i-2,j));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i-2,j,ds))
           {
               temp.board[i][j]=".";
           temp.board[i-2][j]=ds.color;          
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i-2][j]=1;
           
           }
           else if(!(atHome(ds) && !atHome(i-2,j,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i-2][j]=ds.color;          
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i-2][j]=1;
           
           }           
        }
      // it = new game_node(it.parent);
      temp = new game_node(it);     
       if(j+2<16 && it.board[i][j+2].equals(".") && !it.board[i][j+1].equals(".") && kl.vis[i][j+2]!=1 && !inCamp(i,j+2,ds)) //13
       {           
              kl.x= i;
              kl.y = j+2;
           kl.path.add(new coordinate(i,j+2));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i,j+2,ds))
           {
               temp.board[i][j]=".";
           temp.board[i][j+2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i][j+2]=1;
          
           }
           else if(!(atHome(ds) && !atHome(i,j+2,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i][j+2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i][j+2]=1;           
           }           
        }
      // it = new game_node(it.parent);
      temp = new game_node(it);      
       if(j-2>=0 && it.board[i][j-2].equals(".") && !it.board[i][j-1].equals(".") && kl.vis[i][j-2]!=1 && !inCamp(i,j-2,ds) ) //14
       {          
            kl.x= i;
            kl.y = j-2;
           kl.path.add(new coordinate(i,j-2));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i,j-2,ds))
           {
               temp.board[i][j]=".";
           temp.board[i][j-2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
              {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i][j-2]=1;
          
           }
           else if(!(atHome(ds) && !atHome(i,j-2,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i][j-2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i][j-2]=1;           
           }           
        }
      // it = new game_node(it.parent);
      temp = new game_node(it);      
       if(i+2<16 && j+2<16 && it.board[i+2][j+2].equals(".") && !it.board[i+1][j+1].equals(".") && kl.vis[i+2][j+2]!=1 && !inCamp(i+2,j+2,ds)) //15
       {           
              kl.x= i+2;
              kl.y = j+2;
           kl.path.add(new coordinate(i+2,j+2));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i+2,j+2,ds))
           {
               temp.board[i][j]=".";
           temp.board[i+2][j+2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i+2][j+2]=1;           
           }
           else if(!(atHome(ds) && !atHome(i+2,j+2,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i+2][j+2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i+2][j+2]=1;           
           }           
        }      
      temp = new game_node(it);      
       if(i+2<16 && j-2>=0 && it.board[i+2][j-2].equals(".") && !it.board[i+1][j-1].equals(".") && kl.vis[i+2][j-2]!=1 && !inCamp(i+2,j-2,ds) ) //16
       {           
           kl.x= i+2;
           kl.y = j-2;
           kl.path.add(new coordinate(i+2,j-2));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i+2,j-2,ds))
           {
               temp.board[i][j]=".";
           temp.board[i+2][j-2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i+2][j-2]=1;
           
           }
           else if(!(atHome(ds) && !atHome(i+2,j-2,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i+2][j-2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i+2][j-2]=1;           
           }           
        }
      // it = new game_node(it.parent);
      temp = new game_node(it);      
       if(i-2>=0 && j+2<16 && it.board[i-2][j+2].equals(".") && !it.board[i-1][j+1].equals(".") && kl.vis[i-2][j+2]!=1 && !inCamp(i-2,j+2,ds)) //17
       {          
           kl.x= i-2;
              kl.y = j+2;
           kl.path.add(new coordinate(i-2,j+2));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i-2,j+2,ds))
           {
               temp.board[i][j]=".";
           temp.board[i-2][j+2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i-2][j+2]=1;          
           }
           else if(!(atHome(ds) && !atHome(i-2,j+2,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i-2][j+2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp);
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i-2][j+2]=1;
           
           }           
        }
    //   it = new game_node(it.parent);
       temp = new game_node(it);       
       if(i-2>=0 && j-2>=0 && it.board[i-2][j-2].equals(".") && !it.board[i-1][j-1].equals(".") && kl.vis[i-2][j-2]!=1 && !inCamp(i-2,j-2,ds)) //18 
       {                     
           kl.x= i-2;
              kl.y = j-2;
           kl.path.add(new coordinate(i-2,j-2));
           temp.move = new pawn(kl);
           if(atHome(ds) && atHome(i-2,j-2,ds))
           {
               temp.board[i][j]=".";
           temp.board[i-2][j-2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp); 
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i-2][j-2]=1;
          
           }
           else if(!(atHome(ds) && !atHome(i-2,j-2,ds)))
           {
               temp.board[i][j]=".";
           temp.board[i-2][j-2]=ds.color;           
           if(ds.color.equals("W"))
           {
               temp.white.set(ind, new pawn(kl));
               temp.player = "BLACK";
           }
           else if(ds.color.equals("B"))
           {
               temp.black.set(ind,new pawn(kl));
               temp.player = "WHITE";
           }
           it.children.add(temp); 
           temp.parent = it;
           track.add(temp);
           if(temp.terminate==1)//1
               temp.utility= utility(temp);
           else if(hob.terminate(temp).equals("stop"))
               {
               temp.terminate=1;  
               temp.utility= -utility(temp);
             }
           count++;
           f=1;
           q.add(new pawn(kl));
           kl.vis[i-2][j-2]=1;           
           }           
        }          
       }while(!q.isEmpty());     
    } 
       System.out.println("count="+count);
       return f;
    }
    public boolean inCamp(pawn p)
    {
        if(p.color.equals("W"))
        {                    
        for(int i=15;i>10;i--)
        {
            for(int j=15;j>10;j--)
            {
                if((i==15 || i==14) || (i==13 && j>11) || (i==12 && j>12) || (i==11 && j>13))
                    if(p.x==i && p.y==j)
                       return true;                                                    
            }
        }
        }
        else if(p.color.equals("B"))
        {
            for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if((i==0 || i==1) || (i==2 && j<4) || (i==3 && j<3) || (i==4 && j<2))
                    if(p.x==i && p.y==j)
                       return true;                                                                           
            }
        }
        }
        return false;
    }
    public boolean inCamp(int x, int y, pawn p)
    {
        if(p.color.equals("W"))
        {                    
        for(int i=15;i>10;i--)
        {
            for(int j=15;j>10;j--)
            {
                if((i==15 || i==14) || (i==13 && j>11) || (i==12 && j>12) || (i==11 && j>13))
                    if(x==i && y==j)
                       return true;                                                    
            }
        }
        }
        else if(p.color.equals("B"))
        {
            for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if((i==0 || i==1) || (i==2 && j<4) || (i==3 && j<3) || (i==4 && j<2))
                    if(x==i && y==j)
                       return true;                                                                           
            }
        }
        }
        return false;
    }
    public boolean atHome (int x, int y, pawn p)
    {
        if(p.color.equals("B"))
        {                    
        for(int i=15;i>10;i--)
        {
            for(int j=15;j>10;j--)
            {
                if((i==15 || i==14) || (i==13 && j>11) || (i==12 && j>12) || (i==11 && j>13))
                    if(x==i && y==j)
                       return true;                                                    
            }
        }
        }
        else if(p.color.equals("W"))
        {
            for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if((i==0 || i==1) || (i==2 && j<4) || (i==3 && j<3) || (i==4 && j<2))
                    if(x==i && y==j)
                       return true;                                                                           
            }
        }
        }    
        return false;
    }
    public boolean atHome (pawn p)
    {
        if(p.color.equals("B"))
        {                    
        for(int i=15;i>10;i--)
        {
            for(int j=15;j>10;j--)
            {
                if((i==15 || i==14) || (i==13 && j>11) || (i==12 && j>12) || (i==11 && j>13))
                    if(p.x==i && p.y==j)
                       return true;                                                    
            }
        }
        }
        else if(p.color.equals("W"))
        {
            for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if((i==0 || i==1) || (i==2 && j<4) || (i==3 && j<3) || (i==4 && j<2))
                    if(p.x==i && p.y==j)
                       return true;                                                                           
            }
        }
        }    
        return false;
    }
   // public game_node tree_build(game_node gn, int level)
     public void tree_build(game_node gn, int level) throws IOException
    {
        
        int tr;     
        int flag=0;
        game_node local;       
        track.add(gn);      
        /*if(gn.terminate==1)//1
               gn.utility= utility(gn);*/
        
        local = track.remove(0); 
        if(hob.terminate(local).equals("continue"))
        {                  
                for(int p=0;p<19;p++)
                {                       
                  if(local.player.equals("BLACK"))
                    {
                     if(inCamp(local.black.get(p)))
                      {
                       local.level=1;
                       if(local.level==level)
                           local.terminate = 1;
                       tr = legalMoves(local.black.get(p),local,p);
                       local.terminate = 0;
                       if(tr!=0)
                         flag=1;
                      }
                    }
                  else if(local.player.equals("WHITE"))
                    {                                           
                     if(inCamp(local.white.get(p))==true)
                      {  
                       local.level=1; 
                       if(local.level==level)
                           local.terminate = 1;
                       tr = legalMoves(local.white.get(p),local,p); 
                       local.terminate = 0;
                       if(tr!=0)
                        flag=1;
                      }
                    }                  
                }
                if(flag!=1)
                {
                 for(int iq=0;iq<19;iq++)
                  {
                    if(local.player.equals("BLACK"))
                     {                     
                       local.level=1;
                       if(local.level==level)
                           local.terminate = 1;
                       legalMoves(local.black.get(iq),local,iq);
                       local.terminate = 0;                       
                     }
                    else if(local.player.equals("WHITE"))
                     {                                         
                       local.level=1;
                       if(local.level==level)
                           local.terminate = 1;
                       legalMoves(local.white.get(iq),local,iq);
                       local.terminate = 0;
                   }
                   
                 }
                }            
        } 
        else if(hob.terminate(local).equals("stop"))
        {
            local.utility= -utility(local);
            local.terminate=1;
        }
        System.out.println("size"+track.size());
        while(!track.isEmpty())        
        {
           local = track.remove(0);           
           if(local.level==level)
               break;
           if(hob.terminate(local).equals("continue")) 
           {
           flag=0;
           for(int pq=0;pq<19;pq++)
                {
                    if(local.player.equals("BLACK"))
                    {
                     if(inCamp(local.black.get(pq)))
                      {
                       local.level=1+local.parent.level;
                       if(local.level==level)
                           local.terminate = 1;
                       tr = legalMoves(local.black.get(pq),local,pq);
                       //local.terminate = 0;
                       if(tr!=0)
                         flag=1;
                      }
                    }
                    else if(local.player.equals("WHITE"))
                    {
                     if(inCamp(local.white.get(pq)))
                      {
                       local.level=1+local.parent.level;
                       if(local.level==level)
                           local.terminate = 1;
                       tr = legalMoves(local.white.get(pq),local,pq);
                       //local.terminate = 0;
                       if(tr!=0)
                         flag=1;
                      }
                    }                  
                }
                if(flag!=1)
                {
                 for(int pq=0;pq<19;pq++)
                  {
                   if(local.player.equals("WHITE"))
                   {                                        
                       local.level=1+local.parent.level;
                       if(local.level==level)
                           local.terminate = 1;
                       legalMoves(local.white.get(pq),local,pq);
                       //local.terminate = 0;
                   }
                   else if(local.player.equals("BLACK"))
                   {                                           
                       local.level=1+local.parent.level;
                       if(local.level==level)
                           local.terminate = 1;
                       legalMoves(local.black.get(pq),local,pq); 
                       //local.terminate = 0;
                   }
                 }
                } 
           }
           else if(hob.terminate(local).equals("stop"))
           {
               local.terminate=1;
               local.utility = -utility(local);
               break;
           }
        }
       // System.out.println("gn.terminate="+gn.terminate);
        System.out.println(gn.children.size()+"hi");
        for(int yi=0;yi<gn.children.size();yi++)
            for(int yj=0;yj<gn.children.get(yi).children.size();yj++)
            {
                System.out.println("u="+gn.children.get(yi).children.get(yj).utility+" ("+yi+","+yj+")");
                System.out.println("path size "+gn.children.get(yi).children.get(yj).move.path.size());
            }
        game_node ans = alpha_beta_search(gn);     
       print(ans);    
    }    
    public game_node alpha_beta_search(game_node g)
    {              
       double v = max_value(g,-Double.MAX_VALUE,Double.MAX_VALUE);                              
       for(int i=0;i<g.children.size();i++)
       {    
          if(v==g.children.get(i).utility)
              return g.children.get(i);
       } 
       System.out.println("returning null");
        return null;
    }    
    public double max_value(game_node g, double alpha, double beta)
    {                             
        if(g.terminate==1)
            {            
            return g.utility;
        }       
        double v=-Double.MAX_VALUE;
        System.out.println("yoohoo");
        for(int i=0;i<g.children.size();i++)
        {
            v = Math.max(v, min_value(g.children.get(i),alpha,beta));        
           if(v>=beta)
             return v;
        alpha= Math.max(alpha, v);
        }
        return v;
    }
    public double min_value(game_node g, double alpha, double beta)
    {        
        if(g.terminate==1)
        {            
            return g.utility;
        }
        Double v=Double.MAX_VALUE;
        for(int i=0;i<g.children.size();i++)
        {
         v = Math.min(v, max_value(g.children.get(i),alpha,beta));        
        if(v<=alpha)
            return v;
        beta= Math.min(beta, v);
        }
        return v;
    }
    public double utility(game_node g)
    {
        
       /*int  x, y;
        double dis=0.0;
        x = g.move.x;
        y = g.move.y;
        if(g.move.color.equals("W"))
         dis = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));        
        else 
         dis = Math.sqrt(Math.pow(x-15, 2)+Math.pow(y-15, 2));
         System.out.println("utility of "+x+","+y+"="+(-dis));
        g.utility = -dis;
        return -dis;*/       
        double dis=0;        
        if(itx.player.equals("WHITE"))
        {
         for(int qw=0;qw<19;qw++)
         {             
            dis = dis+Math.sqrt(Math.pow(g.white.get(qw).x, 2)+Math.pow(g.white.get(qw).y, 2));             
         }
        }
        else if(itx.player.equals("BLACK"))
        {
         for(int qw=0;qw<19;qw++)
         {             
            dis = dis+Math.sqrt(Math.pow((g.black.get(qw).x)-15, 2)+Math.pow((g.black.get(qw).y)-15, 2));             
         }         
        }
         //System.out.println("utility of "+x+","+y+"="+(-dis));
        g.utility = -dis;
        //System.out.println("dis="+-dis);
        return -dis;
    }
    public void print(game_node gn) throws IOException
    {
        int you;
        String iyu="";
        FileWriter outf = new FileWriter("output.txt");
        gn.move.path.remove(0);
        if(gn.move.path.size()==2)
        {
          if((gn.move.path.get(0).x-gn.move.path.get(1).x==0 && Math.abs(gn.move.path.get(0).y-gn.move.path.get(1).y)==1) || (gn.move.path.get(0).x-gn.move.path.get(1).x==1 && Math.abs(gn.move.path.get(0).y-gn.move.path.get(1).y)==0) )            
           {
            outf.write("E ");
            for (you=0;you<gn.move.path.size();you++) 
              {           
               iyu=iyu+gn.move.path.get(you).x+","+gn.move.path.get(you).y+" ";
              }  
          outf.write(iyu.trim());
           }
          else
           {
            outf.write("J ");
            for (you=0;you<gn.move.path.size();you++) 
            {               
              iyu=iyu+gn.move.path.get(you).x+","+gn.move.path.get(you).y+" ";
            }   
            outf.write(iyu.trim());
           }
        }
        else
        {             
        for (you=0;you<gn.move.path.size()-1;you++) 
          {                        
              iyu=iyu+"J "+gn.move.path.get(you).x+","+gn.move.path.get(you).y+" "+gn.move.path.get(you+1).x+","+gn.move.path.get(you+1).y+"\n";
          }    
        outf.write(iyu.trim());
        }
        outf.close();
    }
}
