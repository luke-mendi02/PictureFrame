import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
public class PictureLoader {
	public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> pictureList){
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		//ArrayList<PictureData> pictureList = new ArrayList<PictureData>();
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
