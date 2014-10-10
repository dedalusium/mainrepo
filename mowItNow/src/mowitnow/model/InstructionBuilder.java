package mowitnow.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructionBuilder {
	public static List<InstructionSet> load(String path) throws IOException {
		List<InstructionSet> list = new ArrayList<InstructionSet>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		InstructionSet instructionSet = new InstructionSet();
		int nb = 0;
		while ((line = br.readLine()) != null) {
			// on ignore la premiere ligne
			if (nb != 0) {
				if (nb % 2 == 0) {
					instructionSet.setMoves(line);
					list.add(instructionSet);
					instructionSet = new InstructionSet();
				} else if (nb % 2 == 1) {
					instructionSet.setInitX(line.charAt(0));
					instructionSet.setInitY(line.charAt(1));
					instructionSet.setInitDir(line.charAt(2));
				}
			}
		}
		br.close();
		return list;
	}

	public static int[] getGridSize(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		int[] size = { line.charAt(0), line.charAt(1) };
		br.close();
		return size;
	}
}
