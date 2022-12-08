import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AutomateView extends JFrame
{
    //attributes
    JTable table;
    GameOfLife gol = new GameOfLife();
    //specific methods
    void save()
    {
        System.out.println("Save");
    }

    void load()
    {
        System.out.println("Load");
    }

    void newAutomate()
    {
        System.out.println("NewAutomate");
    }



    //constructor ... build window
    public AutomateView()
    {
        // The standard things for the frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new menu bar
        JMenuBar jmb = new JMenuBar();

        // Create a new menu
        JMenu jmFile = new JMenu("File");

        // Create some menu items
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiNew = new JMenuItem("New");

        //what is supposed to happen when clicked
        jmiOpen.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                load();
            }
        });
        jmiSave.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                save();
            }
        });
        jmiNew.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                newAutomate();
            }
        });
        // Add the menu items to the menu
        jmFile.add(jmiNew);
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);

        // Add the menu to the menu bar
        jmb.add(jmFile);

        // Add the menu bar to the frame
        setJMenuBar(jmb);

        table = new JTable(gol);
        table.setRowSelectionAllowed(false);
        JPanel buttons = new JPanel();
        JButton next1 = new JButton("Next Generation");
        JButton next2 = new JButton("Multiple Generations");
        buttons.add(next1);
        buttons.add(next2);

        next1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.out.println("Next generation");
                gol.calculateNewGeneration();

            }
        });
        next2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.out.println("Multiple generations");
                gol.calculateMultipleNewGeneration(10, 500);
            }
        });

        setLayout(new BorderLayout());
        //add "remaining" items
        add(table, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

        setSize(500, 500);
        // Display the frame
        setVisible(true);
    }

}
