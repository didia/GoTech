package domaine.simulateur;

import java.io.Serializable;

public class Clock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static long m_milliseconds = 0;
	
	public static void update(int milliseconds)
	{
		m_milliseconds += milliseconds;
	}
	
	public static void reset()
	{
		m_milliseconds = 0;
	}
	
	public static long getTime(){
		return m_milliseconds;
	}
	
	public static String stringVersion()
	{
	
		int secondes = (int) ((m_milliseconds/1000)%60);
		int minutes = (int) ((m_milliseconds/1000 / (60)) % 60);
		int hours   = (int) ((m_milliseconds/1000 / (60*60)));
		String seconds = Integer.toString(secondes);
		String minuts = Integer.toString(minutes);
		String hour = Integer.toString(hours);
		if(secondes < 10)
		{
			seconds = "0"+secondes;
		}
		if(minutes < 10)
		{
			minuts ="0"+minutes;
		}
		if(hours <10)
		{
			hour = "0"+hours;
		}
		return String.format("%s:%s:%s", hour, minuts,seconds);
	}
}
