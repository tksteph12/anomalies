/**
 * 
 */
package anomalies.signal;

import java.util.List;

import anomalies.Complex;
import anomalies.characteristics.Statistics;

/**
 * @author statchum
 *
 */
public class Signal {
	// Un signal est une liste de nombre complexes
	private final List<Complex> points;

	public static Statistics stats = new Statistics();

	//-----------------------------------------------------------------

	public Signal(final List<Complex> points){
		this.points = points;
	}

	public List<Complex> getPoints(){
		return points;
	}

	public double getMean(){
		return stats.mean(this);
	}

	public double getStandardDeviation(){
		return stats.standardDeviation(this);
	}

	public double getVariance(){
		return stats.variance(this);
	}

}
