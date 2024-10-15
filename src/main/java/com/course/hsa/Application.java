package com.course.hsa;


import com.course.hsa.bst.AVLTree;
import lombok.SneakyThrows;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Application {

	// Dataset size: 1000, 5000, 10000, 50000, 100000, 500000, 1000000

	public static void main(String[] args) {
		int testedDsSize = 1000;

		List<List<Integer>> datasets =  generateDatasets(testedDsSize, 100);

		var random = new Random().nextInt(testedDsSize);
		var stat = new Statistic();
		datasets.forEach(ds -> testDataset(ds, stat, random));

		System.out.println("Stat: " + stat);
	}

	private static void testDataset(List<Integer> dataset, Statistic stat, int value) {
		AVLTree tree = new AVLTree();
		dataset.forEach(tree::insert);

		collectInsertTime(tree, stat, value);
		collectSearchTime(tree, stat, value);
		collectDeleteTime(tree, stat, value);
	}

	private static List<List<Integer>> generateDatasets(int dsSize, int quantity) {
		var datasets = new ArrayList<List<Integer>>();
		for(int i=1; i<= quantity; i++) {
			var generated = new Random().ints(dsSize, 0, dsSize).boxed().toList();
			datasets.add(generated);
		}
		return datasets;
	}

	@SneakyThrows
	private static void collectInsertTime(AVLTree tree, Statistic stat, int value) {
		StopWatch timer = new StopWatch();
		timer.start();
		tree.insert(value);
		timer.stop();
		stat.getInsertTime().add(getTime(timer));
	}

	private static void collectSearchTime(AVLTree tree, Statistic stat, int value) {
		StopWatch timer = new StopWatch();
		timer.start();
		tree.find(value);
		timer.stop();
		stat.getSearchTime().add(getTime(timer));
	}

	private static void collectDeleteTime(AVLTree tree, Statistic stat, int value) {
		StopWatch timer = new StopWatch();
		timer.start();
		tree.delete(value);
		timer.stop();
		stat.getDeleteTime().add(getTime(timer));
	}

	private static double getTime(StopWatch timer) {
		return timer.getTotalTime(TimeUnit.NANOSECONDS);
	}
}
