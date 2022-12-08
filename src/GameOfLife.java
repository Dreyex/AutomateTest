import javax.swing.table.*;

//Look at ...
//M.F, 07-12-2022

public class GameOfLife extends AbstractTableModel
{
    //attributes
    private int width = 25;
    private int height = 25;
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
        updateGeneration();
    }

    //now multiple generations
    void calculateMultipleNewGeneration (int n, int delay)
    {
        for(int i = 0; i < n; i++)
        {
            calculateNewGeneration();
            try 
            {
                Thread.sleep(delay);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }

    //Reminder: this is called Overlaoding Methods
    void calculateMultipleNewGeneration(int n)
    {
        calculateMultipleNewGeneration(n, 0);
    }


    //write the second array into the first array
    void updateGeneration()
    {
        //Attention: This way only the reference in the storage gets updated
        //gameBoard = gameBoardNew;
        for(int i = 1; i <= height; i++)
        {
            for(int j = 1; j <= width; j++)
            {
                gameBoard[i][j] = gameBoardNew[i][j];
            }
        }
        fireTableDataChanged();
    }

    


    void initialize() //Example "Pending Clock"
    {
        gameBoard[1][3] = true; 
        gameBoard[2][1] = true; gameBoard[2][2] = true;
        gameBoard[3][3] = true; gameBoard[3][4] = true;
        gameBoard[4][2] = true;
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

    @Override
    public int getColumnCount() {
        // ähm... with/without border?
        return width;
    }

    @Override
    public int getRowCount() {
        // ähm... with/without border?
        return height;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(gameBoard[rowIndex][columnIndex])
        {
            return life;
        }
        else
        {
            return death;
        }
        
    }

    //row, col ... where has changed something
    // obj ... the "new" value, that got entered
    @Override
    public void setValueAt(Object val, int row, int col) 
    {
        if(val.equals(life))
        {
            gameBoard[row][col] = true;
        }
        else
        {
            gameBoard[row][col] = false;
        }
        // update the cell value in the view
        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int row, int col)
    {
        //With this all cells are editable
        return true;
    }

    //constructor
    public GameOfLife()
    {
        this.initialize();
    }
}
