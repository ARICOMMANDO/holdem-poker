package gui;

import java.net.URL;
import javax.swing.ImageIcon;
import def.Card;

public abstract class ResourceManager {
    
    private static final String IMAGE_PATH_FORMAT = "/images/card_%s.png"; 
    
    public static ImageIcon getCardImage(Card card) {
        int sequenceNr = card.getSuit() * Card.NO_OF_RANKS + card.getRank();
        String sequenceNrString = String.valueOf(sequenceNr);
        if (sequenceNrString.length() == 1) {
            sequenceNrString = "0" + sequenceNrString;
        }
        String path = String.format(IMAGE_PATH_FORMAT, sequenceNrString);
        return getIcon(path);
    }
    
    public static ImageIcon getIcon(String path) {
        URL url = ResourceManager.class.getResource(path);
        if (url != null) {
            return new ImageIcon(url);
        } else {
            throw new RuntimeException("Resource file not found: " + path);
        }
    }
    
}
