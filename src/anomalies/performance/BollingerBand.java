package anomalies.performance;

import java.util.ArrayList;
import java.util.List;

import anomalies.DataPoint;
import anomalies.signal.Signal;
import anomalies.statistics.Statistics;

public class BollingerBand {
	private final Signal meanMiddleBand;
	private final Signal upperBand;
	private final Signal lowerBand;
	private int nsd;
	private static Statistics stats = new Statistics();

	public BollingerBand(Signal signal) {
		nsd = 2;
		meanMiddleBand = meanMiddleBand(signal);
		upperBand = upperBand(signal, nsd);
		lowerBand = lowerBand(signal, nsd);
	}

	private Signal lowerBand(Signal signal, int nsd) {
		List<DataPoint> points = new ArrayList<DataPoint>();
		DataPoint point;
		List<DataPoint> listPoints = signal.getPoints();
		for (int i = 0; i < listPoints.size(); i++) {
			point = listPoints.get(i);
			double mean = stats.mean(signal, listPoints.size(), i + 1);
			double sigma = stats.standardDeviation(signal, listPoints.size(), i + 1);
			point = new DataPoint(point.getDate(), mean - nsd * sigma);
			points.add(point);
		}

		return new Signal(points, points.size());
	}

	private Signal upperBand(Signal signal, int nsd) {
		List<DataPoint> points = new ArrayList<DataPoint>();
		DataPoint point;
		List<DataPoint> listPoints = signal.getPoints();
		for (int i = 0; i < listPoints.size(); i++) {
			point = listPoints.get(i);
			double mean = stats.mean(signal, listPoints.size(), i + 1);
			double sigma = stats.standardDeviation(signal, listPoints.size(), i + 1);
			point = new DataPoint(point.getDate(), mean + nsd * sigma);
			points.add(point);
		}

		return new Signal(points, points.size());
	}

	private Signal meanMiddleBand(Signal signal) {
		List<DataPoint> points = new ArrayList<DataPoint>();
		DataPoint point;
		List<DataPoint> listPoints = signal.getPoints();
		for (int i = 0; i < listPoints.size(); i++) {
			point = listPoints.get(i);
			double mean = stats.mean(signal, listPoints.size(), i + 1);
			point = new DataPoint(point.getDate(), mean);
			points.add(point);
		}
		return new Signal(points, points.size());
	}

	public Signal getMeanMiddleBand() {
		return meanMiddleBand;
	}

	public Signal getUpperBand() {
		return upperBand;
	}

	public Signal getLowerBand() {
		return lowerBand;
	}
}
