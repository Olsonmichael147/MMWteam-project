package Battle_Folder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Battlefield screen with a board that has gaps in it.
 * Click a card to select it, click an empty slot to teleport it there.
 * Highlight colors show card state.
 */
public class BattlePanel extends JPanel {

    // 'L' = a real slot, '.' = a gap (nothing can go there).
    // Edit this map to change the shape of the board.
    private static final String[] LAYOUT = {
            "LLLLL",
            ".....",
            ".LLLL",
            ".....",
            "LLLLL",
            ".....",
            "O.L.Y",
            ".....",
            ".LLL.",
            ".....",
            "LLLL.",
            ".....",
            "LLLLL"
    };

    public static final int ROWS = LAYOUT.length;
    public static final int COLS = LAYOUT[0].length();

    static final Color CAN_ACT = new Color(60, 180, 75);
    static final Color SELECTED = new Color(240, 200, 0);
    static final Color IDLE = new Color(90, 90, 90);

    // null where the layout has a gap
    private final Slot[][] slots = new Slot[ROWS][COLS];
    private CardView selected;

    public BattlePanel() {
        setLayout(new GridLayout(ROWS, COLS, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(30, 30, 40));


        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (LAYOUT[r].charAt(c) == 'L') {
                    slots[r][c] = new Slot();
                    add(slots[r][c]);
                } else if (LAYOUT[r].charAt(c) == 'O'){
                    slots[r][c] = new Slot();
                    add(slots[r][c]);
                    placeDeck("Opponent Monster Deck", r, c, false);
                } else if (LAYOUT[r].charAt(c) == 'Y') {
                    slots[r][c] = new Slot();
                    add(slots[r][c]);
                    placeDeck("Your Monster Deck", r, c, true);
                }

                else {
                    JPanel gap = new JPanel();
                    gap.setOpaque(false);
                    gap.setName("gap");
                    add(gap);
                }
            }
        }
    }

    /** Place a card in a slot (used by the game logic / demo setup). */
    public void placeCard(int row, int col, String name, int hp, int atk, boolean canAct) {
        if (slots[row][col] == null) {
            throw new IllegalArgumentException("Row " + row + ", col " + col + " is a gap");
        }
        slots[row][col].setCard(new CardView(name, hp, atk, canAct));
    }
    private void placeDeck(String name, int row, int col, boolean blueDeck){
        slots[row][col].setCard(new DeckView(name));
    }

    private void select(CardView card) {
        if (selected != null) {
            selected.refreshBorder();
        }
        selected = card;
        card.refreshBorder();
    }

    private void moveSelectedTo(Slot target) {
        if (selected == null || target.getCard() != null) {
            return;
        }
        Slot from = (Slot) selected.getParent();
        from.clearCard();
        target.setCard(selected);
        CardView moved = selected;
        selected = null;
        moved.refreshBorder();
    }

    private class Slot extends JPanel {
        private DeckView card;

        Slot() {
            setLayout(new BorderLayout());
            setBackground(new Color(45, 45, 60));
            setBorder(BorderFactory.createLineBorder(new Color(70, 70, 90)));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    moveSelectedTo(Slot.this);
                }
            });
        }

        CardView getCard() {
            return (CardView) card;
        }

        void setCard(DeckView c) {
            card = c;
            add(c, BorderLayout.CENTER);
            revalidate();
            repaint();
        }

        void clearCard() {
            if (card != null) {
                remove(card);
                card = null;
            }
            revalidate();
            repaint();
        }
    }

    /** Visual for one card. */

    private class DeckView extends JPanel{

        public DeckView(String name){
            setLayout(new GridLayout(3, 1));
            setBackground(new Color(235, 225, 200));
            add(new JLabel(name, SwingConstants.CENTER));
        }
    }

    private class CardView extends DeckView {
        private final boolean canAct;

        CardView(String name, int hp, int atk, boolean canAct) {
            super(name);
            this.canAct = canAct;
            setLayout(new GridLayout(3, 1));
            setBackground(new Color(235, 225, 200));
            add(new JLabel(name, SwingConstants.CENTER));
            add(new JLabel("HP " + hp, SwingConstants.CENTER));
            add(new JLabel("ATK " + atk, SwingConstants.CENTER));
            refreshBorder();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    select(CardView.this);
                }
            });
        }

        void refreshBorder() {
            Color color = IDLE;
            if (this == selected) {
                color = SELECTED;
            } else if (canAct) {
                color = CAN_ACT;
            }
            setBorder(BorderFactory.createLineBorder(color, 4));
        }
    }
}