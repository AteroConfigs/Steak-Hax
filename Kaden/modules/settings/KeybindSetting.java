package Kaden.modules.settings;

public class KeybindSetting extends Settings {


	public int code;
		
	public KeybindSetting(int code) {
		this.name = "KeyBind";
		this.code = code;
	}

	public int getKeyCode() {
		return code;
	}

	public void setKeyCode(int code) {
		this.code = code;
	}
		
}
