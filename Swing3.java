package swing3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
public class Swing3 extends JFrame implements ActionListener{
JComboBox cb;
JLabel lb;
String items[] = {"Acer", "Compaq", "Dell", "Fujitsu", "Sony", "Toshiba"};
public Swing3(String title){
super(title);
setBounds(0, 0, 300, 170);
getContentPane().setLayout(null);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);

cb = new JComboBox();
for (int i=0; i<items.length; i++)
cb.addItem(items[i]);
cb.setLocation(30, 50);
cb.setSize(cb.getPreferredSize());
lb = new JLabel("Program dimulai.");
lb.setLocation(150, 50);
lb.setSize(lb.getPreferredSize());
cb.addActionListener(this);
getContentPane().add(cb);
getContentPane().add(lb);
setVisible(true);
setLocationRelativeTo(null);
}
public static void main(String[] args) { 
    Swing3 frame = new Swing3("Demo JCombobox");
} 
public void actionPerformed(ActionEvent e) { 
    if (e.getSource() == cb){ 
    String s = ""+ cb.getSelectedItem();
} 
}
}
