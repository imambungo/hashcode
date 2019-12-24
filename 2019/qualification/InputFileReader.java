import java.util.Scanner;

class InputFileReader
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int numberOfPhotos = sc.nextInt();
		Photo[] photos = new Photo[numberOfPhotos];
		for (int i = 0; i < numberOfPhotos; ++i)
		{
			photos[i] = new Photo();
			photos[i].layout = sc.next().charAt(0);
			photos[i].numberOfTags = sc.nextInt();
			photos[i].tags = new String[photos[i].numberOfTags];
			for (int j = 0; j < photos[i].numberOfTags; ++j)
			{
				photos[i].tags[j] = sc.next();
			}
		}
	}
}

class Photo
{
	char layout;
	int numberOfTags;
	String[] tags;
}
