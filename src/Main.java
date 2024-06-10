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
        // File fileImageFG2 = new File("src\\Untitled-1.png");
        // File fileImageFG3 = new File("src\\pngfind.com-shooting-star-png-550433.png");
        // File fileImageFG4 = new File("src\\071bfb4f4d15848a6c5c78f4db6282b0.jpg");

        File fileImageBG1 = new File("src\\item-img-3.png");
        // File fileImageBG2 = new File("src\\item-img-cap-black.png");
        // File fileImageBG3 = new File("src\\item-img-mug-orange.png");

        final Image fgImage1 = ImageIO.read(fileImageFG1);
        // final Image fgImage2 = ImageIO.read(fileImageFG2);
        // final Image fgImage3 = ImageIO.read(fileImageFG3);
        // final Image fgImage4 = ImageIO.read(fileImageFG4);

        final Image bgImage1 = ImageIO.read(fileImageBG1);
        // final Image bgImage2 = ImageIO.read(fileImageBG2);
        // final Image bgImage3 = ImageIO.read(fileImageBG3);

        BufferedImage finalImage1 = overlayImages(fgImage1, bgImage1);
        // BufferedImage finalImage2 = overlayImages(fgImage2, bgImage1);
        // BufferedImage finalImage3 = overlayImages(fgImage3, bgImage1);
        // BufferedImage finalImage4 = overlayImages(fgImage4, bgImage1);
        // BufferedImage finalImage5 = overlayImages(fgImage1, bgImage2);
        // BufferedImage finalImage6 = overlayImages(fgImage2, bgImage2);
        // BufferedImage finalImage7 = overlayImages(fgImage3, bgImage2);
        // BufferedImage finalImage8 = overlayImages(fgImage4, bgImage2);
        // BufferedImage finalImage9 = overlayImages(fgImage1, bgImage3);
        // BufferedImage finalImage10 = overlayImages(fgImage2, bgImage3);
        // BufferedImage finalImage11 = overlayImages(fgImage3, bgImage3);
        // BufferedImage finalImage12 = overlayImages(fgImage4, bgImage3);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                JPanel gui = new JPanel(new GridLayout(1, 0, 5, 5));

                gui.add(new JLabel(new ImageIcon(finalImage1)));
                // gui.add(new JLabel(new ImageIcon(finalImage2)));
                // gui.add(new JLabel(new ImageIcon(finalImage3)));
                // gui.add(new JLabel(new ImageIcon(finalImage4)));
                // gui.add(new JLabel(new ImageIcon(finalImage5)));
                // gui.add(new JLabel(new ImageIcon(finalImage6)));
                // gui.add(new JLabel(new ImageIcon(finalImage7)));
                // gui.add(new JLabel(new ImageIcon(finalImage8)));
                // gui.add(new JLabel(new ImageIcon(finalImage9)));
                // gui.add(new JLabel(new ImageIcon(finalImage10)));
                // gui.add(new JLabel(new ImageIcon(finalImage11)));
                // gui.add(new JLabel(new ImageIcon(finalImage12)));

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