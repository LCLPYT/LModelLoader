package work.lclpnet.lmodelloader.data;

import java.util.List;

public class LModel {

	protected String name;
	protected List<LModelRenderer> renderers;
	
	public LModel(String name, List<LModelRenderer> renderers) {
		this.name = name;
		this.renderers = renderers;
	}
	
	public String getName() {
		return name;
	}
	
	public List<LModelRenderer> getRenderers() {
		return renderers;
	}
	
}
