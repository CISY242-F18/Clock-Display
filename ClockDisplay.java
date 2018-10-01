
/**
 * The ClockDisplay class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00am (midnight) to 11:59pm (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * The clock maintains data internally from 0-23 but displays a 12 hour face
 * with an AM/PM indicator. 
 * 
 * @author Nicolas M.
 * @version 2018.09.24
 * Exercise 3.38
 * Code examples from pages 101-113
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
    public ClockDisplay(int hour, int minute )
    {
        
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        
        setTime(hour, minute);
        
    }
    
    public String get12HourInternalDisplay()
    {
        return displayString;
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
    
    public String getTime()
     {
         return displayString;
     }
     
     
     
    
    
    /**
     * Set the new specified time, 12 hour clock 
     * /Online references.
     */
    private void updateDisplay()
    {
     int hour = hours.getValue();
     String prefix;
     
     if(hour >=12) {
         prefix = "pm";
        }
     else {
         prefix = "am";
        }
     if (hour >=12){
         hour -=12;
         }
     if(hour == 0) {
       hour = 12;
       }
     displayString = hour + ": "+
        minutes.getDisplayValue()+ prefix;
    }
}
