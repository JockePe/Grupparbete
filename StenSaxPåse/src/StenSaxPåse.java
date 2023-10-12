package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StenSaxPåse implements ActionListener {

    private JFrame frame;
    private JButton stenKnapp;
    private JButton påseKnapp;
    private JButton saxKnapp;

    public StenSaxPåse() {
        frame = new JFrame("Sten Sax Påse");
        stenKnapp = new JButton("Sten");
        påseKnapp = new JButton("Påse");
        saxKnapp = new JButton("Sax");

        createGUI();
    }

    private void createGUI() {
        frame.setLayout(null);

        stenKnapp.setBounds(50, 50, 100, 50);
        påseKnapp.setBounds(50, 120, 100, 50);
        saxKnapp.setBounds(50, 190, 100, 50);

        frame.add(stenKnapp);
        frame.add(påseKnapp);
        frame.add(saxKnapp);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        stenKnapp.addActionListener(this);
        påseKnapp.addActionListener(this);
        saxKnapp.addActionListener(this);

        frame.setVisible(true);
    }

    private void stenKnappsetBounds(int i, int j, int k, int l) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == saxKnapp || source == påseKnapp || source == saxKnapp) {
            String userChoice = ((JButton) source).getText();
            String computerChoice = generateComputerChoice();

            String result = vemVinner(userChoice, computerChoice);

            JOptionPane.showMessageDialog(null, "Du väljer: " + userChoice + "\nComputer chose: " + computerChoice + "\n" + result);
        }
    }

    private String generateComputerChoice() {
        String[] choices = {"Sten", "Påse", "Sax"};
        int randomIndex = (int) (Math.random() * choices.length);
        return choices[randomIndex];
    }

    private String vemVinner (String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Oavgjort!";
        } else if ((userChoice.equals("Sten") && computerChoice.equals("Sax"))
                || (userChoice.equals("Påse") && computerChoice.equals("Sten"))
                || (userChoice.equals("Sax") && computerChoice.equals("Påse"))) {
            return "Du van!";
        } else {
            return "Datorn Vinner!!";
        }}}

    
