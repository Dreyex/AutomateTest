import javax.lang.model.util.ElementScanner14;

//Look at ...
//M.F, 07-12-2022

public class GameOfLife 
{
    //attributes
    private int width = 3;
    private int height = 3;
    // 1. Dimension ... line
    // 2. Dimension ...  column
    //Info: one line before and after, one column before and after as a border
    private boolean [][] gameBoard = new boolean[height+2][width+2];
    private boolean [][] gameBoardNew = new boolean[height+2][width+2];
    //for Output
    private String life = "#";
    private String death = "";


    //methods
    int numberNeighbours(int ln, int cl)  //add value of neighboring cells
    {
        return valueCell(ln-1, cl-1) + valueCell(ln-1, cl) + valueCell(ln-1, cl+1) 
             + valueCell(ln, cl-1)                         + valueCell(ln, cl+1) 
             + valueCell(ln+1, cl-1) + valueCell(ln+1, cl) + valueCell(ln+1, cl+1);
    } 

    //needed because board consists of boolean
    int valueCell(int ln, int cl)
    {
        if(gameBoard[ln][cl])
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    //Calculate game rules
    boolean newCell(int ln, int cl)
    {
        int neighbours = numberNeighbours(ln, cl);

        //3 possibilities - spawn, die, stay
        if(neighbours < 2 || neighbours > 3)
        {
            return false;
        }
        else if (neighbours == 3)
        {
            return true;
        }
        else
        {
           return gameBoard[ln][cl];
        }
    }

    //Info: Game Board reaches from line = 1 to height
    //                              column = 1 to width
    void calculateNewGeneration()
    {
        for(int i=1;i<=height;i++)      //line
        {
            for(int j=1;j<=width;j++)   //column
            {
                gameBoardNew[i][j] = newCell(i, j);
            }
        }
    }

    //write the second array into the first array
    void updateGeneration()
    {
        gameBoard = gameBoardNew;
    }


    void initialize() //Example "Pending Clock"
    {
        gameBoard[1][2] = true; 
        gameBoard[2][1] = true; gameBoard[2][3] = true;
        gameBoard[3][1] = true; gameBoard[3][2] = true;
        //gameBoard[4][2] = true;
    }

    void output()
    {
        for(int i = 1; i <= height; i++) 
        {
            System.out.println();
            for(int j = 1; j <= width; j++)
            {
                System.out.print(valueCell(i, j));
            }
        }
        System.out.println();
        System.out.println("--------------------------------");
    }

    //constructor
    public GameOfLife()
    {
        this.initialize();
    }
}
