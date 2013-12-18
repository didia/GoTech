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
	
}
