
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Main_project extends JFrame 
{

    Container c;
    JPanel p;
    JLabel imgbackgreound;
    ImageIcon img, icon, img1;
    JProgressBar jb;
    JLabel lebal1, lebal2, lebal3;
    int i = 0, num = 0;

    Main_project() {
        c = this.getContentPane();
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("/Image/icon3.png"));
        setIconImage(icon.getImage());

        p = new JPanel();
        p.setBounds(0, 0, 1925, 1080);
        c.add(p);

        jb = new JProgressBar(0, 2000);
        jb.setValue(0);
        p.setBackground(Color.BLUE);

        img = new ImageIcon(getClass().getResource("/Image/background.png"));
        imgbackgreound = new JLabel(img);
        imgbackgreound.setBounds(0, 0, 1925, 1080);

        jb.setBounds(100, 830, 1700, 80);
        jb.setStringPainted(true);
        jb.setFont(new Font("Size & color", Font.BOLD, 40));
        jb.setBackground(Color.RED);
        jb.setForeground(Color.BLUE);
        jb.setString("LOADING...");
        imgbackgreound.add(jb);
        p.add(imgbackgreound);

        lebal1 = new JLabel();
        lebal1.setText("SNAKE");
        lebal1.setFont(new Font("Font & Size", Font.BOLD, 100));
        lebal1.setBounds(750, 150, 350, 80);
        lebal1.setForeground(Color.RED);
        imgbackgreound.add(lebal1);

        lebal2 = new JLabel();
        img1 = new ImageIcon(getClass().getResource("/Image/logo.png"));
        lebal2 = new JLabel(img1);
        lebal2.setBounds(750, 100, 350, 500);
        imgbackgreound.add(lebal2);

        lebal2 = new JLabel();
        lebal2.setText("LADDER");
        lebal2.setFont(new Font("Font & Size", Font.BOLD, 100));
        lebal2.setBounds(720, 150, 450, 750);
        lebal2.setForeground(Color.BLACK);
        imgbackgreound.add(lebal2);

        setTitle("Project Loading");
        setBounds(600, 200, 780, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void iterate() 
    {
        while (i <= 2050) 
        {
            jb.setValue(i);
            i = i + 30;
            try 
                {
                Thread.sleep(90);
                } 
            catch (Exception e) 
                {
                    
                }
        }

    }

    public static void main(String[] args) {

        Main_project frame1 = new Main_project();
        frame1.setVisible(true);
        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.iterate();
        Game_Board_Snake_Ladder frame = new Game_Board_Snake_Ladder();

    }
}