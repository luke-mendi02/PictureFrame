import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
public class PictureLoader {
	/**
	 * takes in an ArrayList of PictureData objects to create an ArrayList of BufferedImage objects
	 * @param pictureList ArrayList of PictureData objects
	 * @return ArrayList of BufferedImage objects
	 */
	public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> pictureList){
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		try{
		for (PictureData picture: pictureList){
		BufferedImage image = ImageIO.read(new File(picture.getImageName()));
			images.add(image);
		}
		return images;
		} catch (Exception ex){
			return null;
		}
	}
}
