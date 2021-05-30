
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JLabel;


public class CSetupController {
    private CSetupWindow View;
    private CSetupModel Model;
    public CSetupController(CSetupWindow view, CSetupModel model){
        View = view;
        Model = model;
        initController();
    }
    public void initController(){
        for(JLabel shipLabel : View.getInventoryShipLabels()){
            shipLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    selectShip(evt);
                }
            });
        }
        
        for(JLabel shipLabel : View.getGridButtons()){
            shipLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    selectCell(evt);
                }
            });
        }
    }
    
    private void selectShip(MouseEvent evt){
        Model.setSelectedShip(((JLabel)evt.getSource()).getText());
    }
    
    private void selectCell(MouseEvent event){
        int cell = Integer.parseInt(((JLabel)event.getSource()).getName());
        if(Model.getStartCell() == cell){
            Model.setStartCell(-1);
        }else if(Model.getStartCell() == -1){
            Model.setStartCell(cell);
        }else{
            Model.setEndCell(cell);
        }
    }
}
