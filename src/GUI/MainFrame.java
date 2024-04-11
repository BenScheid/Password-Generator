package GUI;
import main.PasswordGenerator;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class MainFrame extends javax.swing.JFrame {
    private PasswordGenerator pGen = new PasswordGenerator();
    public MainFrame() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lengthTextField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        outputLabel = new javax.swing.JLabel();
        generateLabel = new javax.swing.JLabel();
        lengthLabel = new javax.swing.JLabel();
        checkLabel = new javax.swing.JLabel();
        checkTextField = new javax.swing.JTextField();
        confirm2Button = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        copyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        confirmButton.setText("Confirm");
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmButtonMouseReleased(evt);
            }
        });

        generateLabel.setText("Generate a password:");

        lengthLabel.setText("Enter Length (0 for random):");

        checkLabel.setText("Check your passwords strength:");

        confirm2Button.setText("Confirm");
        confirm2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirm2ButtonMouseReleased(evt);
            }
        });

        copyButton.setText("Copy");
        copyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                copyButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(outputLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lengthLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(generateLabel)
                            .addComponent(checkLabel)
                            .addComponent(checkTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmButton)
                            .addComponent(copyButton)
                            .addComponent(confirm2Button))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generateLabel)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lengthLabel)
                        .addComponent(lengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmButton)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkLabel)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm2Button))
                .addGap(18, 18, 18)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String value = "";
    
    private void confirmButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseReleased
        try{
            int length = Integer.valueOf(lengthTextField.getText());
            value = pGen.generate(length);
            if (pGen.TOOLONG == false)outputLabel.setText(String.valueOf(value));
            else outputLabel.setText("Error: Maximum length is 350 characters!");
        }
        catch(NumberFormatException e){
            outputLabel.setText("Error: Not a number!");
        }
    }//GEN-LAST:event_confirmButtonMouseReleased

    private void confirm2ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm2ButtonMouseReleased
        String input = String.valueOf(checkTextField.getText());
        int value2 = pGen.checkStrength(input);
        if(value2 <= 2) resultLabel.setText("Your password is quite weak, consider making a new one using the passwordgenerator above!");
        else if (value2 <= 4) resultLabel.setText("Your password could be stronger, maybe consider a new and better one!");
        else if (value2 <= 6) resultLabel.setText("Your password is pretty good! You can keep using it!");
        else resultLabel.setText("Your password is perfect! You should keep using it!");
    }//GEN-LAST:event_confirm2ButtonMouseReleased

    private void copyButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonMouseReleased
        StringSelection stringSelection = new StringSelection(value);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_copyButtonMouseReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel checkLabel;
    private javax.swing.JTextField checkTextField;
    private javax.swing.JButton confirm2Button;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton copyButton;
    private javax.swing.JLabel generateLabel;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JTextField lengthTextField;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JLabel resultLabel;
    // End of variables declaration//GEN-END:variables
}
