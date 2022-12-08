public class StartGOL 
{
    public static void main (String[] args)
    {
        //only for test purposes
        GameOfLife rofl = new GameOfLife();
        rofl.output();
        rofl.calculateNewGeneration();
        rofl.updateGeneration();
        rofl.output();
        rofl.calculateNewGeneration();
        rofl.updateGeneration();
        rofl.output();

        boolean[] test = new boolean[] {true,false,true};
        boolean[] test2 = new boolean[] {false,true,false};

        test = test2;
        for (boolean b : test) 
        {
            System.out.println(b);            
        }

    }    
}
