/**
 * Created by pappa on 2018-10-27.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JFrameFocusTest extends JFrame {

    JDesktopPane desktopPane;

    public JFrameFocusTest() {
        setTitle("Main Frame");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        createFrame();
    }

    protected void createFrame() {
        JInternalFrameFocusTest iframe = new JInternalFrameFocusTest();
        iframe.setVisible(true);
        desktopPane.add(iframe);
        iframe.pack();
        try {
            iframe.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(false);
        JFrameFocusTest frame = new JFrameFocusTest();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] arg) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
} // end class JFrameFocusTest

class JInternalFrameFocusTest extends JInternalFrame implements ActionListener {

    JLabel firstNameLabel;
    JLabel middleNameLabel;
    JLabel lastNameLabel;

    JTextField firstNameTextField;
    JTextField middleNameTextField;
    JTextField lastNameTextField;

    JButton okButton;
    JButton cancelButton;

    public JInternalFrameFocusTest() {

        super("Internal Frame", true, true, true, true);

        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        firstNameLabel = new JLabel("First Name");
        middleNameLabel  = new JLabel("Middle Name");
        lastNameLabel = new JLabel("Last Name");

        firstNameTextField = new JTextField(5);
        middleNameTextField = new JTextField(5);
        lastNameTextField = new JTextField(5);

        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameTextField);
        inputPanel.add(middleNameLabel);
        inputPanel.add(middleNameTextField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameTextField);

        this.add(inputPanel,BorderLayout.NORTH);

        okButton = new JButton("Ok");
        okButton.setActionCommand("OK");
        okButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("CANCEL");
        cancelButton.addActionListener(this);

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        this.add(buttonPanel,BorderLayout.SOUTH);

        setSize(400, 100);
        setLocation(50, 50);
    }

    public void actionPerformed(ActionEvent e) {
        String Message = "";
        String actionCommand = e.getActionCommand();
        if (actionCommand.equalsIgnoreCase("OK")) {
            Message = ValidateForm();
            if (Message == "") {
                System.out.println("Everything is OK");
            }
            else
                //JOptionPane.showMessageDialog(this, Message, "Focus Test", JOptionPane.WARNING_MESSAGE);
                JOptionPane.showInternalMessageDialog(this, Message, "Focus Test", JOptionPane.WARNING_MESSAGE);
        }
    } // end actionPerformed

    private String ValidateForm() {

        String validateForm="";

        if (firstNameTextField.getText().equals("")) {
            validateForm = "Enter First Name";
            firstNameTextField.requestFocusInWindow();
        }
        else if (middleNameTextField.getText().equals("")) {
            validateForm = "Enter Middle Name";
            middleNameTextField.requestFocusInWindow();
        }
        else if (lastNameTextField.getText().equals("")) {
            validateForm = "Enter Last Name";
            lastNameTextField.requestFocusInWindow();
        }
        return validateForm;

    } // end Method ValidateForm

} // end class JInternalFrameFocusTest
