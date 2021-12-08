import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<PictureData> pictureList = new ArrayList<PictureData>(); // creating the arraylist of pictureData objects
        // reading the file to add to the pictureData objects in the created Arraylist
        pictureList = PictureDataReader.readPictureDataFromFile();
        // passing the pictureData object ArrayList to create BufferedImages
        PictureLoader.loadImagesFromPictureData(pictureList);
        // creating the pictureFrame
        PictureFrame pf = new PictureFrame();
        pf.setVisible(true);
            
        
    }
}
