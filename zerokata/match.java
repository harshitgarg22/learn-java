import java.util.Scanner;

class match{
    private String[] pname = new String[2];
    private Scanner read = new Scanner(System.in);
    private int chance = 0;
    private int row, col;
    private table m2 = new table();
    private char charplay;
    private int numplayer;

    public void getname(int num){
        numplayer = num;
        System.out.println("Enter your name Player 1[X]: ");
        pname[0] = read.nextLine();
        if(numplayer == 2){
          System.out.println("Enter your name Player 2[O]: ");
          pname[1] = read.nextLine();
        }

        else {
           System.out.println("You are playing against HAL-9000[O]: ");
           pname[1] = "HAL-9000";
        }
    }

    public void cleanup(){
        chance = 0;
        m2.init();
        pname[0] = "";
        pname[1] = "";
    }

    public void play(){
        int winner, count = 0;
         do{
          System.out.print("It is the turn of ");
          if(chance!=2){
              System.out.print(pname[chance]);
          }

          else if(chance==2){
              System.out.print(pname[1]);
          }

          if(chance!=1){
              charplay = 'X';
              System.out.println("[X]");
              chance = 1;
          }
          else {
              charplay = 'O';
              System.out.println("[O]");
              chance = (numplayer==1) ? 2 : 0;
          }

          if(chance!=2){
              int check;
              do{
                  System.out.print("Enter the row: ");
                  row = read.nextInt();
                  System.out.print("Enter the column: ");
                  col = read.nextInt();
                  check = m2.set(row, col, charplay);
                  if(check!=0){
                      System.out.println("The element is already filled. Please enter the row and column again.");
                  }
              }while(check!=0);
          }


          if(chance==2){
              m2.set();
              chance = 0;
          }

          count++;
          winner = m2.checkwin();
          m2.printtable();
          if (winner == 1){
              System.out.println("Player 1 [" + charplay + "] " + pname[winner-1] + " won!\n");
              return;
          }
          else if (winner == 2){
              System.out.println("Player 2 [" + charplay + "] " + pname[winner-1] + " won!\n");
              return;
              }
          if(count==9){
              System.out.println("The match has been drawn!");
              return;
          }
        }while(winner==0);
    }

}

