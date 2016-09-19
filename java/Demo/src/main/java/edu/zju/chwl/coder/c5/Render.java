package edu.zju.chwl.coder.c5;

import org.junit.Test;

public class Render {
	public int[] renderPixel(int[] screen, int x, int y) {
		int a = x / 8;
		int b = y / 8;
		if (x == y) {
			screen[a] = color(screen[a], x % 8, 7);
		} else {
			for (int i = a + 1; i < b; i++) {
				screen[i] = 255;
			}
			screen[a] = color(screen[a], x % 8, 7);
			screen[b] = color(screen[b], 0, y % 8);
		}
		return screen;
	}

	private int color(int n, int i, int j) {
		return ((1 << (j+1)) - 1 - ((1 << i) - 1)) | n;
	}

	@Test
	public void test() {
		int[] arr = renderPixel(new int[] { 58, 211, 111, 90, 248, 124, 27,
				226, 39, 43, 124, 183, 182, 141, 133, 12, 233, 227, 27, 103,
				216, 14, 187, 200, 22, 115, 28, 50, 132, 174, 173, 105, 203,
				231, 134, 21, 129, 46, 108, 241, 196 }, 194,313);
		for(int num:arr){
			System.out.println(num);
		}
	}
}
