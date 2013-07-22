/**
 * 
 */
package anomalies.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import anomalies.Complex;
import anomalies.signal.Signal;

/**
 * @author statchum
 *
 */
public class TestStatistics {

	private  Signal signal;

	@Before
	public void buildSignal(){
		final List<Complex> points = new ArrayList<Complex>();
		Complex point;
		//-------------------------------------------------------

		for (int i=1;i<=60;i++){

			point= new Complex(i,i);
			points.add(point);
		}
		signal = new Signal(points);
	}

	@Test
	public void testMean() {
		Assert.assertEquals(30.5,signal.getMean(),0.01);
	}

	@Test
	public void testVariance() {
		Assert.assertEquals(299.9166667	,signal.getVariance(),0.01);
	}

	@Test
	public void testStandardDeviation() {
		Assert.assertEquals(17.31810228,signal.getStandardDeviation(),0.01);
	}
}
