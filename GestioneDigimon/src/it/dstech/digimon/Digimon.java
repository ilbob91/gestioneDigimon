package it.dstech.digimon;

import java.io.Serializable;

public class Digimon implements Comparable<Digimon>, Serializable {
	private String nome;
	private int atk;
	private int def;
	private int res;
	private Evoluzione evo;

	public Digimon(String nome, int atk, int def, int res, Evoluzione evo) {
		super();
		this.nome = nome;
		this.atk = atk;
		this.def = def;
		this.res = res;
		this.evo = evo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public Evoluzione getEvo() {
		return evo;
	}

	public void setEvo(Evoluzione evo) {
		this.evo = evo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atk;
		result = prime * result + def;
		result = prime * result + ((evo == null) ? 0 : evo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + res;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Digimon other = (Digimon) obj;
		if (atk != other.atk)
			return false;
		if (def != other.def)
			return false;
		if (evo != other.evo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (res != other.res)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Digimon [nome=" + nome + ", atk=" + atk + ", def=" + def + ", res=" + res + ", evo=" + evo + "]";
	}

	@Override
	public int compareTo(Digimon o) {
		if (this.getAtk() < o.getAtk())
			return 1;
		if (this.getAtk() > o.getAtk())
			return -1;
		return 0;
	}

}
