package view;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView {

    private final JFrame frame;
    private final JButton generateButton;
    private final JButton visualizeButton;
    private final JTextArea statusOutput;
    private final JLabel timeLabel;
    private final JLabel weatherAMIconLabel;
    private final JLabel weatherPMIconLabel;
    private final JLabel weatherAMTempLabel;
    private final JLabel weatherPMTempLabel;
    private final JLabel dayLabel;
    private final JMenu inspectionMenu;

    public GameView() {
        frame = new JFrame("Generation '04");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JMenuBar menuBar = new JMenuBar();

        // Inspection
        inspectionMenu = new JMenu("Inspection");
        JMenuItem freshmanItem = new JMenuItem("Freshman");
        JMenuItem sophomoresItem = new JMenuItem("Sophomore");
        JMenuItem juniorsItem = new JMenuItem("Junior");
        JMenuItem seniorsItem = new JMenuItem("Senior");
        JMenuItem staffItem = new JMenuItem("Staff");
        inspectionMenu.add(freshmanItem);
        inspectionMenu.add(sophomoresItem);
        inspectionMenu.add(juniorsItem);
        inspectionMenu.add(seniorsItem);
        inspectionMenu.add(staffItem);
        menuBar.add(inspectionMenu);
        frame.setJMenuBar(menuBar);
        inspectionMenu.setEnabled(false);

        generateButton = new JButton("Generate new school");
        visualizeButton = new JButton("Show school layout");
        visualizeButton.setEnabled(false);

        statusOutput = new JTextArea(20, 40);
        statusOutput.setEditable(false);

        DefaultCaret caret = (DefaultCaret) statusOutput.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        JScrollPane scrollPane = new JScrollPane(statusOutput);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(generateButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(visualizeButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // time label
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timeLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        // weather label
        // weather icons and labels
        weatherAMIconLabel = new JLabel();
        weatherAMIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weatherAMIconLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        weatherPMIconLabel = new JLabel();
        weatherPMIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weatherPMIconLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        weatherAMTempLabel = new JLabel();
        weatherAMTempLabel.setHorizontalAlignment(SwingConstants.CENTER);

        weatherPMTempLabel = new JLabel();
        weatherPMTempLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // day label
        dayLabel = new JLabel("Mon", SwingConstants.CENTER);
        dayLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // weather panel
        JPanel weatherPanel = new JPanel(new BorderLayout());
        weatherPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel weatherIconsPanel = new JPanel(new GridLayout(1, 2));
        JPanel amPanel = new JPanel(new BorderLayout());
        JLabel amLabel = new JLabel("AM", SwingConstants.CENTER);
        amPanel.add(amLabel, BorderLayout.NORTH);
        amPanel.add(weatherAMIconLabel, BorderLayout.CENTER);
        amPanel.add(weatherAMTempLabel, BorderLayout.SOUTH);
        weatherIconsPanel.add(amPanel);

        JPanel pmPanel = new JPanel(new BorderLayout());
        JLabel pmLabel = new JLabel("PM", SwingConstants.CENTER);
        pmPanel.add(pmLabel, BorderLayout.NORTH);
        pmPanel.add(weatherPMIconLabel, BorderLayout.CENTER);
        pmPanel.add(weatherPMTempLabel, BorderLayout.SOUTH);
        weatherIconsPanel.add(pmPanel);

        weatherPanel.add(dayLabel, BorderLayout.NORTH);
        weatherPanel.add(weatherIconsPanel, BorderLayout.CENTER);

        // main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(weatherPanel, BorderLayout.SOUTH);
        mainPanel.add(timeLabel, BorderLayout.EAST);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void addGenerateButtonListener(ActionListener listener) {
        generateButton.addActionListener(listener);
    }

    public void addVisualizeButtonListener(ActionListener listener) {
        visualizeButton.addActionListener(listener);
    }

    public void setVisualizeButtonEnabled(boolean enabled) {
        visualizeButton.setEnabled(enabled);
    }

    public void setInspectionMenuEnabled(boolean enabled) {
        inspectionMenu.setEnabled(enabled);
    }

    public void setVisualizeButtonVisible(boolean visible) {
        visualizeButton.setVisible(visible);
    }

    public void appendOutput(String message) {
        statusOutput.append(message + "\n");
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void updateTime(String time) {
        timeLabel.setText(time);
    }

    public void updateWeatherIcons(String amIconPath, String pmIconPath) {
        try {
            // Load AM icon
            java.net.URL amIconURL = getClass().getResource(amIconPath);
            if (amIconURL != null) {
                ImageIcon weatherAMIcon = new ImageIcon(amIconURL);
                weatherAMIconLabel.setIcon(weatherAMIcon);
                System.out.println("AM icon loaded successfully.");
            } else {
                System.err.println("AM Icon not found: " + amIconPath);
            }

            // Load PM icon
            java.net.URL pmIconURL = getClass().getResource(pmIconPath);
            if (pmIconURL != null) {
                ImageIcon weatherPMIcon = new ImageIcon(pmIconURL);
                weatherPMIconLabel.setIcon(weatherPMIcon);
                System.out.println("PM icon loaded successfully.");
            } else {
                System.err.println("PM Icon not found: " + pmIconPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateWeatherTemps(String amTemp, String pmTemp) {
        weatherAMTempLabel.setText(amTemp + "\u00B0" + " F");
        weatherPMTempLabel.setText(pmTemp + "\u00B0" + " F");
    }

    public void updateDayLabel(String day) {
        dayLabel.setText(day);
    }

    public void addInspectionMenuListener(ActionListener listener) {
        for (Component component : frame.getJMenuBar().getMenu(0).getMenuComponents()) {
            if (component instanceof JMenuItem) {
                ((JMenuItem) component).addActionListener(listener);
            }
        }
    }
}