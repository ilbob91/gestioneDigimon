package it.dstech.digimon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Scanner;

public class GestioneDigimon {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Digidex digidex = new Digidex();

		try {
			
			digidex = caricamentoFile();
		

		while (true) {
			menu();
			System.out.println("cosa vuoi fare?");
			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1: {
				digidex.aggiungiDigimon(creaDigimon(scanner));
				salvataggioFile(digidex);
				break;
			}
			case 2: {
				digidex.stampaDigimon();
				break;
			}
			default: {
				salvataggioFile(digidex);
				scanner.close();
				System.exit(0);
			}
			}

		}} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	private static void menu() {
		System.out.println("1.crea e aggiungi digimon");
		System.out.println("2.stampa ");

	}

	public static Digimon creaDigimon(Scanner scanner) {
		System.out.println("dimmi il nome del digimon");
		String nome = scanner.nextLine();
		System.out.println("dimmi l'attacco");
		int atk = scanner.nextInt();
		System.out.println("dimmi la difesa");
		int def = scanner.nextInt();
		System.out.println("dimmi la resistenza");
		int res = scanner.nextInt();
		scanner.nextLine();
		System.out.println("dimmi l'evoluzione");
		Evoluzione evo = null;
		String enumerationLettaDaTastiera = scanner.nextLine();
		Evoluzione[] values = Evoluzione.values();
		for (Evoluzione evoluzione : values) {
			if (Evoluzione.valueOf(enumerationLettaDaTastiera).equals(evoluzione)) {
				evo = evoluzione;
			}
		}
		return new Digimon(nome, atk, def, res, evo);
	}

	private static Digidex caricamentoFile() throws IOException, ClassNotFoundException {
		File file = new File("digidex");
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream stream = new ObjectInputStream(in);
		Digidex digidex = (Digidex) stream.readObject();
		return digidex;
	}

	private static void salvataggioFile(Digidex digidex) throws IOException {
		File file = new File("digidex");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream stream = new ObjectOutputStream(out);
		stream.writeObject(digidex);
		stream.close();

	}

}
