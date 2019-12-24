import java.util.ArrayList;
import java.util.Scanner;

class Judger
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// Input file
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

		// Submission file
		int numberOfSlides = sc.nextInt();
		Slide[] slides = new Slide[numberOfSlides];
		for (int i = 0; i < numberOfSlides; ++i)
		{
			slides[i] = new Slide();
			int photoNumber = sc.nextInt();
			if (photos[photoNumber].layout == 'H') {
				slides[i].numberOfTags = photos[photoNumber].numberOfTags;
				slides[i].tags = photos[photoNumber].tags;
			}
			else {
				int secondPhotoNumber = sc.nextInt();
				slides[i].tags = unionTags(photos[photoNumber].tags,
				                           photos[secondPhotoNumber].tags);
				slides[i].numberOfTags = slides[i].tags.length;
			}
		}
	}

	static String[] unionTags(String[] firstTags, String[] secondTags)
	{
		ArrayList<String> unionTags = new ArrayList<String>();
		for (String tag : firstTags)
			unionTags.add(tag);

		for (String tag : secondTags)
			if (! unionTags.contains(tag))
				unionTags.add(tag);

		String[] returnTags = unionTags.toArray(new String[0]);
		return returnTags;
	}
}

class Photo
{
	char layout;
	int numberOfTags;
	String[] tags;
}

class Slide
{
	int numberOfTags;
	String[] tags;
}
