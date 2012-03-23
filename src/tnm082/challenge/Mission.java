package tnm082.challenge;

public class Mission {
	/**
	 * Kodad av: Magnus S/Markus O
	 * Task nr:4
	 * Datum: 2012-03-22
	 * Estimerad tid: 4h
	 * Faktisk tid: xh
	 * Testad/av: Ja/Nej / namn
	 * Utcheckad/av: Ja/Nej / namn
	 * @param namn - beskrivning.
	 * @return namn - beskrivning.

	 */
	
	private String name, desc;
	private int id;
	
	public Mission() {
		// Sätt -1 som standard
		this.id = -1;
	}
	
	public Mission(int Mid, String Mname, String Mdesc) {
		id = Mid;
		name = Mname;
		desc = Mdesc;	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		// Om man inte har satt så returnera en standard
		if(name == null)
			name = "No name set.";
		
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		// Om man inte har satt så returnera en standard
		if(desc == null)
			desc = "No description set.";
		
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
