package com.amazonaws.lambda.xmenrecruitment;

public class MutantXmen {
	private static MutantXmen MutantXmenInstance;
	private String[] inputValid = { "A", "T", "C", "G" };

	private MutantXmen() {
	}

	// Método sincronizado que nos asegura que sólo puede haber una instancia de
	// nuestra clase
	private synchronized static void createInstance() {
		if (MutantXmenInstance == null)
			MutantXmenInstance = new MutantXmen();
	}

	public static MutantXmen getInstance() {
		createInstance();
		return MutantXmenInstance;
	}

	public boolean isMutant(String[] data) throws Exception {

		if (!isValidInput(data)) {
			throw new Exception("Entrada inválida. Se esperan únicamente los carácteres (A,T,C,G).");

		} else {

			if (!isSizeValid(data)) {
				throw new Exception("Entrada inválida. Se espera una tabla (N x N).");

			} else {

				if (data.length < 4)
					return false;

				if ((isMutantHor(data) + isMutantVert(data) + isMutantDiag(data)) > 1)
					return true;

			}
		}

		return false;
	}

	private boolean isValidInput(String[] data) {
		char[] chain;
		boolean contain = false;

		for (int i = 0; i < data.length; i++) {
			chain = data[i].toCharArray();

			for (int j = 0; j < chain.length; j++) {

				for (int k = 0; k < inputValid.length; k++) {

					if (inputValid[k].equalsIgnoreCase(String.valueOf(chain[j]))) {
						contain = true;
						break;
					}

				}

				if (!contain)
					return false;

			}
		}

		return true;
	}

	private boolean isSizeValid(String[] data) {

		for (int i = 0; i < data.length; i++) {

			if (data[i].length() != data.length)
				return false;

		}

		return true;
	}

	private int isMutantHor(String[] data) {
		int four = 0;

		if (data.length == 4) {

			for (int i = 0; i < 3; i++) {

				if (data[i].substring(0, 1).equalsIgnoreCase(data[i].substring(1, 2))
						&& data[i].substring(0, 1).equalsIgnoreCase(data[i].substring(2, 3))
						&& data[i].substring(0, 1).equalsIgnoreCase(data[i].substring(3)))
					four++;

			}

		} else {

			for (int i = 0; i < data.length; i++) {

				for (int j = 0; j < (data.length - 4); j++) {

					if (data[i].substring(j, j + 1).equalsIgnoreCase(data[i].substring(j + 1, j + 2))
							&& data[i].substring(j, j + 1).equalsIgnoreCase(data[i].substring(j + 2, j + 3))
							&& data[i].substring(j, j + 1).equalsIgnoreCase(data[i].substring(j + 3, j + 4)))
						four++;

				}

			}

		}

		return four;
	}

	private int isMutantVert(String[] data) {
		int four = 0;

		if (data.length == 4) {
			for (int i = 0; i < 3; i++) {

				if (data[0].substring(i, i + 1).equalsIgnoreCase(data[1].substring(i, i + 1))
						&& data[0].substring(i, i + 1).equalsIgnoreCase(data[2].substring(i, i + 1))
						&& data[0].substring(i, i + 1).equalsIgnoreCase(data[3].substring(i, i + 1)))
					four++;

			}
		} else {
			for (int i = 0; i < (data.length - 3); i++) {

				for (int j = 0; j < (data.length - 3); j++) {

					if (data[i].substring(j, j + 1).equalsIgnoreCase(data[i + 1].substring(j, j + 1))
							&& data[i].substring(j, j + 1).equalsIgnoreCase(data[i + 2].substring(j, j + 1))
							&& data[i].substring(j, j + 1).equalsIgnoreCase(data[i + 3].substring(j, j + 1)))
						four++;

				}

			}
		}

		return four;
	}

	private int isMutantDiag(String[] data) {
		int four = 0;

		if (data.length == 4) {

			if (data[0].substring(0, 1).equalsIgnoreCase(data[1].substring(1, 2))
					&& data[0].substring(0, 1).equalsIgnoreCase(data[2].substring(2, 3))
					&& data[0].substring(0, 1).equalsIgnoreCase(data[3].substring(3)))
				four++;

			if (data[3].substring(0, 1).equalsIgnoreCase(data[1].substring(2, 3))
					&& data[3].substring(0, 1).equalsIgnoreCase(data[2].substring(1, 2))
					&& data[3].substring(0, 1).equalsIgnoreCase(data[0].substring(3)))
				four++;

		} else {
			for (int i = 0; i < (data.length - 3); i++) {

				for (int j = 0; j < (data.length - 4); j++) {

					if (data[i].substring(j, j + 1).equalsIgnoreCase(data[i + 1].substring(j + 1, j + 2))
							&& data[i].substring(j, j + 1).equalsIgnoreCase(data[i + 2].substring(j + 2, j + 3))
							&& data[i].substring(j, j + 1).equalsIgnoreCase(data[i + 3].substring(j + 3, j + 4)))
						four++;

					if (data[i + 3].substring(j, j + 1).equalsIgnoreCase(data[i + 1].substring(j + 2, j + 3))
							&& data[i + 3].substring(j, j + 1).equalsIgnoreCase(data[i + 2].substring(j + 1, j + 2))
							&& data[i + 3].substring(j, j + 1).equalsIgnoreCase(data[i].substring(j + 3, j + 4)))
						four++;

				}

			}
		}

		return four;
	}
}
