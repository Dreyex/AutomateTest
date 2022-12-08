import javax.swing.table.*;

public class MyTableTestModel extends AbstractTableModel
{
    String [][] content = { {"Beatles","Help"}, {"Beatwatt","Is That All"}, {"ABBA","Waterloo"} };

    @Override
    public int getRowCount() 
    {
        
        return 3;
    }

    @Override
    public int getColumnCount() 
    {
        
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        // 1. Try return: "ABC";
        // 2. Try return: Multiplicationtable
        /* if(rowIndex > 0 && columnIndex > 0)
        {
            return rowIndex*columnIndex;
        }
        else
        {
            return "#";
        } */
        
        return content[rowIndex][columnIndex];
        
    }
    
}
