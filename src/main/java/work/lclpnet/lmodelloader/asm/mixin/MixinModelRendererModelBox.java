package work.lclpnet.lmodelloader.asm.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.renderer.model.ModelRenderer.ModelBox;
import net.minecraft.util.math.vector.Vector3f;
import work.lclpnet.lmodelloader.asm.type.IConstructData;
import work.lclpnet.lmodelloader.data.Cube;
import work.lclpnet.lmodelloader.data.CubeTexture;

@Mixin(ModelBox.class)
public class MixinModelRendererModelBox implements IConstructData {

	private Cube constructData;
	
	@Inject(
			method = "Lnet/minecraft/client/renderer/model/ModelRenderer$ModelBox;<init>("
					+ "IIFFFFFFFFFZFF"
					+ ")V",
			at = @At("RETURN")
			)
	public void onConstruct(int texOffX, int texOffY, float x, float y, float z, float width, float height, float depth, 
			float deltaX, float deltaY, float deltaZ, boolean mirrorIn, float texWidth, float texHeight, CallbackInfo ci) {
		
		Vector3f position = new Vector3f(
				mirrorIn ? x - width - deltaX : x + deltaX, 
				y + deltaY, 
				z + deltaZ);
		Vector3f dimensions = new Vector3f(width, height, depth);
		Vector3f delta = new Vector3f(deltaX, deltaY, deltaZ);
		
		CubeTexture texture = new CubeTexture(texOffX, texOffY, texWidth, texHeight);
		
		this.constructData = new Cube(position, dimensions, delta, mirrorIn, texture);
	}

	@Override
	public Cube getConstructData() {
		return constructData;
	}
	
}
