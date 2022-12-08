public class StartGOL 
{
    public static void main (String[] args)
    {
        //only for test purposes
        GameOfLife rofl = new GameOfLife();
        rofl.output();
        rofl.calculateNewGeneration();
        rofl.output();
        rofl.calculateNewGeneration();
        rofl.output();

    }    
}
