import java.util.Scanner;

class Solution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int realMax = max;
		int input = sc.nextInt();
		int[] inputs = new int[input];
		boolean[] pizzas = new boolean[input];
		for (int i = 0; i < input; ++i)
		{
			inputs[i] = sc.nextInt();
		}
		int index = 0;
		int slices = 0;
		int last = -1;
		int types = 0;
		for (int i = input - 1; i >= 0; --i)
		{
			if (max >= inputs[i])
			{
				types++;
				pizzas[i] = true;
				max -= inputs[i];
				slices += inputs[i];
				last = inputs[i];
				index = i;
			}
		}
		//System.out.println("Max = " + realMax);
		//System.out.println("Slices = " + slices);
		int sisa = realMax - slices;
		//System.out.println("Sisa = " + sisa);
		//System.out.println("Last = " + last);
		int sisaLast = sisa + last;
		//System.out.println("Sisa + Last = " + (sisaLast));
		//System.out.println(index);
		//System.out.println("Sisa:");
		/*
		for (int i = 0; i < index; ++i)
		{
			System.out.print(inputs[i] + " ");
		}
		*/
		//System.out.println();
		int maxx = 0;
		int a = 0;
		int b = 0;
		for (int i = 0; i < index - 1; ++i)
		{
			for (int j = i + 1; j < index; ++j)
			{
				int jumlah = inputs[i] + inputs[j];
				if (jumlah > maxx && jumlah <= sisaLast) {
					maxx = jumlah;
					a = i;
					b = j;
				}
			}
		}
		//System.out.println("maxx = " + maxx);
		//System.out.println(a + " + " + b);
		//int newSlices = slices - last + maxx;
		//System.out.println("new slices = " + newSlices);
		if (maxx > last) {
			pizzas[index] = false;
			pizzas[a] = true;
			pizzas[b] = true;
			types++;
		}

		System.out.println(types);
		for (int i = 0; i < pizzas.length; ++i)
		{
			if (pizzas[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
