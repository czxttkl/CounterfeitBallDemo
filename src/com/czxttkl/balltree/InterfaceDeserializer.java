package com.czxttkl.balltree;

import java.lang.reflect.Type;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class InterfaceDeserializer implements JsonDeserializer<Node> {

	@Override
	public Node deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		if (json.isJsonObject()) {
			JsonObject jsonObject = json.getAsJsonObject();
			if (jsonObject.get("left_balls") != null) {
				TernaryDecisionTree bt = new TernaryDecisionTree();
				bt.left_balls = jsonArrayToIntArray(jsonObject.get("left_balls"));
				bt.right_balls = jsonArrayToIntArray(jsonObject.get("right_balls"));
				bt.heavier = context.deserialize(jsonObject.get("heavier"), TernaryDecisionTree.class);
				bt.lighter = context.deserialize(jsonObject.get("lighter"), TernaryDecisionTree.class);
				bt.equal = context.deserialize(jsonObject.get("equal"), TernaryDecisionTree.class);
				return bt;
			} else {
				if (jsonObject.get("counterfeit_ball")!=null) {
					int counterfeit_ball = jsonObject.get("counterfeit_ball").getAsInt();
					String weight = jsonObject.get("weight").getAsString();
					Leaf lf = new Leaf(counterfeit_ball, weight);
					return lf;
				}
			}

		} 
			
		return null;
	}

	
	private int[] jsonArrayToIntArray(JsonElement je) {
		JsonArray ja = je.getAsJsonArray();
		Iterator<JsonElement> iterator = ja.iterator();
		int[] balls = new int[ja.size()];
		for (int i =0; i < ja.size(); i++) {
			balls[i] = iterator.next().getAsInt();
		}
		return balls;
	}
}
