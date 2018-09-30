
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
        
        hours = new NumberDisplay(12);
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
        
        hours = new NumberDisplay(13);
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
        if( hours.getValue() == 12)
        toString();
        
        
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
     String hoursString="";
        String showString="";
        
        if(hours.getValue()>=12)
        {
        if( (hours.getValue()-12)>= 0 && 
            (hours.getValue()-12)<=9 )
            
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
