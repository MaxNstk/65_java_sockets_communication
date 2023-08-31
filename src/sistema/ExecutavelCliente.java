package sistema;
import java.util.Scanner;

import socket.ConexaoCliente;

public class ExecutavelCliente {
	
	private static ConexaoCliente conexaoCliente = new ConexaoCliente();
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Informe o IPV4 do servidor");
		String ipHost = s.next();
		System.out.println("Informe a porta do servidor");
		int hostPort = s.nextInt();
		
		executaAplicacao(ipHost,hostPort);
	}

	private static void executaAplicacao(String ipHost, int hostPort) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Por favor, selecione uma opcao: \n"
				+ "---------------------\n"
				+ "(1) Saqueador \n"
				+ "(2) Trapaceiro \n"
				+ "---------------------\n"
				+ "(3) Corja \n"
				+ "---------------------");
		
		int opcao = s.nextInt();
		
		switch (opcao) {
			case 1: 
				executaSaqueador(ipHost,hostPort);
				break;
			case 2:
				executaTrapaceiro(ipHost,hostPort);
				break;
			case 3:
				executaCorja(ipHost,hostPort);
				break;
			default:
				return;
		}
	}

	private static void executaCorja(String ipHost, int hostPort) {
		Scanner s = new Scanner(System.in);
		
		do {
			String comando;
			String localEsconderijo;
			String nome;
			String cpf;
			String entidade;
			int anoFundacao;
			int opcaoEntidade;
						
			System.out.println("Por favor, escolha uma operacao: "
					+ "\n---------------------\n"
					+ "(1) Inserir Corja \n"
					+ "(2) Atualizar Corja \n"
					+ "(3) Excluir Corja \n"
					+ "(4) Carregar Corja \n"
					+ "(5) Listar Corjas "
					+ "\n---------------------\n"
					+ "(6) Adicionar Pessoa a Corja \n"
					+ "(7) Remover Pessoa da Corja \n"
					+ "---------------------\n"
					+ "(8) Voltar");
			
			int operacao = s.nextInt();
			
			if(operacao == 8) {
				executaAplicacao(ipHost,hostPort);
				return;
			}
			
			conexaoCliente.getConection(ipHost, hostPort);			
			
			switch (operacao) {
				case 1: 
					
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					System.out.println("Informe o Ano de Fundacao:");
					anoFundacao = s.nextInt();
					
					comando = "INSERT;CORJA;nome="+nome+";localEsconderijo="+localEsconderijo+";anoFundacao="+anoFundacao;
					conexaoCliente.send(comando);
					
			  		break;
			  
				case 2: 
					
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Local de Esconderijo:");
					localEsconderijo = s.next();
					System.out.println("Informe o Ano de Fundacao:");
					anoFundacao = s.nextInt();
					
					comando = "UPDATE;CORJA;nome="+nome+";localEsconderijo="+localEsconderijo+";anoFundacao="+anoFundacao;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 3:
					
					System.out.println("Informe o Nome:");
					nome = s.next();
					
					comando = "DELETE;CORJA;nome="+nome;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 4:
					
					System.out.println("Informe o Nome:");
					nome = s.next();
					
					comando = "GET;CORJA;nome="+nome;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;

				case 5:
					
					comando = "LIST;CORJA;";
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 6:
					
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o CPF da Pessoa:");
					cpf = s.next();
					
					comando = "ADDPESSOA;CORJA;nome="+nome+";cpf="+cpf;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 7:

					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o CPF da Pessoa:");
					cpf = s.next();
					
					comando = "REMOVEPESSOA;CORJA;nome="+nome+";cpf="+cpf;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;			
			}	
			
			conexaoCliente.closeConnection();
			
		} while (true);
	}

	private static void executaTrapaceiro(String ipHost, int hostPort) {
		Scanner s = new Scanner(System.in);
		
		do {
			String comando;
			String cpf;
			String nome;
			String endereco;
			String habilidade;
			
			System.out.println("Por favor, escolha uma operacao: "
					+ "\n---------------------\n"
					+ "(1) Inserir Trapaceiro \n"
					+ "(2) Atualizar Trapaceiro \n"
					+ "(3) Excluir Pessoa \n"
					+ "(4) Carregar Pessoa \n"
					+ "(5) Listar Pessoas "
					+ "\n---------------------\n"
					+ "(6) Voltar");
			
			int operacao = s.nextInt();
			
			if(operacao == 6) {
				executaAplicacao(ipHost,hostPort);
				return;
			}
			
			conexaoCliente.getConection(ipHost, 80);
			
			switch (operacao) {
				case 1: 
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Endereco:");
					endereco = s.next();
					System.out.println("Informe a Habilidade:");
					habilidade = s.next();
					
					comando = "INSERT;TRAPACEIRO;cpf="+cpf+";nome="+nome+";endereco="+endereco+";habilidade="+habilidade;
					conexaoCliente.send(comando);
					
			  		break;
			  
				case 2: 
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Endereco:");
					endereco = s.next();
					System.out.println("Informe a Habilidade:");
					habilidade = s.next();
					
					comando = "UPDATE;TRAPACEIRO;cpf="+cpf+";nome="+nome+";endereco="+endereco+";habilidade="+habilidade;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 3:
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					
					comando = "DELETE;TRAPACEIRO;cpf="+cpf;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 4:
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					
					comando = "GET;TRAPACEIRO;cpf="+cpf;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;

				case 5:
					
					comando = "LIST;TRAPACEIRO;";
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;	
					
			}			
			conexaoCliente.closeConnection();
			
		} while (true);
	}
	
	private static void executaSaqueador(String ipHost, int hostPort) {
		Scanner s = new Scanner(System.in);
		
		do {
			String comando;
			String cpf;
			String nome;
			String endereco;
			double valorSaqueado;
			
			System.out.println("Por favor, escolha uma operacao: "
					+ "\n---------------------\n"
					+ "(1) Inserir Saqueador \n"
					+ "(2) Atualizar Saqueador \n"
					+ "(3) Excluir Pessoa \n"
					+ "(4) Carregar Pessoa \n"
					+ "(5) Listar Pessoas "
					+ "\n---------------------\n"
					+ "(6) Voltar");
			
			int operacao = s.nextInt();
			
			if(operacao == 6) {
				executaAplicacao(ipHost, hostPort);
				return;
			}
			
			conexaoCliente.getConection(ipHost, 80);
			
			switch (operacao) {
				case 1: 
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Endereco:");
					endereco = s.next();
					System.out.println("Informe o Valor Saqueado:");
					valorSaqueado = s.nextDouble();
					
					comando = "INSERT;SAQUEADOR;cpf="+cpf+";nome="+nome+";endereco="+endereco+";valorSaqueado="+valorSaqueado;
					conexaoCliente.send(comando);
					
			  		break;
			  
				case 2: 
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					System.out.println("Informe o Nome:");
					nome = s.next();
					System.out.println("Informe o Endereco:");
					endereco = s.next();
					System.out.println("Informe o Valor Saqueado:");
					valorSaqueado = s.nextDouble();
					
					comando = "UPDATE;SAQUEADOR;cpf="+cpf+";nome="+nome+";endereco="+endereco+";valorSaqueado="+valorSaqueado;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 3:
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					
					comando = "DELETE;SAQUEADOR;cpf="+cpf;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;
					
				case 4:
					
					System.out.println("Informe o CPF:");
					cpf = s.next();
					
					comando = "GET;SAQUEADOR;cpf="+cpf;
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;

				case 5:
					
					comando = "LIST;SAQUEADOR;";
					conexaoCliente.send(comando);
					
					System.out.println(conexaoCliente.read());
					
					break;	
					
			}			
			conexaoCliente.closeConnection();
			
		} while (true);
	}
}
