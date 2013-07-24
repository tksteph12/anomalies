/**
 * 
 */
package anomalies.performance;

import anomalies.DataPoint;
import anomalies.performance.alert.Alert;
import anomalies.performance.alert.Scale1Alert;
import anomalies.performance.alert.Scale2Alert;
import anomalies.signal.Signal;

/**
 * @author statchum
 * 
 */
public final class PerformanceManager {

	private final double upperThreshold;
	private final double lowerThreshold;
	// private final List<Alert> alertQueue;
	private Alert scale1Alert;
	private Alert scale2Alert;

	private final int nsd;

	public PerformanceManager(final double upperThreshold, final double lowerThreshold, final int nsd) {

		this.nsd = nsd;
		this.upperThreshold = upperThreshold;
		this.lowerThreshold = lowerThreshold;

	}

	IAlert alert;
	IAlert alert1;

	public boolean checkMeasure(final DataPoint point, final Signal signal) {
		boolean bool = false;
		signal.addPoint(point);
		double upperBand = signal.upperBand(nsd);
		upperBand = upperBand < upperThreshold ? upperBand : upperThreshold;
		double lowerBand = signal.lowerBand(nsd);
		lowerBand = lowerBand > lowerThreshold ? lowerBand : lowerThreshold;

		final double measure = point.getValue();
		if (measure < upperBand && measure > lowerBand) {
			bool = true;
			return bool;
		}
		final Alert a = new Alert();
		if (measure > upperBand && measure < upperThreshold || measure > lowerThreshold && measure < lowerBand) {
			// scale 1 anomaly
			if (scale1Alert == null) {
				scale1Alert = new Scale1Alert();
			}
			scale1Alert.addgravity(1, point);
		}
		if (measure > upperThreshold || measure < lowerThreshold) {
			// scale 2 anomaly
			if (scale2Alert == null) {
				scale2Alert = new Scale2Alert();
			}
			scale2Alert.addgravity(2, point);
		}

		return bool;
	}

}
