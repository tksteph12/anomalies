/**
 * 
 */
package anomalies.performance.alert;

import anomalies.performance.IAlert;

/**
 * @author statchum
 *
 */
public class Alert implements IAlert{
	private int alertThrehsold;
	private int scale;//scale of the alert: the alert will be send according to its scale
	private int gravity; // gravity of the alert: the alert will be send according to its gravity

	public Alert(){
		gravity = 0;
	}


	/**
	 * @param gravity
	 */
	public void addgravity(final int gravity) {
		this.gravity+=gravity;
		if (this.gravity>alertThrehsold){
			launch();
		}
	}

	public void launch(){}
}
