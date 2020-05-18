package jendelaa;
import javax.swing.JFrame;

public class swing {
    
    public static void main(String[] args) {
        
        // membuat objek jendela
        JFrame myWindow = new JFrame();
        
        // berikan judul pada jendela
        myWindow.setTitle("Jendela Program");
        
        // tentukan ukuran jendela
        myWindow.setSize(400, 200);
        
        // tampilkan jendela ke layar
        myWindow.setVisible(true);
        
    }
    
}
