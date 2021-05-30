import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;


public class CSetupModel {
    private final PropertyChangeSupport Pcs = new PropertyChangeSupport(this);
    private int[] Inventory;
    private CShip[] PlacedShips;
    private int PlacedShipCount;
    private String SelectedShip;
    private int StartCell;
    private int[] PossiblePlacements;
    
    public CSetupModel(){
        //Schlachtschiffe, Kreuzer, Zerstörer, U-Boote
        Inventory = new int[]{1, 2, 3, 4};
        PlacedShips = new CShip[10];
        SelectedShip = "";
        StartCell = -1;
        PossiblePlacements = new int[]{-1, -1, -1, -1};
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
        Pcs.firePropertyChange("startCell", StartCell, startCell);
        StartCell = startCell;
        
        setPossiblePlacements(startCell);
    }

    public void setEndCell(int endCell) {
        boolean placeable = false;
        for(int possiblePlacement : PossiblePlacements){
            if(endCell == possiblePlacement){
                placeable = true;
                break;
            }
        }
        if(placeable){
            CShip[] oldPlacedShips = PlacedShips.clone();
            PlacedShips[PlacedShipCount++] = new CShip(StartCell, endCell);
            Pcs.firePropertyChange("placedShips", oldPlacedShips, PlacedShips);
            setStartCell(-1);
        }
    }
    
    private void setPossiblePlacements(int startCell){
        int[] oldPossiblePlacements = PossiblePlacements.clone();
        if(startCell != -1){
            int shipSize = getShipSize() - 1;
            int top = startCell - 10 * shipSize;
            if(top >= 0){
                PossiblePlacements[0] = top;
            }
            int bottom = startCell + 10 * shipSize;
            if(bottom < 100){
                PossiblePlacements[1] = bottom;
            }
            int right = startCell + shipSize;
            if(startCell % 10 + shipSize < 10){
                PossiblePlacements[2] = right;
            }
            int left = startCell - shipSize;
            if(startCell % 10 - shipSize > 0){
                PossiblePlacements[3] = left;
            }
        }else{
            PossiblePlacements = new int[]{-1, -1, -1, -1};
        }
        Pcs.firePropertyChange("possiblePlacements", oldPossiblePlacements, PossiblePlacements);
    }
    
    private int getShipSize(){
        if(SelectedShip == "U-Boot"){
            return 2;
        }
        if(SelectedShip == "Zerstörer"){
            return 3;
        }
        if(SelectedShip == "Kreuzer"){
            return 4;
        }
        if(SelectedShip == "Schlachtschiff"){
            return 5;
        }
        return 0;
    }
}
