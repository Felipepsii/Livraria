
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {
	
	Scanner leitor = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
				incluir();
	}

 public static void listar() throws SQLException {
	 		//1. Abrir conexão com banco de dados
		
			String url = ("jdbc:sqlite:E:\\documents\\eclipse\\Livraria\\db\\estoquedb.db");	
			Connection conexao = DriverManager.getConnection(url);
			
			//2. Criar o comando e executar o SQL
			
			Statement comando = conexao.createStatement();
			String querySlect = "SELECT * FROM tbl_produto";
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
			System.out.println("Data de Nascimento: " + autor);
			System.out.println("cpf: " + quant);
			System.out.println("email: " + valor);
			System.out.println("-------------------------");
			
			}
 }
 
 public static void incluir() throws SQLException {
		//1. Abrir conexão com banco de dados
		String url = ("jdbc:sqlite:E:\\documents\\eclipse\\Livraria\\db\\estoquedb.db");	
		Connection conexao = DriverManager.getConnection(url);
		
		
		//2. Criar o comando e executar o SQL		
		Statement comando = conexao.createStatement();
		String queryInsert = "INSERT INTO PRODUTO (name, autor, quant, valor)"
				+ "values ('Manifesto Comunista', 'Karl Marx' , 2 , 39.90)";
		comando.execute(queryInsert);
				
	
 }


public static void atualizar() throws SQLException {
	//1. Abrir conexão com banco de dados
	String url = ("jdbc:sqlite:E:\\documents\\eclipse\\Livraria\\db\\estoquedb.db");	
	Connection conexao = DriverManager.getConnection(url);
	
	
	//2. Criar o comando e executar o SQL		
	Statement comando = conexao.createStatement();
	String queryUpdate = "update cliente set nome = 'Ana Maria'"
			+ "Where codigo = 2";
	comando.executeUpdate(queryUpdate);	
}


public static void excluir() throws SQLException {
	//1. Abrir conexão com banco de dados
	String url = ("jdbc:sqlite:E:\\documents\\eclipse\\Livraria\\db\\estoquedb.db");	
	Connection conexao = DriverManager.getConnection(url);
	
	
	//2. Criar o comando e executar o SQL		
	Statement comando = conexao.createStatement();
	String queryUpdate = "DELETE FROM cliente WHERE id = 4";
	comando.executeUpdate(queryUpdate);	
}


}



 

 


