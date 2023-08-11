package sistema;
import java.util.Scanner;

import sockets.ConexaoCliente;

public class ExecutavelCliente {
	
	private static ConexaoCliente conexaoCliente = ConexaoCliente.getInstance();
	
	public static void main(String[] args) {
		executaAplicacao();
	}

	private static void executaAplicacao() {
		if(conexaoCliente.getConection(null, 0)) {
			
			Scanner s = new Scanner(System.in);
			System.out.println("Por favor, escolha uma entidade: "
					+ "\n---------------------\n"
					+ "(1) Pessoa \n"
					+ "(2) Corja \n"
					+ "\n---------------------\n"
					+ "(3) Encerrar Conexão");
			
			int opcao = s.nextInt();
			
			if (opcao == 1)
				executaPessoa();
			else if(opcao == 2)
				executaCorja();
			else
				conexaoCliente.closeConnection();
		}
	}

	private static void executaCorja() {
		Scanner s = new Scanner(System.in);
		
		do {
			String comando;
			String localEsconderijo;
			String cpf;
			int anoFundacao;
			
			System.out.println("Por favor, escolha uma operação: "
					+ "\n---------------------\n"
					+ "(1) Inserir Corja \n"
					+ "(2) Atualizar Corja \n"
					+ "(3) Excluir Corja \n"
					+ "(4) Carregar Corja \n"
					+ "(5) Listar Corjas "
					+ "\n---------------------\n"
					+ "(6) Adicionar Pessoa à Corja \n"
					+ "(7) Remover Pessoa da Corja "
					+ "(7) Listar Pessoa Relacionadas à Corja "
					+ "\n---------------------\n"
					+ "(8) Voltar");
			
			int operacao = s.nextInt();
						
			switch (operacao) {
				case 1: 
					
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					System.out.println("Informe o Ano de Fundação:");
					anoFundacao = s.nextInt();
					
					comando = "INSERT;localEsconderijo="+localEsconderijo+"anoFundacao="+anoFundacao;
					conexaoCliente.send(comando);
					
			  		break;
			  
				case 2: 
					
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					System.out.println("Informe o Ano de Fundação:");
					anoFundacao = s.nextInt();
					
					comando = "UPDATE;localEsconderijo="+localEsconderijo+"anoFundacao="+anoFundacao;
					conexaoCliente.send(comando);
					
					break;
					
				case 3:
					
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					
					comando = "DELETE;localEsconderijo="+localEsconderijo;
					conexaoCliente.send(comando);
					
					break;
					
				case 4:
					
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					
					comando = "GET;localEsconderijo="+localEsconderijo;
					conexaoCliente.send(comando);
					
					break;

				case 5:
					
					comando = "LIST";
					conexaoCliente.send(comando);
					
					break;
					
				case 6:
					
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					System.out.println("Informe o CPF da Pessoa:");
					cpf = s.next();
					
					comando = "ADD;localEsconderijo="+localEsconderijo+"cpf="+cpf;
					conexaoCliente.send(comando);
					
					break;
					
				case 7:
					
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					System.out.println("Informe o CPF da Pessoa:");
					cpf = s.next();
					
					comando = "REMOVE;localEsconderijo="+localEsconderijo+"cpf="+cpf;
					conexaoCliente.send(comando);
					
					break;
					
				case 8:
					
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					
					comando = "LIST_PESSOA;localEsconderijo="+localEsconderijo;
					conexaoCliente.send(comando);
					
					break;
					
				default: 		
					executaAplicacao();
					break;
			}	
			
			conexaoCliente.read();
			
		} while (true);
	}

	private static void executaPessoa() {
		Scanner s = new Scanner(System.in);
		
		do {
			String comando;
			String cpf;
			String nome;
			String endereco;
			
			System.out.println("Por favor, escolha uma operação: "
					+ "\n---------------------\n"
					+ "(1) Inserir Pessoa \n"
					+ "(2) Atualizar Pessoa \n"
					+ "(3) Excluir Pessoa \n"
					+ "(4) Carregar Pessoa \n"
					+ "(5) Listar Pessoas "
					+ "\n---------------------\n"
					+ "(6) Voltar");
			
			int operacao = s.nextInt();
						
			switch (operacao) {
				case 1: 
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Endereço:");
					endereco = s.next();
					
					comando = "INSERT;cpf="+cpf+"nome="+nome+"endereco="+endereco;
					conexaoCliente.send(comando);
					
			  		break;
			  
				case 2: 
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Endereço:");
					endereco = s.next();
					
					comando = "UPDATE;cpf="+cpf+"nome="+nome+"endereco="+endereco;
					conexaoCliente.send(comando);
					
					break;
					
				case 3:
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					
					comando = "DELETE;cpf="+cpf;
					conexaoCliente.send(comando);
					
					break;
					
				case 4:
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					
					comando = "GET;cpf="+cpf;
					conexaoCliente.send(comando);
					
					break;

				case 5:
					
					comando = "LIST";
					conexaoCliente.send(comando);
					
					break;
					
				default: 		
					executaAplicacao();
					break;
			}			
			
			conexaoCliente.read();
			
		} while (true);
	}
}
