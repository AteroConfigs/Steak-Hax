package Kaden.util.SaveLoad;

import java.io.*;
import java.util.ArrayList;

import Kaden.Client;
import Kaden.modules.MyModule;
import Kaden.modules.settings.BooleanSetting;
import Kaden.modules.settings.KeybindSetting;
import Kaden.modules.settings.ModeSetting;
import Kaden.modules.settings.NumberSetting;
import Kaden.modules.settings.Settings;

public class Load {

public static void main(){
	
	// Create the data objects for us to restore.

	Boolean[] TMs = new Boolean[Client.modules.size()];
	int[] KeyBinds = new int[Client.modules.size()];
	
	// Wrap all in a try/catch block to trap I/O errors.
	try{
	// Open file to read from, named SavedObj.sav.
	FileInputStream saveFile = new FileInputStream("./Steak." + Client.version);
	
	// Create an ObjectInputStream to get objects from save file.
	ObjectInputStream save = new ObjectInputStream(saveFile);
	
	// Now we do the restore.
	// readObject() returns a generic Object, we cast those back
	// into their original class type.
	// For primitive types, use the corresponding reference class.
	TMs = (Boolean[]) save.readObject();
	KeyBinds = (int[]) save.readObject();
	
	
	int i = 0;
	for (MyModule m : Client.modules) {
		if(i > Client.modules.size()) {
			break;
		}
		
		if(TMs[i] == null) {
			m.setToggleFalse();
		}
		if(TMs[i].booleanValue() == false) {
			m.setToggleFalse();
		}
		if(TMs[i].booleanValue() == true) {
			m.setToggleTrue();
		}

		for(Settings s : m.settings) {		
			if(s instanceof KeybindSetting) {
				KeybindSetting keybind = (KeybindSetting) s;
				keybind.setKeyCode(KeyBinds[i]);
			}
			

	}
		i++;
	}
	
	// Close the file.
	save.close(); // This also closes saveFile.
	}
	
	catch(Exception exc){
	exc.printStackTrace(); // If there was an error, print the info.
	}
	
	// Print the values, to see that they've been recovered.
	System.out.println();
	
	// All done.
	}
}
