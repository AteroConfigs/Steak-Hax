package Kaden.modules.settings;

import java.util.Arrays;
import java.util.List;

public class ModeSetting extends Settings {

	public int Index;
	public List<String> modes;
	
	public ModeSetting(String name, String defaultMode, String... modes) {
		this.modes = Arrays.asList(modes);
		this.name = name;
		Index = this.modes.indexOf(defaultMode);
	}



	public String getMode() {
		return modes.get(Index);
	}

	public boolean is(String mode) {
		return Index == modes.indexOf(mode);
	}
	
	public void cycle() {
		if(Index < modes.size() - 1) {
			Index++;
		} else {
			Index = 0;
		}
	}
	
}