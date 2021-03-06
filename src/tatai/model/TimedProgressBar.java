package tatai.model;

import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

/**
 * A timed progress bar that lasts for three seconds.
 * Updates every 100 milliseconds.
 * Extends the JavaFX progress bar.
 * @author dli294
 *
 */
public class TimedProgressBar extends ProgressBar {

    private int _counter = 0;
    // Number of updates.
    private int _cycles = 30;
    // Number of milliseconds between updates.
    private int _delay = 100;
    
    /**
     * Starts the progress bar.
     * @author dli294
     */
    public void start() {
    	_counter = 0;
    	this.setVisible(true);
    	this.setManaged(true);
    	tick();
    }
    
    /**
     * Changes the progress.
     * @param progress The updated progress.
     * @author dli294
     */
    private void change(double progress) {
    	this.setProgress(progress);
    }
    
    /**
     * Represents one tick of a timer.
     * @author dli294
     */
    private void tick() {
    	Task<Void> task = new Task<Void>() {
			@Override public Void call(){				
				try {
					if (_counter < _cycles) {
						_counter++;
						change(((double)_counter)/((double)_cycles));
						Thread.sleep(_delay);
						tick();
					} else {
						stop();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		    }
		};
		new Thread(task).start();
    }
    
    /**
     * Stops and hides the progress bar.
     * @author dli294
     */
    public void stop() {
    	this.setVisible(false);
    	this.setManaged(false);
    }
    
    /**
     * Initializes the progress bar.
     * @param progress Initial progress.
     * @author dli294
     */
    public TimedProgressBar(double progress) {
    	super(progress);
    	this.setPrefWidth(300);
    }
    
}