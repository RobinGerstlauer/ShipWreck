import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class CSetupModel {
    private final PropertyChangeSupport Pcs = new PropertyChangeSupport(this);
    private int[] Inventory;
    private String SelectedShip;
    private int StartCell = -1;
    private int EndCell;
    
    public CSetupModel(){
        //Schlachtschiffe, Kreuzer, Zerstörer, U-Boote
        Inventory = new int[]{1, 2, 3, 4};
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.Pcs.addPropertyChangeListener(listener);
    }
    
    public void setSelectedShip(String shipType){
        Pcs.firePropertyChange("selectedShip", SelectedShip, shipType);
        SelectedShip = shipType;
    }
    
    public int getStartCell(){
        return StartCell;
    }
    
    public void setStartCell(int startCell){
        Pcs.firePropertyChange("selectedShip", StartCell, startCell);
        StartCell = startCell;
    }

    public int getEndCell() {
        return EndCell;
    }

    public void setEndCell(int endCell) {
        EndCell = endCell;
    }
}
