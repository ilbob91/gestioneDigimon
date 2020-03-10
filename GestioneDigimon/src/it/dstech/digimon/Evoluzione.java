package it.dstech.digimon;

public enum Evoluzione {
	BASE("BASE"), DIGIEVOLUZIONE("DIGIEVOLUZIONE"), MEGA_DIGIEVOLUZIONE("MEGA_DIGIEVOLUZIONE"),
	ULTRA_DIGIEVOLUZIONE("ULTRA_DIGIEVOLUZIONE");

	private String value;

	Evoluzione(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
