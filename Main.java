import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			char[] s = fs.next().toCharArray();
			HashMap<Coord, Integer> mp = new HashMap<>();
			Coord cur = new Coord(0, 0);
			mp.put(new Coord(0, 0), -1);
			int min = Integer.MAX_VALUE;
			int start = -1, end = -1;
			for (int i = 0; i < n; i++) {
				if (s[i] == 'L') {
					cur.x--;
				} else if (s[i] == 'R') {
					cur.x++;
				} else if (s[i] == 'U') {
					cur.y++;
				} else {
					cur.y--;
				}
				if (mp.containsKey(new Coord(cur.x, cur.y))) {
					int diff = i - mp.get(new Coord(cur.x, cur.y));
//					System.out.print(diff + " = ");
					if (diff < min) {
						min = diff;
						start = mp.get(new Coord(cur.x, cur.y)) + 1;
						end = i;
					}
				}
				mp.put(new Coord(cur.x, cur.y), i);
//				System.out.println(cur.x + " " + cur.y);
			}
			if (start == -1 && end == -1) {
				System.out.println(-1);
				continue;
			}
			start++;
			end++;
			System.out.println(start + " " + end);
		}
		out.close();
	}
	
	static class Coord {
		int x, y;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return 31 + (this.x + this.y);
		}
		
		@Override
		public boolean equals(Object other) {
			Coord o = (Coord) other;
			return (this.x == o.x && this.y == o.y);
		}
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
