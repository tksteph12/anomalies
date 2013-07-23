/**
 * Evaluate the prinipal characteristics of the signal
 * such as the mean , the variance, standard deviation,...
 */
package anomalies.statistics;

import java.util.List;

import anomalies.point.Complex;
import anomalies.signal.Signal;

/**
 * @author statchum
 * 
 */
public class Statistics {

	public Statistics() {
	}

	/*
	 * evaluates the mean of the last "period" mesures of a signal from limit position backward
	 */
	public double mean(final Signal signal, int period, int limit) {
		final List<Complex> points = signal.getPoints();
		double sum = 0, mean = 0;
		int start = (period > limit) ? 0 : limit - period;
		for (int i = start; i < limit; i++) {
			final Complex point = points.get(i);
			sum += point.im();
		}
		mean = sum / points.size();

		return mean;
	}

	/*
	 * evaluates the variance of the last "period" mesures of a signal from limit position backward
	 */
	public double variance(final Signal signal, int period, int limit) {
		final List<Complex> points = signal.getPoints();
		double sum = 0, mean = 0, mSum = 0;
		double variance = 0;

		int start = (period > limit) ? 0 : limit - period;
		for (int i = start; i < limit; i++) {
			final Complex point = points.get(i);
			sum += point.im() * point.im();
			mSum += point.im();
		}

		mean = mSum / points.size();
		variance = sum / points.size() - mean * mean;

		return variance;
	}

	/*
	 * evaluates the standard deviation of the last "period" mesures of a signal from limit position backward
	 */
	public double standardDeviation(final Signal signal, int period, int limit) {
		final double variance = variance(signal, period, limit);
		return Math.sqrt(variance);
	}
}