
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Program {
	
	Scanner leitor = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Bem vindo a Livraria Livraria, o que gostaria de fazer");

		
		
		console();

	}

	
	
 public static void listar() throws SQLException {
	 		//1. Abrir conex�o com banco de dados
		
			String url = ("jdbc:sqlite:C:\\Users\\jupit\\OneDrive\\Documentos\\Code\\Livraria\\db\\estoquedb.db");	
			Connection conexao = DriverManager.getConnection(url);
			
			//2. Criar o comando e executar o SQL
			
			Statement comando = conexao.createStatement();
			String querySlect = "SELECT * FROM PRODUTO";
			ResultSet resultado = comando.executeQuery(querySlect);
			
			//3. mostrar os dados
			
			while(resultado.next()) {
			int id = resultado.getInt(1);
			String name = resultado.getString(2);
			String autor = resultado.getString(3);
			int  quant = resultado.getInt(4);
			double valor = resultado.getDouble(5);
			
			System.out.println("Id: " + id);
			System.out.println("Nome: " + name);
			System.out.println("Autor: " + autor);
			System.out.println("Quantidade : " + quant);
			System.out.println("Valor: R$" + valor);
			System.out.println("-------------------------");
			
			}
 }
 
 public static void incluir() throws SQLException {
	 
		Scanner leitor = new Scanner(System.in);

		//1. Abrir conex�o com banco de dados
		String url = ("jdbc:sqlite:C:\\Users\\jupit\\OneDrive\\Documentos\\Code\\Livraria\\db\\estoquedb.db");
		Connection conexao = DriverManager.getConnection(url);
		
		
		//2. Criar o comando e executar o SQL		
		Statement comando = conexao.createStatement();
		System.out.println("Voc� escolheu a op��o o adicionar um produto"
				+ "\ndigite o nome do livro" );		
		String nome = leitor.nextLine();

		System.out.println("Qual � o autor?");
		String autor = leitor.nextLine();
		
		System.out.println("Qual a quantidade?");
		int quantidade = leitor.nextInt();
		
		System.out.println("Quanto custa?");
		double preco = leitor.nextDouble();
		
		String queryInsert = "INSERT INTO PRODUTO (name, autor, quant, valor)"
				+ "values ('" + nome + "', '"+ autor +"' , " + quantidade + " , "+ preco +")";
		comando.execute(queryInsert);
				
		leitor.close();
	
 }


public static void atualizar() throws SQLException {
	//1. Abrir conex�o com banco de dados
	
	Scanner leitor = new Scanner(System.in);

	String url = ("jdbc:sqlite:C:\\Users\\jupit\\OneDrive\\Documentos\\Code\\Livraria\\db\\estoquedb.db");	
	Connection conexao = DriverManager.getConnection(url);
	
	
	//2. Sele��o
	
	System.out.println("Qual o id do livro que voc� quer modificar?");
	
	int id = leitor.nextInt();
	
	System.out.println("O que voc� quer modificar?"
			+ "\nSelecione "
			+ "\n 1 - nome"
			+ "\n 2 - autor"
			+ "\n 3 - quantidade"
			+ "\n 4 - valor");

	int mod = leitor.nextInt();	

	System.out.println("insira o novo valor");

			
	//3. Criar o comando e executar o SQL		
	Statement comando = conexao.createStatement();
	
	String queryUpdate = null;
	
	switch (mod) {
	case 1:
	
		String val = leitor.next();

		queryUpdate = "update produto set name = '"+ val +"'"
				+ "Where id = " + id;
	
//		comando.executeUpdate(queryUpdate);	
		 
	case 2:
		String val2 = leitor.nextLine();


		queryUpdate = "update produto set autor = '"+ val2 +"'"
				+ "Where id = " + id;
		
		comando.executeUpdate(queryUpdate);	
	case 3:
		
		int val3 = leitor.nextInt();

		
		queryUpdate = "update produto set quant = '"+ val3 +"'"
				+ "Where id = " + id;
		
		comando.executeUpdate(queryUpdate);	
	case 4:
		
		double val4 = leitor.nextDouble();
		
		queryUpdate = "update produto set valor = '"+ val4 +"'"
				+ "Where id = " + id;
		comando.executeUpdate(queryUpdate);	
		
		break;

	default:
		System.out.println("Deu ruim");;
	}
	
	
	
//	comando.executeUpdate(queryUpdate);	
	
	leitor.close();
}


public static void excluir() throws SQLException {
	
	Scanner leitor = new Scanner(System.in);
	//1. Abrir conex�o com banco de dados
	String url = ("jdbc:sqlite:C:\\Users\\jupit\\OneDrive\\Documentos\\Code\\Livraria\\db\\estoquedb.db");
	Connection conexao = DriverManager.getConnection(url);
	
	
	System.out.println("Selecione pelo id qual livro voc� quer deletar");
	int id = leitor.nextInt();
	
	//2. Criar o comando e executar o SQL		
	Statement comando = conexao.createStatement();
	String queryUpdate = "DELETE FROM produto WHERE id = " + id;
	comando.executeUpdate(queryUpdate);	
	leitor.close();
}




public static void console() throws SQLException {
	
	Scanner leitor = new Scanner(System.in);
	
	System.out.println("Selecione 1 para listar"
			+ "\n\nSelecione 2 para incluir um novo livro"
			+ "\n\nSelecione 3 para atualizar um livro existente"
			+ "\n\nSelecione 4 para excluir um livro");
	
	
	int selecao = leitor.nextInt();
	
	switch (selecao) {
	case 1:
		System.out.println("\nlista de livros:\n");
		
		listar();
		

	case 2:
		
		incluir();	
		
	case 3:
		
		atualizar();
		
		
	case 4:
		
		excluir();
		
	default:
		System.out.println("Op��o selecionada invalida");
	}
	
	console();
	leitor.close();
}

}
 

 


