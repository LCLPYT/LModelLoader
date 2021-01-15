package work.lclpnet.lmodelloader.data;

import java.util.List;

import net.minecraft.util.math.vector.Vector3f;

public class LModel {

	protected String name;
	protected List<LModelRenderer> renderers;
	protected Vector3f initialTranslation;
	
	public LModel(String name, List<LModelRenderer> renderers, Vector3f initialTranslation) {
		this.name = name;
		this.renderers = renderers;
		this.initialTranslation = initialTranslation;
	}
	
	public String getName() {
		return name;
	}
	
	public List<LModelRenderer> getRenderers() {
		return renderers;
	}
	
	public Vector3f getInitialTranslation() {
		return initialTranslation;
	}
	
}
