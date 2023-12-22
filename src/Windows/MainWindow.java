package Windows;

import Games.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {
    private GameWindow gameWindow;

    public final static int SCREEN_WIDTH = 900;
    public final static int SCREEN_HEIGHT = 700;

    public final static Color BG_COLOR = new Color(63, 134, 218);

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
        label.setFont(new Font("Times New Roman", Font.BOLD, 60));
        label.setForeground(Color.white);
        panel.add(label);

        JButton easyBtn = new JButton("Easy");
        easyBtn.setBackground(Color.BLACK);
        easyBtn.setForeground(BG_COLOR);
        easyBtn.setOpaque(true);
        easyBtn.setBorderPainted(false);
        easyBtn.setFocusPainted(false);
        easyBtn.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(easyBtn);

        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionPerformed(0);
                setVisible(false);
            }
        });

        JButton mediumBtn = new JButton("Medium");
        mediumBtn.setBackground(Color.BLACK);
        mediumBtn.setForeground(BG_COLOR);
        mediumBtn.setOpaque(true);
        mediumBtn.setBorderPainted(false);
        mediumBtn.setFocusPainted(false);
        mediumBtn.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(mediumBtn);

        mediumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionPerformed(1);
                setVisible(false);
            }
        });

        JButton hardBtn = new JButton("Hard");
        hardBtn.setBackground(Color.BLACK);
        hardBtn.setForeground(BG_COLOR);
        hardBtn.setOpaque(true);
        hardBtn.setBorderPainted(false);
        hardBtn.setFocusPainted(false);
        hardBtn.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(hardBtn);

        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionPerformed(2);
                setVisible(false);
            }
        });
    }

    private void btnActionPerformed(int difficulty) {
        Game game;

        if (difficulty == 0) {
            game = new EasyGame(SCREEN_WIDTH, SCREEN_HEIGHT);
        } else if (difficulty == 1) {
            game = new MediumGame(SCREEN_WIDTH, SCREEN_HEIGHT);
        } else {
            game = new HardGame(SCREEN_WIDTH, SCREEN_HEIGHT);
        }

        gameWindow = new GameWindow(MainWindow.this, game);
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
