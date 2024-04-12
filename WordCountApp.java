import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountApp extends JFrame {

    private JTextArea textArea;
    private JLabel resultLabel;

    public WordCountApp() {
        setTitle("Word Count Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paragraph = textArea.getText();
                int wordCount = countWords(paragraph);
                resultLabel.setText("Word count: " + wordCount);
            }
        });

        resultLabel = new JLabel("Word count: 0");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(countButton);
        bottomPanel.add(resultLabel);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private int countWords(String paragraph) {
        String[] words = paragraph.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCountApp();
            }
        });
    }
}
