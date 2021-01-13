package work.lclpnet.lmodelloader.data;

public class CubeTexture {

	protected int offetX, offsetY;
	protected float width, height;
	
	public CubeTexture(int offsetX, int offsetY, float width, float height) {
		this.offetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
	}
	
	public int getOffetX() {
		return offetX;
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
		return new CubeTexture(this.offetX, this.offsetY, this.width, this.height);
	}
	
}
