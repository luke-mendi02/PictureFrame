public class PictureData {
		private int xpos;
		private int ypos;
		private int radius;
		public PictureData() {
			xpos = 0;
			ypos = 0;
			radius = 5;
		}
		public PictureData(int x, int y, int r) {
			setXPos(x);
			setYPos(y);
			setRadius(r);
		}
		public int getXPos() {
			return xpos;
		}
		public int getYPos() {
			return ypos;
		}
		public int getRadius() {
			return radius;
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
		@Override
		public String toString() {
			return String.format("%d %d %d", xpos, ypos, radius);
		}
	
}
