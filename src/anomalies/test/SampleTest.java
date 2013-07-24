/**
 * 
 */
package anomalies.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import anomalies.DataPoint;
import anomalies.performance.BollingerBand;
import anomalies.signal.Signal;

/**
 * @author statchum
 * 
 */
public class SampleTest {

	public static void main(final String args[]) {
		final int nsd = 2;
		final List<DataPoint> points = new ArrayList<DataPoint>();
		DataPoint point;
		final double[] signalOrigin = new double[60];
		final double[] upperBol = new double[60];
		final double[] lowerBol = new double[60];
		final double[] bolling = new double[60];

		// -------------------------------------------------------

		final Signal signal = new Signal();
		for (int i = 0; i < 60; i++) {
			final double im = Math.sin(i * Math.PI / 3);
			point = new DataPoint(new Date(), im);
			signalOrigin[i] = im;
			signal.addPoint(point);
			upperBol[i] = signal.upperBand(nsd);
			lowerBol[i] = signal.lowerBand(nsd);
			bolling[i] = signal.getMean(60, i);

		}

		BollingerBand upperBollinger = new BollingerBand(signal);

		double[] aux = new double[60];
		int i = 0;
		for (DataPoint dPoint : upperBollinger.getLowerBand().getPoints()) {
			aux[i] = dPoint.getValue();
			i++;
		}

		System.out.println();

	}
}
