/**
 * 
 */
package anomalies.performance.alert;

import anomalies.DataPoint;
import anomalies.performance.IAlert;

/**
 * @author statchum
 * 
 */
public class Alert implements IAlert {
	private int alertThrehsold;
	private int scale;// scale of the alert: the alert will be send according to its scale
	private int gravity; // gravity of the alert: the alert will be send according to its gravity

	public Alert() {
		gravity = 0;
	}

	/**
	 * @param gravity
	 */
	public void addgravity(final int gravity, DataPoint point) {
		this.gravity += gravity;
		if (this.gravity > alertThrehsold) {
			launch(point);
		}
	}

	public void launch(DataPoint point) {

		System.out.println("Anormalous measure on: " + point.getValue() + " at:" + point.getDate());
	}
}
