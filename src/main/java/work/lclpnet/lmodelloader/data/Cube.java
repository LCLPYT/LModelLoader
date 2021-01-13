package work.lclpnet.lmodelloader.data;

import net.minecraft.util.math.vector.Vector3f;

public class Cube {

	protected Vector3f position, dimensions, delta;
	protected boolean mirror;
	protected CubeTexture texture;
	
	public Cube(Vector3f position, Vector3f dimensions, Vector3f delta, boolean mirror, CubeTexture texture) {
		this.position = position;
		this.dimensions = dimensions;
		this.delta = delta;
		this.mirror = mirror;
		this.texture = texture;
	}
	
	public Vector3f getDelta() {
		return delta;
	}
	
	public Vector3f getDimensions() {
		return dimensions;
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public CubeTexture getTexture() {
		return texture;
	}
	
	public boolean isMirror() {
		return mirror;
	}
	
	public Cube copy() {
		return new Cube(this.position.copy(), this.dimensions.copy(), this.delta.copy(), this.mirror, this.texture.copy());
	}
	
}
