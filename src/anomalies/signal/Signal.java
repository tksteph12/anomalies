/**
 * 
 */
package anomalies.signal;

import java.util.List;

import anomalies.point.Complex;
import anomalies.statistics.Statistics;

/**
 * @author statchum
 * 
 */
public class Signal {
	// Un signal est une liste de nombre complexes
	private final List<Complex> points;
	private double mean, sigma;
	private int period; // number of points in the signal to be considered

	public static Statistics stats = new Statistics();

	// -----------------------------------------------------------------

	public Signal(final List<Complex> points, int period) {
		this.points = points;
		this.period = period;

		mean = getMean(period);
		sigma = getStandardDeviation(period);
	}

	public List<Complex> getPoints() {
		return points;
	}

	public double getMean(int period) {
		return stats.mean(this, period);
	}

	public double getStandardDeviation(int period) {
		return stats.standardDeviation(this, period);
	}

	public double getVariance(int period) {
		return stats.variance(this, period);
	}

	public double upperBand(Complex point, int nsd) {
		double meanMiddle = 0;
		return meanMiddle + sigma * nsd;
	}

	public double lowerBand(Complex point, int nsd) {
		double meanMiddle = 0;
		return meanMiddle - sigma * nsd;

	}

	public void addPoint(Complex point) {
		points.add(point);
		mean = getMean(period);
		sigma = getStandardDeviation(period);

	}

	// *
	// * @return : les bandes de bollinger du signal; target : représente la position 0 si bande du dessous, 1 si bande
	// de
	// * dessus ; nsd : number of standard deviation : paramètre représentant le nombre d'écarts types
	// */
	// public Signal bollingerBand(boolean target, int nsd) {
	// Signal meanMiddle = getMeanMiddleSignal(this);
	// List<Complex> points = new ArrayList<Complex>();
	//
	// if (!target) {
	// nsd = -nsd;
	// }
	// for (Complex point : meanMiddle.getPoints()) {
	// Complex bollingerPoint = new Complex(point.abs(), point.im() + nsd * this.getStandardDeviation());
	// points.add(bollingerPoint);
	// }
	//
	// return new Signal(points);
	// }
	//
	// private Signal getMeanMiddleSignal(Signal signal) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
