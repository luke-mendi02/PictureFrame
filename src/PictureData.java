
public class PictureData {
		private int xpos;
		private int ypos;
		private int radius;
		private String imageName;
		private String imageDate;
		private String imageDescription;
		// creating default constructor
		public PictureData() {
			xpos = 0;
			ypos = 0;
			radius = 5;
			imageName = "";
			imageDate = "";
			imageDescription = "";
		}
		// creating non-default constructor
		public PictureData(int xpos, int ypos, int radius, String imageName, String imageDate, String imageDescription) {
			setXPos(xpos);
			setYPos(ypos);
			setRadius(radius);
			setImageName(imageName);
			setImageDate(imageDate);
			setImageDescription(imageDescription);
		}
		// creating getters and setters of all PictureData variables
		public int getXPos() {
			return xpos;
		}
		public int getYPos() {
			return ypos;
		}
		public int getRadius() {
			return radius;
		}
		public String getImageName() {
			return imageName;
		}
		public String getImageDate() {
			return imageDate;
		}
		public String getImageDescription() {
			return imageDescription;
		}
		public void setXPos(int x) {
			if (x < 0) {
				xpos = 0;
			} else {
				xpos = x;
			}
		}
		public void setYPos(int y) {
			if (y < 0) {
				ypos = 0;
			} else {
				ypos = y;
			}
		}
		public void setRadius(int r) {
			if (r < 0) {
				radius = 5;
			} else {
				radius = r;
			}
		}
		public void setImageName(String imageName){
			this.imageName = imageName;
		}
		public void setImageDate(String imageDate){
			this.imageDate = imageDate;
		}
		public void setImageDescription(String imageDescription){
			this.imageDescription = imageDescription;
		}
		// creating to string function
		@Override
		public String toString() {
			return String.format("%s %s %s", imageName, imageDate, imageDescription);
		}
	
}
