import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by pappa on 2018-10-27.
 */

public class MyView extends JFrame {

    private MyView(){
        //Close window on 'X' press
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel labelName = new JLabel("Enter Name: ");
        JLabel labelDescription = new JLabel("Enter Password: ");
        JTextField textName = new JTextField(20);
        textName.setFocusable(false);
        textName.setText(System.getProperty("user.name"));
        JTextField passwordText = new JTextField(20);

        JPasswordField password = new JPasswordField(20);
        JButton buttonLogin = new JButton("Login");

        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelName, constraints);

        constraints.gridx = 1;
        newPanel.add(textName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelDescription, constraints);

        constraints.gridx = 1;
        newPanel.add(password, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        newPanel.add(buttonLogin, constraints);
        newPanel.setBackground(Color.ORANGE);

        password.requestFocusInWindow();

        buttonLogin.addActionListener(e -> {
            System.out.println("Button pressed");
            this.dispose();
        });
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enter Description"));

        // add the panel to this frame
        add(newPanel);

        pack();
        setLocationRelativeTo(null);


    }
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new MyView().setVisible(true));
    }





}
