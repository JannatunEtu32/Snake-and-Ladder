
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class My_Info extends JFrame{
    Container c;
    JPanel jp;
    JLabel imglabel;
    JLabel create,name1,Email,ID;
    ImageIcon img,icon;
    
    My_Info()
    {
        c = this.getContentPane();
        c.setLayout(null);
        icon = new ImageIcon(getClass().getResource("/Image/icon3.png"));
        setIconImage(icon.getImage());
        
        ImageIcon img = new ImageIcon(getClass().getResource("/Image/background.png"));
        imglabel = new JLabel(img);
        imglabel.setBounds(0, 0, 800, 700);
         c.add(imglabel);
        
        JLabel create = new JLabel();
        create.setText("C r e a t e d  B y");
        create.setFont(new Font("Font & Size", Font.BOLD+Font.ITALIC, 55));
        create.setBounds(180,50,500,80);
        create.setForeground(Color.BLUE);
        imglabel.add(create);
               
        
        name1 = new JLabel();
        name1.setText("Jannatun Nur Etu");
        name1.setFont(new Font("Font & Size", Font.BOLD, 40));
        name1.setBounds(220,150,350,90);
        name1.setForeground(Color.BLACK);
        imglabel.add(name1);
        
        
        ID = new JLabel();
        ID.setText("BFH2025009F");
        ID.setFont(new Font("Font & Size", Font.BOLD, 40));
        ID.setBounds(250,200,400,90);
        ID.setForeground(Color.RED);
        imglabel.add(ID);
        
         
        
        Email = new JLabel();
        Email.setText("Email : jannatun2515@student.nstu.edu.bd");
        Email.setFont(new Font("Font & Size", Font.BOLD, 25));
        Email.setBounds(135,400,600,80);
        Email.setForeground(Color.BLUE);
        imglabel.add(Email);
        
        setTitle("Project Creator Information");
        setBounds(600,200,780,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
    }
    
    public static void main(String[] args) {
        
        My_Info frame = new My_Info();
        
}

}