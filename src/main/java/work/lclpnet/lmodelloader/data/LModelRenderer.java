package work.lclpnet.lmodelloader.data;

import java.util.List;

import net.minecraft.util.math.vector.Vector3f;

public class LModelRenderer {

	protected String name;
	protected List<Cube> cubes;
	protected List<LModelRenderer> children;
	protected Vector3f rotationPoint;
	protected Vector3f rotation;
	protected boolean visible;
	
	public LModelRenderer(String name, List<Cube> cubes, List<LModelRenderer> children, Vector3f rotationPoint, Vector3f rotation, boolean visible) {
		this.name = name;
		this.cubes = cubes;
		this.children = children;
		this.rotationPoint = rotationPoint;
		this.rotation = rotation;
		this.visible = visible;
	}
	
	public List<LModelRenderer> getChildren() {
		return children;
	}
	
	public List<Cube> getCubes() {
		return cubes;
	}
	
	public String getName() {
		return name;
	}
	
	public Vector3f getRotationPoint() {
		return rotationPoint;
	}
	
	public Vector3f getRotation() {
		return rotation;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
}
