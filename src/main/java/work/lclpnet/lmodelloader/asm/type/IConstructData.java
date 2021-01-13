package work.lclpnet.lmodelloader.asm.type;

import work.lclpnet.lmodelloader.data.Cube;

public interface IConstructData {

	Cube getConstructData();
	
	public static IConstructData cast(Object o) {
		return (IConstructData) o;
	}
	
}
