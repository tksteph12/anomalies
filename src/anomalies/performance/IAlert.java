/**
 * 
 */
package anomalies.performance;

import anomalies.DataPoint;

/**
 * @author statchum
 * 
 */
public interface IAlert {
	void launch(DataPoint point);

}
