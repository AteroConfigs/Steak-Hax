package Kaden.util.SaveLoad;

import java.io.*;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import Kaden.Client;
import Kaden.modules.MyModule;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.KeybindSetting;
import Kaden.modules.settings.ModeSetting;
import Kaden.modules.settings.NumberSetting;
import Kaden.modules.settings.Settings;

	public class Save {

	public static void main(){
	// Create some data objects for us to save.
	Boolean[] TMs = new Boolean[Client.modules.size()];
	int[] KeyBinds = new int[Client.modules.size()];
	
	
	int i = 0;
	for (MyModule m : Client.modules) {
		
		if(i > Client.modules.size()) {
			break;
		}
		
		if(m.isEnabled()) {
			TMs[i] = Boolean.TRUE;
		} else {
			TMs[i] = Boolean.FALSE;
		}

		
		for(Settings s : m.settings) {			
			if(s instanceof KeybindSetting) {
				KeybindSetting keybind = (KeybindSetting) s;
				KeyBinds[i] = keybind.getKeyCode();
			}
			

	}
		i++;
	}

	try{ 
	// Catch errors in I/O if necessary.
	// Open a file to write to, named SavedObj.sav.
	FileOutputStream saveFile = new FileOutputStream("./Steak." + Client.version);

	// Create an ObjectOutputStream to put objects into save file.
	ObjectOutputStream save = new ObjectOutputStream(saveFile);

	// Now we do the save.
	save.writeObject(TMs);
	save.writeObject(KeyBinds);

	// Close the file.
	save.close(); // This also closes saveFile.
	}
	
	catch(Exception exc){
	exc.printStackTrace(); // If there was an error, print the info.
	}	
	}
	
	


}
