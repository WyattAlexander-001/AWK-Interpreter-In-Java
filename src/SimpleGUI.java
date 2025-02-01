import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class SimpleGUI {
    public static void main(String[] args) {
        // Try Nimbus look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        JFrame frame = new JFrame("AWK Interpreter Made In Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top panel with BoxLayout
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        // Row 1: Label, TextField, Browse button
        JPanel row1 = new JPanel(new BorderLayout(5, 5));
        JLabel fileLabel = new JLabel("Select AWK File:");
        fileLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JTextField filePathField = new JTextField();
        filePathField.setEditable(false);

        JButton browseButton = new JButton("Browse");
        browseButton.setFont(new Font("SansSerif", Font.PLAIN, 13));

        row1.add(fileLabel, BorderLayout.WEST);
        row1.add(filePathField, BorderLayout.CENTER);
        row1.add(browseButton, BorderLayout.EAST);

        // Row 2: Run button (right-aligned)
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton runButton = new JButton("Run");
        runButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        row2.add(runButton);

        // Add row1 and row2 to topPanel
        topPanel.add(row1);
        topPanel.add(Box.createVerticalStrut(5)); // spacing
        topPanel.add(row2);

        // Bottom (Center) panel: Output area
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Output",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 14),
                Color.BLACK
        ));
        scrollPane.setPreferredSize(new Dimension(580, 300));

        // Browse button action
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If awk_files is in the same folder where you run Java:
                // e.g. AWK-Interpreter-In-Java/awk_files
                JFileChooser fileChooser = new JFileChooser(new File("awk_files"));

                // If it's actually one folder up from where you run Java:
                // JFileChooser fileChooser = new JFileChooser(new File("../awk_files"));

                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    filePathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        // Run button action
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = filePathField.getText();
                if (!filePath.isEmpty()) {
                    try {
                        Process process = new ProcessBuilder("java", "-cp", "src", "Main", filePath).start();
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(process.getInputStream())
                        );
                        String line;
                        outputArea.setText(""); // clear output area
                        while ((line = reader.readLine()) != null) {
                            outputArea.append(line + "\n");
                        }
                    } catch (Exception ex) {
                        outputArea.setText("Error executing program: " + ex.getMessage());
                    }
                } else {
                    outputArea.setText("Please select a file first.");
                }
            }
        });

        // Add panels to mainPanel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
