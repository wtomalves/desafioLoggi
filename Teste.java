import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {

		

		String[] pacote = new String[20];

		pacote[0] = "288355555123888";
		pacote[1] = "335333555584333";
		pacote[2] = "223343555124001";
		pacote[3] = "002111555874555";
		pacote[4] = "111188555654777";
		pacote[5] = "111333555123333";
		pacote[6] = "432055555123888";
		pacote[7] = "079333555584333";
		pacote[8] = "155333555124001";
		pacote[9] = "333188555584333";
		pacote[10] = "555288555123001";
		pacote[11] = "111388555123555";
		pacote[12] = "288000555367333";
		pacote[13] = "066311555874001";
		pacote[14] = "110333555123555";
		pacote[15] = "333488555584333";
		pacote[16] = "455448555123001";
		pacote[17] = "022388555123555";
		pacote[18] = "432044555845333";
		pacote[19] = "034311555874001";

		CodigoBarras[] codBarras = new CodigoBarras[20];

		for (int i = 0; i < pacote.length; i++) {
			CodigoBarras codigoBarras = new CodigoBarras(pacote[i]);
			codBarras[i] = codigoBarras;
		}

		int somaCentroOeste = 0;
		int somaNordeste = 0;
		int somaNorte = 0;
		int somaSudeste = 0;
		int somaSul = 0;
		int somaRegiaoNaoAtendida = 0;
		int somaTotalPacotes = 0;
		int naoAtendida = 0;
		for (int i = 0; i < codBarras.length; i++) {
			if (codBarras[i].getRegiaoDestino() >= 201 && codBarras[i].getRegiaoDestino() <= 299) {
				somaCentroOeste += 1;
			} else if (codBarras[i].getRegiaoDestino() >= 300 && codBarras[i].getRegiaoDestino() <= 399) {
				somaNordeste += 1;
			} else if (codBarras[i].getRegiaoDestino() >= 400 && codBarras[i].getRegiaoDestino() <= 499) {
				somaNorte += 1;
			} else if (codBarras[i].getRegiaoDestino() >= 1 && codBarras[i].getRegiaoDestino() <= 99) {
				somaSudeste += 1;
			} else if (codBarras[i].getRegiaoDestino() >= 100 && codBarras[i].getRegiaoDestino() <= 199) {
				somaSul += 1;
			} else {
				naoAtendida += 1;
			}
			somaTotalPacotes += 1;
		}
		System.out.println("1. Identificar a região de destino de cada pacote, com totalização de\r\n"
				+ "pacotes (soma região): ");
		System.out.println("Centro-oeste: " + somaCentroOeste);
		System.out.println("Nordeste: " + somaNordeste);
		System.out.println("Norte: " + somaNorte);
		System.out.println("Sudeste: " + somaSudeste);
		System.out.println("Sul: " + somaSul);
		System.out.println("Região não atendida ou Inexistente: " + naoAtendida);
		System.out.println("Soma Total dos Pacotes: " + somaTotalPacotes);

		System.out.println("\n");

		/// pacote validos
		System.out.println("2. Saber quais pacotes possuem códigos de barras válidos e/ou\r\n" + "inválidos: ");
		System.out.print("Pacotes válidos: ");

		ArrayList<Integer> validos = new ArrayList();
		ArrayList<Integer> invalidos = new ArrayList();
		ArrayList<Integer> produtosValidos = new ArrayList();
		
		produtosValidos.add(1);
		produtosValidos.add(111);
		produtosValidos.add(333);
		produtosValidos.add(555);
		produtosValidos.add(888);
		

		for (int i = 0; i < codBarras.length; i++) {

			if ((codBarras[i].getRegiaoOrigem() >= 1 && codBarras[i].getRegiaoOrigem() <= 499)
					&& (codBarras[i].getRegiaoDestino() >= 1 && codBarras[i].getRegiaoDestino() <= 499
							&& codBarras[i].getCodigoVendedor() != 367) && 
					produtosValidos.contains(codBarras[i].getTipoProduto())) {
				validos.add(i + 1);
			} else {
				invalidos.add(i + 1);
			}

		}
		System.out.println("Pacotes válidos: " + validos);
		System.out.println("Pacotes invalidos: " + invalidos);

		System.out.println("\n\n");

		System.out.println(
				"3. Identificar os pacotes que têm como origem a região Sul e\r\n" + "Brinquedos em seu conteúdo: ");

		ArrayList<Integer> origemSulBrinquedos = new ArrayList();
		for (int i = 0; i < codBarras.length; i++) {
			if (codBarras[i].getRegiaoOrigem() >= 100 && codBarras[i].getRegiaoOrigem() <= 199
					&& codBarras[i].getTipoProduto() == 888) {
				origemSulBrinquedos.add(i + 1);
			}

		}

		if (origemSulBrinquedos.size() == 0) {
			System.out.println("Não foram encontrados pacotes");
		} else {
			System.out.println("Pacotes: " + origemSulBrinquedos);
		}
		System.out.println("\n");

		System.out.println(
				"4. Listar os pacotes agrupados por região de destino (Considere apenas\r\n" + "pacotes válidos): ");

		ArrayList<Integer> centroOeste = new ArrayList<Integer>();
		ArrayList<Integer> nordeste = new ArrayList<Integer>();
		ArrayList<Integer> norte = new ArrayList<Integer>();
		ArrayList<Integer> sudeste = new ArrayList<Integer>();
		ArrayList<Integer> sul = new ArrayList<Integer>();

		for (int i = 0; i < codBarras.length; i++) {

			if (invalidos.contains(i + 1)) {
				continue;
			}

			if (codBarras[i].getRegiaoDestino() >= 201 && codBarras[i].getRegiaoDestino() <= 299) {
				centroOeste.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 300 && codBarras[i].getRegiaoDestino() <= 399) {
				nordeste.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 400 && codBarras[i].getRegiaoDestino() <= 499) {
				norte.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 1 && codBarras[i].getRegiaoDestino() <= 99) {
				sudeste.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 100 && codBarras[i].getRegiaoDestino() <= 199) {
				sul.add(i + 1);
			}

		}
		System.out.println("Centro-Oeste: " + centroOeste);
		System.out.println("Nordeste: " + nordeste);
		System.out.println("Norte: " + norte);
		System.out.println("Sudeste: " + sudeste);
		System.out.println("Sul " + sul);

		System.out.println("\n");

		System.out.println("5. Listar o número de pacotes enviados por cada vendedor (Considere\r\n"
				+ "apenas pacotes válidos): ");

		ArrayList<Integer> vendedor123 = new ArrayList<Integer>();
		ArrayList<Integer> vendedor124 = new ArrayList<Integer>();
		ArrayList<Integer> vendedor367 = new ArrayList<Integer>();
		ArrayList<Integer> vendedor584 = new ArrayList<Integer>();
		ArrayList<Integer> vendedor654 = new ArrayList<Integer>();
		ArrayList<Integer> vendedor845 = new ArrayList<Integer>();
		ArrayList<Integer> vendedor874 = new ArrayList<Integer>();

		for (int i = 0; i < codBarras.length; i++) {

			if (invalidos.contains(i + 1)) {
				continue;
			}
			if (codBarras[i].getCodigoVendedor() == 123) {
				vendedor123.add(i + 1);
			} else if (codBarras[i].getCodigoVendedor() == 124) {
				vendedor124.add(i + 1);
			} else if (codBarras[i].getCodigoVendedor() == 584) {
				vendedor584.add(i + 1);
			} else if (codBarras[i].getCodigoVendedor() == 654) {
				vendedor654.add(i + 1);
			} else if (codBarras[i].getCodigoVendedor() == 845) {
				vendedor845.add(i + 1);
			} else if (codBarras[i].getCodigoVendedor() == 874) {
				vendedor874.add(i + 1);
			}
		}

		System.out.println("Codigo Vendedor 123:  " + vendedor123 + " Quantidade: " + vendedor123.size());
		System.out.println("Codigo Vendedor 124:  " + vendedor124 + "  Quantidade: " + vendedor124.size());
		System.out.println("Codigo Vendedor 584:  " + vendedor584 + " Quantidade: " + vendedor584.size());
		System.out.println("Codigo Vendedor 654:  " + vendedor654 + " Quantidade: " + vendedor654.size());
		System.out.println("Codigo Vendedor 845:  " + vendedor845 + " Quantidade: " + vendedor845.size());
		System.out.println("Codigo Vendedor 874:  " + vendedor874 + " Quantidade: " + vendedor874.size());

		System.out.println("\n");

		System.out.println("6. Gerar o relatório/lista de pacotes por destino e por tipo (Considere\r\n"
				+ "apenas pacotes válidos): ");

		ArrayList<Integer> oesteItens = new ArrayList<Integer>();
		ArrayList<Integer> oestePos = new ArrayList<Integer>();
		ArrayList<Integer> nordesteItens = new ArrayList<Integer>();
		ArrayList<Integer> nordestePos = new ArrayList<Integer>();
		ArrayList<Integer> norteItens = new ArrayList<Integer>();
		ArrayList<Integer> nortePos = new ArrayList<Integer>();
		ArrayList<Integer> sudesteItens = new ArrayList<Integer>();
		ArrayList<Integer> sudestePos = new ArrayList<Integer>();
		ArrayList<Integer> sulItens = new ArrayList<Integer>();
		ArrayList<Integer> sulPos = new ArrayList<Integer>();

		for (int i = 0; i < codBarras.length; i++) {

			if (invalidos.contains(i + 1)) {
				continue;
			}

			if (codBarras[i].getRegiaoDestino() >= 201 && codBarras[i].getRegiaoDestino() <= 299) {
				oesteItens.add(codBarras[i].getTipoProduto());
				oestePos.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 300 && codBarras[i].getRegiaoDestino() <= 399) {
				nordesteItens.add(codBarras[i].getTipoProduto());
				nordestePos.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 400 && codBarras[i].getRegiaoDestino() <= 499) {
				norteItens.add(codBarras[i].getTipoProduto());
				nortePos.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 1 && codBarras[i].getRegiaoDestino() <= 99) {
				sudesteItens.add(codBarras[i].getTipoProduto());
				sudestePos.add(i + 1);
			} else if (codBarras[i].getRegiaoDestino() >= 100 && codBarras[i].getRegiaoDestino() <= 199) {
				sulItens.add(codBarras[i].getTipoProduto());
				sulPos.add(i + 1);
			}
		}

		System.out.println("Região Centro-Oeste: Pacotes: " + oestePos + " Tipos: " + oesteItens);
		System.out.println("Região Nordeste: Pacotes; " + nordestePos + " Tipos: " + nordesteItens);
		System.out.println("Região Norte: Pacotes: " + nortePos + " Tipos: " + norteItens);
		System.out.println("Região Sudeste: Pacotes: " + sudestePos + " Tipos: " + sudesteItens);
		System.out.println("Região Sul: Pacotes: " + sulPos + " Tipos: " + sulItens);

		System.out.println("\n");

		System.out.println("7. Se o transporte dos pacotes para o Norte passa pela Região\r\n"
				+ "Centro-Oeste, quais são os pacotes que devem ser despachados no\r\n" + "mesmo caminhão? ");

		ArrayList<Integer> pacotesDestinoNorteCentroOeste = new ArrayList<Integer>();

		for (int i = 0; i < codBarras.length; i++) {

			int numeroPacoteAtual = (i + 1);

			if (codBarras[i].getRegiaoOrigem() >= 201 && codBarras[i].getRegiaoOrigem() <= 299
					&& codBarras[i].getTipoProduto() == 1) {
				continue;
			}

			if (norte.contains(numeroPacoteAtual)) {
				pacotesDestinoNorteCentroOeste.add(numeroPacoteAtual);
			}

		}
		
		for (int i = 0; i < codBarras.length; i++) {

			int numeroPacoteAtual = (i + 1);

			if (codBarras[i].getRegiaoOrigem() >= 201 && codBarras[i].getRegiaoOrigem() <= 299
					&& codBarras[i].getTipoProduto() == 1) {
				continue;
			}
			
		
			if (centroOeste.contains(numeroPacoteAtual)) {
				pacotesDestinoNorteCentroOeste.add(numeroPacoteAtual);
			}

		}
		System.out.println("Os pacotes despachados: " + pacotesDestinoNorteCentroOeste);
		
		System.out.println("\n");
		
		System.out.println("8. Se todos os pacotes fossem uma fila qual seria a ordem de carga\r\n"
				+ "para o Norte no caminhão para descarregar os pacotes da Região\r\n"
				+ "Centro Oeste primeiro;");
		
		System.out.println("Os pacotes na ordem correta: " + pacotesDestinoNorteCentroOeste);
		
				
		System.out.println("\n");
		
		System.out.println("9. No item acima considerar que as jóias fossem sempre as primeiras a\r\n"
				+ "serem descarregadas:");
		
		ArrayList<Integer> pacotesDestinoCentroOesteJoias = new ArrayList<Integer>();
		
		
		for (int i = 0; i < codBarras.length; i++) {

			int numeroPacoteAtual = (i + 1);

			if (codBarras[i].getRegiaoOrigem() >= 201 && codBarras[i].getRegiaoOrigem() <= 299
					&& codBarras[i].getTipoProduto() == 1) {
				continue;
			}
		
			if (norte.contains(numeroPacoteAtual) && codBarras[i].getTipoProduto() != 1) {
				pacotesDestinoCentroOesteJoias.add(numeroPacoteAtual);
			}

		}
		
		for (int i = 0; i < codBarras.length; i++) {

			int numeroPacoteAtual = (i + 1);

			if (codBarras[i].getRegiaoOrigem() >= 201 && codBarras[i].getRegiaoOrigem() <= 299
					&& codBarras[i].getTipoProduto() == 1) {
				continue;
			}
		
			if (norte.contains(numeroPacoteAtual) && codBarras[i].getTipoProduto() == 1) {
				pacotesDestinoCentroOesteJoias.add(numeroPacoteAtual);
			}

		}
		
		for (int i = 0; i < codBarras.length; i++) {

			int numeroPacoteAtual = (i + 1);

			if (codBarras[i].getRegiaoOrigem() >= 201 && codBarras[i].getRegiaoOrigem() <= 299
					&& codBarras[i].getTipoProduto() == 1) {
				continue;
			}
		
			if (centroOeste.contains(numeroPacoteAtual) && codBarras[i].getTipoProduto() != 1) {
				pacotesDestinoCentroOesteJoias.add(numeroPacoteAtual);
			}

		}
		
		for (int i = 0; i < codBarras.length; i++) {

			int numeroPacoteAtual = (i + 1);

			if (codBarras[i].getRegiaoOrigem() >= 201 && codBarras[i].getRegiaoOrigem() <= 299
					&& codBarras[i].getTipoProduto() == 1) {
				continue;
			}
		
			if (centroOeste.contains(numeroPacoteAtual) && codBarras[i].getTipoProduto() == 1) {
				pacotesDestinoCentroOesteJoias.add(numeroPacoteAtual);
			}

		}
		
		System.out.println("Considerando o produto Jóia a ordem é: " + pacotesDestinoCentroOesteJoias);
		
		System.out.println("\n");
		
		System.out.println("10. Listar os pacotes inválidos.");
		System.out.println("Pacotes Inválidos: " + invalidos);
	
	}

}

 class CodigoBarras {
	
	private String codigoBarras;
	private int regiaoOrigem;
	private int regiaoDestino;
	private int codigoLoggi;
	private int codigoVendedor;
	private int tipoProduto;
	
	
	
	public CodigoBarras() {}
	
	public CodigoBarras(String codigo) {
		this.setCodigoBarras(codigo);
		
		 codigoOrigem();
		 codigoDestino();
		 codigoLoggi();
		 codigoVendedor();
		 codigoProduto();
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	
	
	public int getRegiaoOrigem() {
		return regiaoOrigem;
	}

	public void setRegiaoOrigem(int regiaoOrigem) {
		this.regiaoOrigem = regiaoOrigem;
	}

	public int getRegiaoDestino() {
		return regiaoDestino;
	}

	public void setRegiaoDestino(int regiaoDestino) {
		this.regiaoDestino = regiaoDestino;
	}

	public int getCodigoLoggi() {
		return codigoLoggi;
	}

	public void setCodigoLoggi(int codigoLoggi) {
		this.codigoLoggi = codigoLoggi;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public int getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	//métodos
	public void codigoOrigem () {
		int codigoOrigem = Integer.parseInt(getCodigoBarras().substring(0, 3)) ; 
		setRegiaoOrigem(codigoOrigem);
		
		
	}
	
	public void codigoDestino () {
		int regiaoDestino = Integer.parseInt(getCodigoBarras().substring(3, 6)) ;
		setRegiaoDestino(regiaoDestino);
		
	}
	
	public void codigoLoggi() {
		int codigoLoggi = Integer.parseInt(getCodigoBarras().substring(6, 9)) ;
		setCodigoLoggi(codigoLoggi);
		
		
	}
	
	public void codigoVendedor() {
		int codigoVendedor = Integer.parseInt(getCodigoBarras().substring(9, 12)) ;
		setCodigoVendedor(codigoVendedor);
		
	}
	
	public void codigoProduto() {
		int tipoProduto = Integer.parseInt(getCodigoBarras().substring(12, 15)) ;
		setTipoProduto(tipoProduto);
		//System.out.println("Tipo do produto: " + tipoProduto);
	}
	
}	

