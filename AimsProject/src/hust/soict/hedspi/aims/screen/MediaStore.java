package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.application.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Phuc 20225905
public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add "Add to cart" button
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() { // Handle "Add to Cart"
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null, media.getTitle() + " has been added to the cart!");
                Platform.runLater(() -> {
                    if (CartScreen.getController() != null) {
                        CartScreen.getController().updateTotalCost();
                    }
                });
            }
        });
        container.add(addToCartButton);

        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() { // Handle "Play"
                @Override
                public void actionPerformed(ActionEvent e) {
                    playMedia((Playable) media); // Cast and call playMedia method
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));


    }

    private void playMedia(Playable playable) {
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Playing Media");
        playDialog.setSize(300, 200);

        // Define the content of the dialog
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel playingLabel = new JLabel("Playing: " + media.getTitle());
        playingLabel.setFont(new Font(playingLabel.getFont().getName(), Font.PLAIN, 16));
        playingLabel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel playMessage = new JLabel();
        playMessage.setAlignmentX(CENTER_ALIGNMENT);

        // Mock `play` behavior by calling `playable.play` and showing details
        playable.play(); // Output playback details to console (already implemented in `Playable`)
        if (media instanceof hust.soict.hedspi.aims.media.Disc) {
            playMessage.setText("Length: " + ((hust.soict.hedspi.aims.media.Disc) media).getLength() + " minutes");
        } else {
            playMessage.setText("Enjoy your media!");
        }

        content.add(Box.createVerticalGlue());
        content.add(playingLabel);
        content.add(playMessage);
        content.add(Box.createVerticalGlue());

        playDialog.add(content);
        playDialog.setVisible(true);

    }
}
