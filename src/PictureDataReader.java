import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class PictureDataReader {
	public static ArrayList<PictureData> readPictureDataFromFile(){
		try{
		Scanner fsc = new Scanner(new File("descriptions.txt"));
		ArrayList<PictureData> list = new ArrayList<PictureData>();
		PictureData picture = new PictureData();
		String line = "";
		String[] parts;
		String imageName = "";
		String imageDate = "";
		String imageDescription = "";
		while (fsc.hasNextLine()){
			line = fsc.nextLine();
			if (line.length() > 0) {
				parts = line.split("\t");
				imageName = parts[0];
				imageDate = parts[1];
				imageDescription = parts[2];
				picture.setImageName(imageName);
				picture.setImageDate(imageDate);
				picture.setImageDescription(imageDescription);
				picture = new PictureData(imageName,imageDate,imageDescription);
				list.add(picture);
			}
		}
		// System.out.print(list.get(1));
		return list;
	} catch (Exception ex){
			return null;
		}

	}
}
