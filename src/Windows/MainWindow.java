package Windows;

import Games.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {
    private GameWindow gameWindow;

    public final static int SCREEN_WIDTH = 900;
    public final static int SCREEN_HEIGHT = 700;

    public final static Color BG_COLOR = new Color(108, 148, 238);
    public final static Color BTN_COLOR = new Color(174, 77, 36);
    public final static Color HIGHLIGHT_COLOR = new Color(234, 189, 177);
    private final static File FONT_FILE = new File("res/ARCADECLASSIC.TTF");
    private final static Font FONT;

    static {
        try {
            FONT = Font.createFont(Font.TRUETYPE_FONT, FONT_FILE);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final static int PADDING = 60;

    public MainWindow() {
        setTitle("Select Difficulty");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT + 50);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 50, 50));
        panel.setBackground(BG_COLOR);
        panel.setOpaque(true);
        panel.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
        add(panel);

        JLabel label = new JLabel("Select Difficulty");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.white);

        Font headlineFont = FONT.deriveFont(Font.PLAIN, 60);
        label.setFont(headlineFont);

        panel.add(label);

        JButton easyBtn = createBtn("Easy");
        panel.add(easyBtn);

        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGame(0);
            }
        });

        JButton mediumBtn = createBtn("Medium");
        panel.add(mediumBtn);

        mediumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGame(1);
            }
        });

        JButton hardBtn = createBtn("Hard");
        panel.add(hardBtn);

        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGame(2);
            }
        });
    }

    private void createGame(int difficulty) {
        Game game;

        if (difficulty == 0) {
            game = new EasyGame(SCREEN_WIDTH, SCREEN_HEIGHT);
        } else if (difficulty == 1) {
            game = new MediumGame(SCREEN_WIDTH, SCREEN_HEIGHT);
        } else {
            game = new HardGame(SCREEN_WIDTH, SCREEN_HEIGHT);
        }

        gameWindow = new GameWindow(MainWindow.this, game);

        setVisible(false);
    }

    private JButton createBtn(String text) {
        JButton btn = new JButton(text);

        btn.setBackground(BTN_COLOR);
        btn.setForeground(HIGHLIGHT_COLOR);

        btn.setOpaque(true);

        int borderThickness = 50;
        Border border = new CompoundBorder(
                new BevelBorder(BevelBorder.RAISED, HIGHLIGHT_COLOR, Color.black),
                new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness)
        );

        btn.setBorder(border);

        Font btnFont = FONT.deriveFont(Font.BOLD, 40);
        btn.setFont(btnFont);

        return btn;
    }

    public void showWindow() {
        Window[] windows = Window.getWindows();

        for (Window window : windows) {
            if (window instanceof JFrame && ((JFrame) window).getTitle().equals("Mario Game")) {
                window.dispose();
            }
        }

        setVisible(true);

        gameWindow.gameController.pause();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
