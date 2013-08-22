/*
 * LekarzlDialog.java
 *
 * Created on 18 grudzie� 2006, 16:28
 */
package okl.jspacjent.guiswing;

/**
 *
 * @author  JS
 */
public class LekarzJDialog extends javax.swing.JDialog {
  
  /** A return status code - returned if Cancel button has been pressed */
  public static final int RET_CANCEL = 0;
  /** A return status code - returned if OK button has been pressed */
  public static final int RET_OK = 1;
  
  
  public void setLekarzPanel( LekarzJPanel lekarzPanel ) {
    this.lekarzPanel = lekarzPanel;
  }
  
  public LekarzJPanel getLekarzPanel() {
    return this.lekarzPanel;   
  }
  
  public LekarzJPanel getOrCreateLekarzPanel() {
    if ( getLekarzPanel() == null ) {
      return new LekarzJPanel();
    }
    else {
      return getLekarzPanel();
    }  
  }
  
  // Constructors
  
  /** Creates new form LekarzlDialog */
  public LekarzJDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    setLekarzPanel( new LekarzJPanel() );
    initComponents();
  }
  
   /** Creates new form LekarzlDialog */
  public LekarzJDialog(java.awt.Frame parent, 
                            boolean modal,
                            LekarzJPanel lekarzPanel) {
    super(parent, modal);
    setLekarzPanel( lekarzPanel );
    initComponents();
  }
  
  /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
  public int getReturnStatus() {
    return returnStatus;
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
  private void initComponents() {
    lekarzPanel = getOrCreateLekarzPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Lekarze");
    setName("dialogLekarz");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        closeDialog(evt);
      }
    });

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(0, 517, Short.MAX_VALUE)
      .add(lekarzPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(0, 332, Short.MAX_VALUE)
      .add(lekarzPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
    );
    pack();
  }// </editor-fold>//GEN-END:initComponents
      
  /** Closes the dialog */
  private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
    doClose(RET_CANCEL);
  }//GEN-LAST:event_closeDialog
  
  private void doClose(int retStatus) {    
    returnStatus = retStatus;
    setVisible(false);
    dispose();
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new LekarzJDialog(new javax.swing.JFrame(), true).setVisible(true);
      }
    });
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private okl.jspacjent.guiswing.LekarzJPanel lekarzPanel;
  // End of variables declaration//GEN-END:variables
  
  private int returnStatus = RET_CANCEL;
}
