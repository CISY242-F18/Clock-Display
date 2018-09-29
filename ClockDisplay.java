
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * Internally storing numbers with 0-23 and displaying 1-12 with
 * AM/PM indicator.
 * 
 * clock uses a 24 hour internal representation but display the string
 * as a 12 hour clock
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Nicolas M
 * @version 2018.09.24
 * Exercise 3.39
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;  
    private String displayString;    // simulates the actual display
  
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String show)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        show = show;
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
        
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);        
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private  void updateDisplay()
    {
        String hoursString="";
        String showString="";
        
        if(hours.getValue()>=12)
        {
        if( (hours.getValue()-12)>= 0 && 
            (hours.getValue()-12)<=9)
            hoursString= "0" + (hours.getValue()-12);
        
        else
        
         hoursString= "" + (hours.getValue()-12); 
         showString= "pm";
        }
        
        else
        {
         hoursString= "" + hours.getDisplayValue(); 
         showString= "am";
        }
        
        displayString = hoursString + ":"+
        minutes.getDisplayValue()+
        showString;
    }
}
