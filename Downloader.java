import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//https://www.dprktoday.com/content/movie/flv_mv/vod/dprktoday/ucc/2019/20191114-ucc-s.mp4

public class Downloader {

	public static void main(String[] args) {
		
		
		String s = "2017-01-01";
		String e = "2017-12-31";
		LocalDate start = LocalDate.parse(s);
		LocalDate end = LocalDate.parse(e);
		List<LocalDate> totalDates = new ArrayList<>();
		List<String> allDays = new ArrayList<>();
		List<String> allNames = new ArrayList<>();
		
		while (!start.isAfter(end)) {
			String dated = start.getYear()
					+""
					+String.format("%02d", start.getMonthValue())
					+""
					+String.format("%02d", start.getDayOfMonth());
			//allDays.add("https://www.dprktoday.com/content/movie/flv_mv/vod/dprktoday/kor_tv/2017/"+dated+"-uri-q.mp4");
			allDays.add("https://www.dprktoday.com/content/movie/flv_mv/vod/dprktoday/ucc/2017/"+dated+"-ucc-s.mp4");
			totalDates.add(start);
			allNames.add(start+"-uri-q.mp4");
		    start = start.plusDays(1);
		    
		}
		
		
		

		
		for (int i = 0; i < allNames.size(); i++) {
			try {
				System.out.println(allDays.get(i));
				
				BufferedInputStream in = new BufferedInputStream(
						new URL(allDays.get(i))
						.openStream());
			
				FileOutputStream fileOutputStream = new FileOutputStream("F:\\VOICEOFKOREA\\UCC\\"+allNames.get(i));
				byte dataBuffer[] = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					fileOutputStream.write(dataBuffer, 0, bytesRead);
				}
				
				fileOutputStream.close();
				
			}
			catch(java.io.FileNotFoundException e1) {
				System.out.println(e1.toString());
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}	
		}

	}

}
