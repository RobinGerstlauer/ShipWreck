
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;


public class CShipWrack {
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CShipWrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CShipWrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CShipWrack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CShipWrack.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CSetupModel m = new CSetupModel();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CSetupWindow v = new CSetupWindow();
                m.addPropertyChangeListener(v);
                CSetupController c = new CSetupController(v, m);
                v.setVisible(true);
            }
        });
    }
}
