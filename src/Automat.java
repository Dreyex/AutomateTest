//Verallgemeinerung der Präsentation des GOL
//M.F, 9/12/2022

import javax.swing.table.*;

public abstract class Automat extends AbstractTableModel 
{
    
    //Eigenschaften


    //Methoden
    abstract void initialisiere();
    abstract void berechneNeueGeneration();
    
    //Nun auch mehrere
    void berechneMehrereGenerationen(int anzahl, int verzoegerung) 
    {
		Thread mehrfach = new Thread( new Runnable() 
        {
			public void run() 
            {
				for (int i=0; i < anzahl;i++) 
                {
					berechneNeueGeneration();
					try {
						Thread.sleep(verzoegerung);
					} catch (InterruptedException e) 
                    {
					}
				}	
			}
		});
		mehrfach.start();
	}
	// Zur Erinnerung: Überladen ... vgl. optionale Parameter
	void berechneMehrereGenerationen(int anzahl) 
    {
		berechneMehrereGenerationen(anzahl,0);
	}
}
