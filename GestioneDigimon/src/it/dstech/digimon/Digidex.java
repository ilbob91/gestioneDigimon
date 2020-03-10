package it.dstech.digimon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Digidex implements Serializable{
	List<Digimon> digidex;

	public Digidex() {
		super();
		this.digidex = new ArrayList<>();
	}

	public boolean aggiungiDigimon(Digimon d) {

		for (int i = 0; i < this.getDigidex().size(); i++) {
			if (d.getNome().equals(this.getDigidex().get(i).getNome())) {
				if (d.getEvo() == Evoluzione.BASE) {
					this.getDigidex().get(i).setEvo(Evoluzione.DIGIEVOLUZIONE);
					return true;
				}
				if (d.getEvo() == Evoluzione.DIGIEVOLUZIONE) {
					this.getDigidex().get(i).setEvo(Evoluzione.MEGA_DIGIEVOLUZIONE);
					return true;
				} 
				if (d.getEvo() == Evoluzione.MEGA_DIGIEVOLUZIONE) {
					this.getDigidex().get(i).setEvo(Evoluzione.ULTRA_DIGIEVOLUZIONE);
					return true;
				} else {
					return false;
					
				}
			} 
				
			} this.getDigidex().add(d);
				return true;
		}
		
	
	public void stampaDigimon() {
		System.out.println("ORDINE DI ATTACCO");
		Collections.sort(this.getDigidex());
		for (Digimon digimon : this.getDigidex()) {
			System.out.println(digimon);

		}
		System.out.println("############################");
		System.out.println("ORDINE DI DIFESA");
		Collections.sort(this.getDigidex(), new Comparator<Digimon>() {

			@Override
			public int compare(Digimon o1, Digimon o2) {
				if (o1.getDef() < o2.getDef())
					return 1;
				if (o1.getDef() > o2.getDef())
					return -1;
				return 0;
			}

		});
		for (Digimon digimon : this.getDigidex()) {
			System.out.println(digimon);

		}
		System.out.println("############################");
		System.out.println("ORDINE DI RESISTENZA");
		Collections.sort(this.getDigidex(), new Comparator<Digimon>() {

			@Override
			public int compare(Digimon o1, Digimon o2) {
				if (o1.getRes() < o2.getRes())
					return 1;
				if (o1.getRes() > o2.getRes())
					return -1;
				return 0;
			}

		});
		for (Digimon digimon : this.getDigidex()) {
			System.out.println(digimon);

		}
		System.out.println("############################");
		System.out.println("ORDINE DI EVOLUZIONE");
		Collections.sort(this.getDigidex(), new Comparator<Digimon>() {

			@Override
			public int compare(Digimon o1, Digimon o2) {
				// TODO Auto-generated method stub
				if (o1.getEvo() == Evoluzione.BASE) {
					if (o2.getEvo() == Evoluzione.DIGIEVOLUZIONE || o2.getEvo() == Evoluzione.MEGA_DIGIEVOLUZIONE
							|| o2.getEvo() == Evoluzione.ULTRA_DIGIEVOLUZIONE) {
						return 1;
					}
				}
				if (o1.getEvo() == Evoluzione.DIGIEVOLUZIONE) {
					if (o2.getEvo() == Evoluzione.BASE) {
						return -1;
					}
					if (o2.getEvo() == Evoluzione.MEGA_DIGIEVOLUZIONE
							|| o2.getEvo() == Evoluzione.ULTRA_DIGIEVOLUZIONE) {
						return 1;
					}
				}
				if (o1.getEvo() == Evoluzione.MEGA_DIGIEVOLUZIONE) {
					if (o2.getEvo() == Evoluzione.BASE || o2.getEvo() == Evoluzione.DIGIEVOLUZIONE) {
						return -1;
					}
					if (o2.getEvo() == Evoluzione.ULTRA_DIGIEVOLUZIONE) {
						return 1;
					}
				}
				if (o1.getEvo() == Evoluzione.ULTRA_DIGIEVOLUZIONE) {
					if (o2.getEvo() == Evoluzione.BASE || o2.getEvo() == Evoluzione.DIGIEVOLUZIONE
							|| o2.getEvo() == Evoluzione.MEGA_DIGIEVOLUZIONE) {
						return -1;
					}
				}
				return 0;
			}
		});

		for (Digimon digimon : this.getDigidex()) {
			System.out.println(digimon);
		}
		System.out.println("#############################");

	}

	public List<Digimon> getDigidex() {
		return digidex;
	}

	public void setDigidex(List<Digimon> digidex) {
		this.digidex = digidex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((digidex == null) ? 0 : digidex.hashCode());
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
		Digidex other = (Digidex) obj;
		if (digidex == null) {
			if (other.digidex != null)
				return false;
		} else if (!digidex.equals(other.digidex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Digidex [digidex=" + digidex + "]";
	}

}
