package Battle_Folder;

import javax.swing.*;

/** Test launcher: opens the battlefield with fake cards. Not part of the real app. */
public class Battle_UI_test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BattlePanel battle = new BattlePanel();


            JFrame frame = new JFrame("Battle Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(battle);
            frame.setSize(666, 1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}