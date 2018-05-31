package programa;

import java.util.Arrays;

public class Exe {
	//DON'T TOUCH

	public void main(String[] conjs, String operacao) {
		String[] conjuntoA;
		String[] conjuntoB;
		Conjunto objA;
		Conjunto objB;

		switch(operacao) {
		case "União":
			conjuntoA = conjs[0].split(", ");
			objA = new Conjunto(conjuntoA);
			for (int i = 1;i<conjs.length;i++) {
				conjuntoB = conjs[i].split(", ");
				objB = new Conjunto(conjuntoB);
				objA.unionOfSets(objB);
			}
			break;
		case "Interseção":
			break;
		case "Complementar":
			break;
			
		}

		//obj.intersectionOfIntegersSets(objA, objB);

		//objA.insertElement(objA, 9);

		System.out.print("Grupo A: ");
		//System.out.println(Arrays.toString(objA.getNumeros()));

		System.out.print("Grupo B: ");
		//System.out.println(Arrays.toString(objB.getNumeros()));

		System.out.print("Grupo União: ");
		//System.out.println(Arrays.toString(obj.getNumerosUniao()));

		System.out.print("Grupo Intersecão: ");
		//System.out.println(Arrays.toString(obj.getNumerosIntersecao()));
	}
	//END DON'T TOUCH
}
