package io.czxttkl.github.tdt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestMain {

	public static void main(String... arg) {
		// Construct a ternary decision tree manually according to the sample dabate on:
		// http://www.ccs.neu.edu/home/lieber/courses/algorithms/cs5800/sp14/labs/counterfeit-ball.html
		TernaryDecisionTree tdtLeft = new TernaryDecisionTree();
		tdtLeft.left_balls = new int[] { 1 };
		tdtLeft.right_balls = new int[] { 3 };
		tdtLeft.heavier = new Leaf(1, "heavier");
		tdtLeft.lighter = null;
		tdtLeft.equal = new Leaf(2, "lighter");

		TernaryDecisionTree tdtRight = new TernaryDecisionTree();
		tdtRight.left_balls = new int[] { 1 };
		tdtRight.right_balls = new int[] { 3 };
		tdtRight.heavier = null;
		tdtRight.lighter = new Leaf(1, "lighter");
		tdtRight.equal = new Leaf(2, "heavier");

		TernaryDecisionTree tdtEqual = new TernaryDecisionTree();
		tdtEqual.left_balls = new int[] { 1 };
		tdtEqual.right_balls = new int[] { 3 };
		tdtEqual.heavier = new Leaf(3, "lighter");
		tdtEqual.lighter = new Leaf(3, "heavier");
		tdtEqual.equal = new Leaf(4, "heavier");
		
		TernaryDecisionTree tdt = new TernaryDecisionTree();
		tdt.left_balls = new int[] { 1 };
		tdt.right_balls = new int[] { 2 };
		tdt.heavier = tdtLeft;
		tdt.lighter = tdtRight;
		tdt.equal = tdtEqual;

		// Create a Gson instance to convert TernaryDecisionTree Java Object into JSON String
		Gson gson = new GsonBuilder().registerTypeAdapter(TernaryDecisionTree.class, new InterfaceDeserializer()).create();
		String jsonString = gson.toJson(tdt, TernaryDecisionTree.class);
		System.out.println(jsonString);

		// Restore TernaryDecisionTree Java Object from JSON String
		TernaryDecisionTree tdtRestored = gson.fromJson(jsonString, TernaryDecisionTree.class);

		// Do your verification here...
	}
}
