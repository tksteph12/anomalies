/**
 * 
 */
package anomalies.performance.alert;

import anomalies.DataPoint;

/**
 * @author statchum
 * 
 */
public class Scale1Alert extends Alert {
	public Scale1Alert() {
		super();
	}

	@Override
	public void launch(DataPoint point) {
		// Launch and wait for response
		System.out.println("Anormalous measure on: " + point.getValue() + " at:" + point.getDate());

	}
}
