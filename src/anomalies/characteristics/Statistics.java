/**
 * Evaluate the prinipal characteristics of the signal
 * such as the mean , the variance, standard deviation,...
 */
package anomalies.characteristics;

import java.util.List;

import anomalies.Complex;
import anomalies.signal.Signal;

/**
 * @author statchum
 *
 */
public class Statistics {

	public Statistics(){
	}

	/*
	 * evaluates the mean of a signal
	 */
	public  double mean(final Signal signal){
		final List<Complex> points = signal.getPoints();
		double sum=0, mean = 0;

		for(final Complex point : points) {
			sum +=point.im();
		}
		mean = sum/points.size();

		return mean;
	}

	/*
	 * evaluates the variance of a signal
	 */
	public double variance(final Signal signal){
		final List<Complex> points = signal.getPoints();
		double sum=0, mean = 0;
		double variance = 0;

		for(final Complex point : points) {
			sum += point.im()*point.im();
		}
		mean = mean(signal);
		variance = sum/points.size()-mean*mean;

		return variance;
	}

	/*
	 * evaluates the standard deviation of a signal
	 */
	public double standardDeviation(final Signal signal){
		final double variance = variance(signal);
		return Math.sqrt(variance);
	}
}