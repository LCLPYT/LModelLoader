package work.lclpnet.lmodelloader.data;

public class CubeTexture {

	protected int offsetX, offsetY;
	protected float width, height;
	
	public CubeTexture(int offsetX, int offsetY, float width, float height) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
	}
	
	public int getOffetX() {
		return offsetX;
	}
	
	public int getOffsetY() {
		return offsetY;
	}

	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}

	public CubeTexture copy() {
		return new CubeTexture(this.offsetX, this.offsetY, this.width, this.height);
	}
	
}
