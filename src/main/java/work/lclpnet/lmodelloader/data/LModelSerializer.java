package work.lclpnet.lmodelloader.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LModelSerializer {

	private static final Gson gson;
	
	static {
		gson = new GsonBuilder()
				// register type adapters here
				.create();
	}
	
	public static LModel loadFromJson(String json) {
		return gson.fromJson(json, LModel.class);
	}
	
	public static String toJson(LModel model) {
		return gson.toJson(model);
	}
	
}
