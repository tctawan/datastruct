public class MissingTile {
  public static void tileGrid(Grid board) {
      tileHelper(board,board.getPaintedCellX(),board.getPaintedCellY(),board.size()-1,0,
              board.size()-1,0);

  }

  public static void tileHelper(Grid board,int msX,int msY,int xTo,int xFrom, int yTo,int yFrom){

      int size = xTo-xFrom+1;
      int midX = (xTo+xFrom)/2;
      int midY  = (yTo+yFrom)/2;

      if(size== 1){
          return;
      }
      int dir = dirOfMissing(msX,msY,xTo,xFrom,yTo,yFrom);
      if(size == 2){
          board.setTile(msX,msY,dir);
      }
      else{
          if(dir != 0){
              tileHelper(board,midX+1,midY,xTo,midX+1,midY,yFrom);
          }else{
              board.setTile(midX+1,midY,0);
              tileHelper(board,msX,msY,xTo,midX+1,midY,yFrom);
          }
          if(dir != 1){
              tileHelper(board,midX+1,midY+1,xTo,midX+1,yTo,midY+1);
          }else {
              board.setTile(midX+1,midY+1,1);
              tileHelper(board,msX,msY,xTo,midX+1,yTo,midY+1);
          }
          if(dir != 2){
              tileHelper(board,midX,midY+1,midX,xFrom,yTo,midY+1);
          }else{
              board.setTile(midX,midY+1,2);
              tileHelper(board,msX,msY,midX,xFrom,yTo,midY+1);
          }
          if(dir != 3){
              tileHelper(board,midX,midY,midX,xFrom,midY,yFrom);
          }else{
              board.setTile(midX,midY,3);
              tileHelper(board,msX,msY,midX,xFrom,midY,yFrom);
          }
      }

  }

  public static int dirOfMissing(int msX,int msY,int xTo,int xFrom, int yTo, int yFrom){
      int dir;
      if(msX>(xFrom+xTo)/2){
          if(msY>(yFrom+yTo)/2){
              dir =1;
          }else {
              dir = 0;
          }
      }else{
          if(msY>(yFrom+yTo)/2){
              dir=2;
          }else {
              dir=3;
          }
      }
      return dir;
  }
}

