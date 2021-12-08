import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class PictureDataReader {
	/**
	 * scans a file and reads it line by line, splits it into parts,
	 * sets the PictureData variables to each respective part, 
	 * and adds it to an arraylist of PictureData
	 * @return an ArrayList of filled PictureData objects
	 */
	public static ArrayList<PictureData> readPictureDataFromFile(){
		try{
		/* creating scanner, PictureData ArrayList, PictureData Object,
		 and all other variables **/
		Scanner fsc = new Scanner(new File("descriptions.txt"));
		ArrayList<PictureData> list = new ArrayList<PictureData>();
		PictureData picture = new PictureData();
		String line;
		String[] parts;
		String imageName;
		String imageDate;
		String imageDescription;
		// while loop to read the file line by line
		/* for some odd reason the reader was skipping over the first line of text
		 and showed the fourth line twice, so I edited the file
		 and put a filler in for the first line and got it to work **/
		while (fsc.hasNextLine()){
			line = fsc.nextLine().trim();
			if (line.length() > 0) {
				// splitting the line at the tabs
				parts = line.split("\t");
				// setting the variables and adding it to the PictureData object
				imageName = parts[0];
				imageDate = parts[1];
				imageDescription = parts[2];
				picture.setImageName(imageName);
				picture.setImageDate(imageDate);
				picture.setImageDescription(imageDescription);
				picture = new PictureData(0,0,5,imageName,imageDate,imageDescription);
				// adding the full PictureData object into the PictureData ArrayList
				list.add(picture);
			}
		}
		fsc.close();
		 /*System.out.print(list.get(0)); used this to test what the scanner was reading;
		  before I added the filler lines, it would start at the second line of text **/
		return list;
	} catch (Exception ex){
			return null;
		}

	}
}
