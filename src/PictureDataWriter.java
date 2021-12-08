import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
public class PictureDataWriter {
	/**
	 * takes in an arrayList of PictureData objects and the file name to rewrite the contents of the file
	 * @param datas arrayList of PictureData objects
	 * @param f file name
	 * @return whether it was successful (true) or not (false)
	 */
	public static boolean writePictureDataToFile(ArrayList<PictureData> datas, File f){
	try {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		for (PictureData data : datas){
			pw.println(data);
		}
		pw.close();
		return true;
	} catch (Exception ex) {
		return false;
		}
	}
}
