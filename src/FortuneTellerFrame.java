import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    private JPanel mainPanel;
    //TOP PANEL
    private JPanel topPanel;
    private JLabel topLabel;
    private ImageIcon fortuneImage;

    //MIDDLE PANEL
    private JPanel midPanel;
    private JScrollPane midScroller;
    private JTextArea midTextArea;

    //BOTTOM PANEL
    private JPanel bottomPanel;
    private JButton displayOutputButton;
    private JButton quitButton;


    public FortuneTellerFrame(ArrayList<String> fortunes)
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4,1));
        createTopPanel();
        mainPanel.add(topPanel);
        createMidPanel();
        mainPanel.add(midPanel);
        createBottomPanel(fortunes);
        mainPanel.add(bottomPanel);

        add(mainPanel);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize((screenWidth / 4) * 3, screenHeight);
        setLocation(screenWidth / 8, screenHeight / 8);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createTopPanel()
    {
        topPanel = new JPanel();
        fortuneImage = new ImageIcon("src\\fortuneImage.jpg", "The severed head of Merlin located conveniently in the baggers' closet at Landen Kroger");
        Image image = fortuneImage.getImage();
        Image scalableImg = image.getScaledInstance(160, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        fortuneImage = new ImageIcon(scalableImg);
        topLabel = new JLabel("Merlin's Wonderful Fortune Telling Java Application", fortuneImage, JLabel.CENTER);
        topLabel.setVerticalTextPosition(JLabel.BOTTOM);
        topLabel.setHorizontalTextPosition(JLabel.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN,40));
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }
    private void createMidPanel()
    {
        midPanel = new JPanel();
        midPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        midTextArea = new JTextArea(10, 50);
        midTextArea.append("Your fortunes will appear here: ");
        midScroller = new JScrollPane(midTextArea);
        midPanel.add(midScroller);
    }
    int lastFortune = -1;
    private void createBottomPanel(ArrayList<String> fortunes)
    {

        bottomPanel = new JPanel();
        displayOutputButton = new JButton("Read My Fortune!");
        displayOutputButton.setFont(new Font("SansSerif", Font.ITALIC,20));
        displayOutputButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                int newFortune = 0;
                Boolean done = false;
                while (!done)
                {
                    newFortune = GenerateRandom(fortunes.size() - 1, 0);
                    if (newFortune != lastFortune)
                    {
                        done = true;
                    }
                }
                lastFortune = newFortune;
                String fortune = fortunes.get(newFortune);
                midTextArea.append("\n" + fortune);
            }
        });
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.ITALIC,20));
        quitButton.addActionListener(e -> System.exit(0));
        bottomPanel.add(displayOutputButton);
        bottomPanel.add(quitButton);
        bottomPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }
    private int GenerateRandom(int max, int min)
    {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }
}
