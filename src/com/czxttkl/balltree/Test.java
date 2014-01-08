package com.czxttkl.balltree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Test {

	public static void main(String... arg) {
		BallTree bt = new BallTree();
		bt.left_balls = new int[] { 1};
		bt.right_balls = new int[] { 2};

		BallTree btLeft = new BallTree();
		btLeft.left_balls = new int[] { 1 };
		btLeft.right_balls = new int[] { 3 };
		btLeft.heavier = new Leaf(1, "heavier");
		btLeft.lighter = null;
		btLeft.equal = new Leaf(2, "lighter");

		BallTree btRight = new BallTree();
		btRight.left_balls = new int[] { 1 };
		btRight.right_balls = new int[] { 3 };
		btRight.heavier = null;
		btRight.lighter = new Leaf(1, "lighter");
		btRight.equal = new Leaf(2, "heavier");

		BallTree btEqual = new BallTree();
		btEqual.left_balls = new int[] { 1 };
		btEqual.right_balls = new int[] { 3 };
		btEqual.heavier = new Leaf(3, "lighter");
		btEqual.lighter = new Leaf(3, "heavier");
		btEqual.equal = new Leaf(4, "heavier");

		bt.heavier = btLeft;
		bt.lighter = btRight;
		bt.equal = btEqual;

//		JSONSerializer ser = new JSONSerializer();
//		String jsonString = ser.deepSerialize(bt);
		

		
		
		
		Gson gson = new GsonBuilder().registerTypeAdapter(BallTree.class, new InterfaceDeserializer()).create();
		String jsonString2 = gson.toJson(bt, BallTree.class);
		System.out.println(jsonString2);
		Node bt2 = gson.fromJson(jsonString2, BallTree.class);
		
		
		
		
		
		
		
//		final TypeToken<Node> requestListTypeToken = new TypeToken<Node>() {
//		};
//
//		final RuntimeTypeAdapterFactory<Node> typeFactory = RuntimeTypeAdapterFactory.of(Node.class, "type").registerSubtype(BallTree.class).registerSubtype(Leaf.class);
//
//		// Gson gson = new GsonBuilder().registerTypeAdapter(Node.class, new InterfaceAdapter<Node>()).create();
//		final Gson gson = new GsonBuilder().registerTypeAdapterFactory(typeFactory).create();
//		String jsonString = gson.toJson(bt, BallTree.class);
//		System.out.println(jsonString);
//
//		JSONDeserializer<BallTree> der = new JSONDeserializer<BallTree>();
//		BallTree jsonToBallTree = der.deserialize(jsonString2, BallTree.class);
		
		
		
		

	}
}
