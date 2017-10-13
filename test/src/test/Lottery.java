package test;

import java.util.*;

public class Lottery {
	public int[] random() {
		int[] a = new int[6];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(33) + 1;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(a);
		return a;

	}

	public int[] it() {
		int[] array = new int[6];

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			System.out.println("请输入红球第" + (i + 1) + "个数字!(范围1~33)");

			int st = sc.nextInt();
			array[i] = st;

		}
		Arrays.sort(array);
		return array;
	}

	public int blue() {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入蓝球(范围1~16)");
		int blue = sc.nextInt();
		return blue;

	}

	public int randomblue() {
		Random r = new Random();
		int randomblue = r.nextInt(16) + 1;
		return randomblue;

	}

	public void compare(int t[], int color) {
		boolean bl = true;
		int count = 1;

		while (bl) {
			int r[] = random();

			System.out.println("      " + "这是第" + count + "次!");
			for (int i = 0; i < r.length; i++) {
				if (r[i] < 10) {
					System.out.print(" " + "0" + r[i] + " ");
				} else {
					System.out.print(" " + r[i] + " ");
				}
			}
			count++;
			int rd = randomblue();
			if (Arrays.equals(r, t)) {

				if (rd < 10) {
					System.out.print(" + " + "0" + rd + "   ");
				} else {
					System.out.print(" + " + rd + "   ");
				}
				if (color == rd) {
					bl = false;
					break;
				}
				// this.compare(t, color);
			}

			if (rd < 10) {
				System.out.print(" + " + "0" + rd + "   ");
			} else {
				System.out.print(" + " + rd + "   ");
			}
		}

	}

	public static void main(String[] args) {
		Lottery LT = new Lottery();
		int t[] = LT.it();
		int color = LT.blue();
		LT.compare(t, color);
		//
		// if (randomblue()!= blue()) {
		// fg.compare(fg.it(), fg.random());
		// }else{
		System.out.println("恭喜你中奖了!");
		// }

	}

}
