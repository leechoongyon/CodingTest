package codingtest.site.solveProblemsExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Q25_geniusAlgorithm {

	// variable declare

	// case 1
	int n = 3; // Music Number Condition
	double k = 6.5; // Music Play Time Condition
	
	int arrayFavoriteSongs[] = new int[3];
	double arrayPlayProbability[][] = new double[3][3];

	ArrayList<DataSet> listMusicPlayTime;
	HashMap<Integer, Double> hashMapPickedProbability;

	public static void main(String[] args) {
		ArrayList<Integer> listMusicPicked = new ArrayList<Integer>();
		listMusicPicked.add(0); // startIndex SeqNo 0

		Q25_geniusAlgorithm genius = new Q25_geniusAlgorithm();
		genius.init();
		genius.process(listMusicPicked);
		genius.printAll();
	}

	public void init() {

		// Case 1
		arrayFavoriteSongs[0] = 0;
		arrayFavoriteSongs[1] = 1;
		arrayFavoriteSongs[2] = 2;

		arrayPlayProbability[0][0] = 0.18;
		arrayPlayProbability[0][1] = 0.40;
		arrayPlayProbability[0][2] = 0.42;
		arrayPlayProbability[1][0] = 0.15;
		arrayPlayProbability[1][1] = 0.46;
		arrayPlayProbability[1][2] = 0.39;
		arrayPlayProbability[2][0] = 0.58;
		arrayPlayProbability[2][1] = 0.23;
		arrayPlayProbability[2][2] = 0.19;

		listMusicPlayTime = new ArrayList<DataSet>();
		DataSet dataSet = new DataSet();
		dataSet.SeqNo = 0;
		dataSet.playTime = 4;
		listMusicPlayTime.add(dataSet);

		DataSet dataSet1 = new DataSet();
		dataSet1.SeqNo = 1;
		dataSet1.playTime = 4;
		listMusicPlayTime.add(dataSet1);

		DataSet dataSet2 = new DataSet();
		dataSet2.SeqNo = 2;
		dataSet2.playTime = 2;
		listMusicPlayTime.add(dataSet2);

		hashMapPickedProbability = new HashMap<Integer, Double>();

	}

	public void process(ArrayList<Integer> listMusicPicked) {

		// 1. Make a Music FlowChart that it is Picked.

		if (isStopCondition(listMusicPicked)) {

			// 2. calculate Music Play Probability

			calculateMusicPlayProbability(listMusicPicked);

			return;
		}

		for (int next = 0; next < n; next++) {
			listMusicPicked.add(next);
			process(listMusicPicked);
			listMusicPicked.remove(listMusicPicked.size() - 1);
		}
	}

	public void calculateMusicPlayProbability(ArrayList<Integer> listMusicPicked) {

		// Check LastPicked Favorite Music

		if (isFavoriteMusic(listMusicPicked))
			return;

		// calculate Probability (By first Index -> Last Index)

		int currentPicked = listMusicPicked.get(0);
		int nextPicked = 0;
		double totalProbability = 1.0;

		for (int next = 1; next < listMusicPicked.size(); next++) {
			nextPicked = listMusicPicked.get(next);
			totalProbability = totalProbability * arrayPlayProbability[currentPicked][nextPicked];
			currentPicked = nextPicked;
		}

		// total Probability

		int lastPicked = listMusicPicked.get(listMusicPicked.size() - 1);
		boolean containKey = hashMapPickedProbability.containsKey(lastPicked);
		double exisitingProbability = 0.0;

		if (!containKey)
			hashMapPickedProbability.put(lastPicked, totalProbability);
		else {
			exisitingProbability = hashMapPickedProbability.get(lastPicked);
			hashMapPickedProbability.put(lastPicked, totalProbability
					+ exisitingProbability);
		}
		System.out.println("lastPicked : " + lastPicked + " \t lastPicked.value() : " + hashMapPickedProbability.get(lastPicked));
	}

	public boolean isStopCondition(ArrayList<Integer> musicPicked) {

		// variable declare

		boolean status = false;

		int musicSeqNo = 0;
		double totalPickedMusicPlayTime = 0;

		// Check Stop Condition
		// desc : Total Music Play Time < musicPicked Play Time == true

		for (int i = 0; i < musicPicked.size(); i++) {
			musicSeqNo = musicPicked.get(i);
			totalPickedMusicPlayTime += listMusicPlayTime.get(musicSeqNo).playTime;
		}

		if (totalPickedMusicPlayTime > k)
			status = true;
		return status;
	}

	public boolean isFavoriteMusic(ArrayList<Integer> musicPicked) {

		boolean status = false;
		int lastPicked = musicPicked.get(musicPicked.size() - 1);
		for (int i = 0; i < arrayFavoriteSongs.length; i++)
			if (lastPicked == arrayFavoriteSongs[i])
				break;
			else if (i == arrayFavoriteSongs.length - 1)
				status = true;
		return status;
	}

	public void printAll() {
		int key = 0;

		Iterator<Integer> iter = hashMapPickedProbability.keySet().iterator();

		while (iter.hasNext()) {
			key = iter.next();
			System.out.println("key : " + key + " \t value : " + hashMapPickedProbability.get(key));
		}
	}

	class DataSet {
		int SeqNo;
		int playTime;
	}
}
