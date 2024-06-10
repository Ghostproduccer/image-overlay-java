import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws Exception {
        File fileImageFG1 = new File("src\\3faba9374bc1c797af8a7655b43a302c.jpg");

        File fileImageBG1 = new File("src\\item-img-3.png");


        final Image fgImage1 = ImageIO.read(fileImageFG1);

        final Image bgImage1 = ImageIO.read(fileImageBG1);

        BufferedImage finalImage1 = overlayImages(fgImage1, bgImage1);


        Runnable r = new Runnable() {
            @Override
            public void run() {
                JPanel gui = new JPanel(new GridLayout(1, 0, 5, 5));

                gui.add(new JLabel(new ImageIcon(finalImage1)));


                JOptionPane.showMessageDialog(null, gui);
            }
        };
        SwingUtilities.invokeLater(r);
    }

    private static BufferedImage overlayImages(Image fgImage, Image bgImage) {

        int bgWidth = bgImage.getWidth(null);
        int bgHeight = bgImage.getHeight(null);
        int fgWidth = fgImage.getWidth(null);
        int fgHeight = fgImage.getHeight(null);

        final BufferedImage finalImage = new BufferedImage(bgWidth, bgHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = finalImage.createGraphics();

        g.drawImage(bgImage, 0, 0, null);

        int x = (bgWidth - fgWidth) / 2;
        int y = (bgHeight - fgHeight) / 2;

        g.drawImage(fgImage, x, y, null);

        g.dispose();

        return finalImage;
    }
}