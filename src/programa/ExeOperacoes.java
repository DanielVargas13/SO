package programa;


public class ExeOperacoes {
	public static void main(String[] args) {
		String[] conjuntoA = {"1", "2", "3"};
		String[] conjuntoB = {"2", "3", "4", "5"};
		Conjunto objA;
		Conjunto objB;

		//switch(operacao) {
		//case "União":
			//conjuntoA = conjs[0].split(", ");
			objA = new Conjunto(conjuntoA);
			
				//conjuntoB = conjs[i].split(", ");
				objB = new Conjunto(conjuntoB);
				objA.unionOfSets(objB);
			
			//break;
	//	case "Interseção":
		//	break;
	//case "Complementar":
			//break;
			
	//	}

		//obj.intersectionOfIntegersSets(objA, objB);

		//objA.insertElement(objA, 9);

		System.out.print("Grupo A: ");
		System.out.println(objA.getNumeros());

		System.out.print("Grupo B: ");
		System.out.println(objB.getNumeros());

		System.out.print("Grupo União: ");
		System.out.println(objA.getNumerosUniao());

		objA = new Conjunto(conjuntoA);
		
		//conjuntoB = conjs[i].split(", ");
		objB = new Conjunto(conjuntoB);
		objA.intersectionOfSets(objB);
		
		System.out.print("Grupo Intersecão: ");
		System.out.println(objA.getNumerosIntersecao());
		
		objA = new Conjunto(conjuntoA);
		
		//conjuntoB = conjs[i].split(", ");
		objB = new Conjunto(conjuntoB);
		objA.complementOfSets(objB);
		
		System.out.print("Grupo Complemento: ");
		System.out.println(objA.getNumerosComplemento());
	}
}
