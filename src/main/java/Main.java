import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*

Types used in this code:

(Add your answers to lab instruction #4 here)

 */

void main() {

    try {
        var avatarStream = getRandomAvatarStream();
        showAvatar(avatarStream);
    } catch (IOException | InterruptedException e) {
    /*  (1) @showMessageDialog() is a *class method*.
        (2) @getMessage() is an *instance method*.
        (3) @ERROR_MESSAGE ia a *class variable* (constant). */
        JOptionPane.showMessageDialog(null, "Failed to load avatar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

}

InputStream getRandomAvatarStream() throws IOException, InterruptedException {
    // Pick a random style
    String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };
    /* (1) @random() is a *class method*.
    *  (2) @length is an *instance variable* (constant). */
    var style = styles[(int)(Math.random() * styles.length)];

    // Generate a random seed
    /* @random is a *class method*. */
    var seed = (int)(Math.random() * 10000);

    // Create an HTTP request for a random avatar
    /* (1) @create() is a *class method*.
    *  (2) @formatted() is an *instance method*. */
    var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
    /* (1) @newBuilder() is a *class method*.
    *  (2) @build() is an *instance method*. (abstract = instructions undefined) */
    var request = HttpRequest.newBuilder(uri).build();

    // Send the request
    // @newHttpClient() is a *class method*.
    try (var client = HttpClient.newHttpClient()) {
        /* (1) @send() is an *instance method*. (abstract = instructions undefined)
        *  (2) @BodyHandlers is a *class variable*. (a class member specifically)
        *  (3) @ofInputStream() is a *class method*. */
        var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        // @body is a *instance method*. (abstract = instructions undefined)
        return response.body();
    }
}

void showAvatar(InputStream imageStream) {
    JFrame frame = new JFrame("PNG Viewer");
    /* (1) @setDefaultCloseOperation() is an *instance method*.
       (2) @EXIT_ON_CLOSE is a *class variable*. (constant)
     */
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // @setResizable() is an *instance method*.
    frame.setResizable(false);
    // @setSize() is an *instance method*.
    frame.setSize(200, 200);
    /* (1) @getContentPane() is an *instance method*.
       (2) @setBackground() is an *instance method*.
       (3) @BLACK is a *class variable*. (constant)
     */
    frame.getContentPane().setBackground(Color.BLACK);

    try {
        // Load the PNG image
        // @read() is a *class method*.
        Image image = ImageIO.read(imageStream);

        // Create a JLabel to display the image
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        /* (1) @add() is an *instance method*.
           (2) @CENTER is a *class variable*. (constant)
         */
        frame.add(imageLabel, BorderLayout.CENTER);

    } catch (IOException e) {
        /*  (1) @showMessageDialog() is a *class method*.
        (2) @getMessage() is an *instance method*.
        (3) @ERROR_MESSAGE ia a *class variable* (constant). */
        JOptionPane.showMessageDialog(frame, "Failed to load image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    // @setVisible() is an *instance method*.
    frame.setVisible(true);
}
