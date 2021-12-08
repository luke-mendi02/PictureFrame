import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<PictureData> pictureList = new ArrayList<PictureData>();
        pictureList = PictureDataReader.readPictureDataFromFile();
        PictureLoader.loadImagesFromPictureData(pictureList);
        PictureFrame pf = new PictureFrame();
        pf.setVisible(true);
            
        
    }
}
