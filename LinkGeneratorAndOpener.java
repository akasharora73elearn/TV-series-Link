import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class LinkGeneratorAndOpener
{
    public static void main(String[] args)
	{ 
		Scanner emma=new Scanner(System.in);
        System.out.println("Enter the name of the TV Series");
		String TVSeriesNameEntered=emma.nextLine();
		String[] TVSeriesNameArray=TVSeriesNameEntered.split("\\s+");
		String TVSeries="";
		for(int i=0;i<TVSeriesNameArray.length;i++)
		{
			if(i!=TVSeriesNameArray.length-1)
			{
				TVSeries=TVSeries+TVSeriesNameArray[i].toLowerCase()+"-";
			}
			else
			{
				TVSeries=TVSeries+TVSeriesNameArray[i].toLowerCase();
			}
		}
		
		System.out.println("Enter the Season No.");
		String SeasonEntered=emma.nextLine();
		/*if(SeasonEntered.length()==1)
		{
			SeasonEntered="0"+SeasonEntered;
		}*/
		String Season=SeasonEntered;
		System.out.println("Enter the starting episode");
		int StartingEpisodeEntered=emma.nextInt();
		System.out.println("Enter the ending episode");
		int EndingEpisodeEntered=emma.nextInt();
		for(int i=StartingEpisodeEntered;i<=EndingEpisodeEntered;i++)
		{
			String episode=Integer.toString(i);
			/*if(episode.length()==1)
			{
				episode="0"+episode;
			}*/
			String url="http://putlocker.is/watch-"+TVSeries+"-tvshow-"+"season-"+Season+"-episode-"+episode+"-online-free-putlocker.html";
			
			if(Desktop.isDesktopSupported())
			{
				Desktop desktop = Desktop.getDesktop();
				try 
				{
					desktop.browse(new URI(url));
				} 
				catch (IOException | URISyntaxException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				Runtime runtime = Runtime.getRuntime();
				try 
				{
					runtime.exec("xdg-open " + url);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	

    }
}