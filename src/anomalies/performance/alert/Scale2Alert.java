/**
 * 
 */
package anomalies.performance.alert;

import anomalies.DataPoint;

/**
 * @author statchum
 * 
 */
public class Scale2Alert extends Alert {
	public Scale2Alert() {
		super();
	}

	@Override
	public void launch(DataPoint point) {
		// Launch and not wait for response
		System.out.println("Anormalous measure on: " + point.getValue() + " at:" + point.getDate());

	}
}
