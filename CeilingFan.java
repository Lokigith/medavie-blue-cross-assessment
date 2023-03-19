import java.time.LocalDate;

public class CeilingFan {
    private int speed; // 0 = off, 1 = low, 2 = medium, 3 = high
    private boolean reversed;
    
    public CeilingFan() {
        this.speed = 0;
        this.reversed = false;
    }
    
    public void pullSpeedCord() {
        if (LocalDate.now().getMonthValue() == 12 && LocalDate.now().getDayOfMonth() == 25) {
            this.speed = 0; // Ceiling fan should be off on Dec 25th all day
            return;
        }
        if (this.speed == 3) {
            this.speed = 0; // If pulled on speed 3, fan returns to off setting
        } else {
            this.speed++;
        }
    }
    
    public void pullDirectionCord() {
        if (LocalDate.now().getMonthValue() == 12 && LocalDate.now().getDayOfMonth() == 25) {
            return; // Ceiling fan should be off on Dec 25th all day
        }
        this.reversed = !this.reversed;
    }
    
    public void printStatus() {
        System.out.println("Ceiling fan status:");
        System.out.println("Speed: " + speed);
        System.out.println("Direction: " + (reversed ? "reverse" : "forward"));
        System.out.println();
    }

    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        fan.printStatus(); // Should print "Speed: 0" and "Direction: forward"
        
        fan.pullSpeedCord();
        fan.pullSpeedCord();
        fan.printStatus(); // Should print "Speed: 2" and "Direction: forward"
        
        fan.pullDirectionCord();
        fan.pullSpeedCord();
        fan.pullSpeedCord();
        fan.pullSpeedCord();
        fan.pullSpeedCord();
        fan.printStatus(); // Should print "Speed: 1" and "Direction: reverse"
        
        fan.pullDirectionCord();
        fan.pullSpeedCord();
        fan.printStatus(); // Should print "Speed: 2" and "Direction: reverse"
    }


}
