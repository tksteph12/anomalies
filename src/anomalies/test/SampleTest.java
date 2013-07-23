/**
 * 
 */
package anomalies.test;

import java.util.ArrayList;
import java.util.List;

import anomalies.point.Complex;
import anomalies.signal.Signal;

/**
 * @author statchum
 *
 */
public class SampleTest {


	public static void main(final String args[]){
		final int nsd = 2;
		final List<Complex> points = new ArrayList<Complex>();
		Complex point;
		final double [] signalOrigin = new double[60];
		final double [] upperBol = new double[60];
		final double [] lowerBol = new double[60];
		final double [] bolling = new double[60];

		// -------------------------------------------------------

		final Signal signal = new Signal();
		for (int i = 0; i < 60; i++) {
			final double im = Math.sin(i*Math.PI/3);
			point = new Complex(i, im);
			signalOrigin[i] = im;
			signal.addPoint(point);
			upperBol [i] = signal.upperBand(nsd);
			lowerBol[i] = signal.lowerBand(nsd);
			bolling[i] = signal.getMean(60, i);
		}


	}
}
