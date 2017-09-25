package gss.coding.problems;

public class FloodFillInBitMap {

	public FloodFillInBitMap() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Color[][] pic = {
				{ Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK },
				{ Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE },
				{ Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE },
				{ Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE } };
		BitMap bmp = new BitMap(pic);
		System.out
				.println("*************************************Before floodFilling");
		bmp.print();

		try {
			// floodFill(bmp, new Point(3, 0));
			floodFill(bmp, new Point(1, 3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out
				.println("*************************************After floodFilling");
		bmp.print();
	}

	public enum Color {
		BLACK, WHITE
	}

	public static class Point {
		public int x;
		public int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class BitMap {
		public Color[][] arr;

		BitMap(Color[][] arr) {
			this.arr = arr;
		}

		public void print() {
			for (int i = 0; i < arr.length; i++) {
				System.out.println();
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}

		public Color getColor(Point p) throws Exception {
			if (isValid(p)) {
				return arr[p.x][p.y];
			}
			throw new Exception("getColor(): Invalid Point");
		}

		public boolean isValid(Point p) {
			return (p.x >= 0 && p.x < arr.length)
					&& (p.y >= 0 && p.y < arr[0].length);
		}

		public void changeColor(Point p, Color color) {
			if (isValid(p)) {
				arr[p.x][p.y] = color;
			}
		}
	}

	public static void floodFill(BitMap bmp, Point startPos) throws Exception {
		Color color = bmp.getColor(startPos);
		floodFillHelper(bmp, startPos, color == Color.WHITE ? Color.BLACK
				: Color.WHITE);
	}

	public static void floodFillHelper(BitMap bmp, Point startPos, Color color)
			throws Exception {
		if (!bmp.isValid(startPos) || bmp.getColor(startPos) == color) {
			return;
		}
		bmp.changeColor(startPos, color);
		floodFillHelper(bmp, new Point(startPos.x + -1, startPos.y), color); // top
		floodFillHelper(bmp, new Point(startPos.x + 1, startPos.y), color);// bottom
		floodFillHelper(bmp, new Point(startPos.x, startPos.y + -1), color); // left
		floodFillHelper(bmp, new Point(startPos.x, startPos.y + 1), color);// right
	}

}
