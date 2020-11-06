package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.produto;

public class produtoDAO {
    private final Connection connection;
    int id;
    String nome;
    int quantidade;
    double preco;
    public produtoDAO(){
    this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(produto p){String sql = "INSERT INTO produto(nome,quantidade,preco) VALUES (?,?,?)";
    try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setInt(2, p.getQuantidade());
        stmt.setDouble(3, p.getPreco());
        stmt.execute();
    }
    catch (SQLException u) {
    throw new RuntimeException(u);
    }
    }
    public void deleta(produto p){String sql = "DELETE FROM produto WHERE id = ?";
    try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1,p.getId());
        stmt.executeUpdate();
    }
    catch (SQLException u) {
    throw new RuntimeException(u);
    }
    }
    public void limpar(){String sql = "TRUNCATE produto";
    try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.execute();
    }
    catch (SQLException u) {
    throw new RuntimeException(u);
    }
    }
    public void atualizar(produto p){String sql = "UPDATE produto SET nome = ?, quantidade = ?, preco = ? WHERE id =?";
    try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setInt(2, p.getQuantidade());
        stmt.setDouble(3, p.getPreco());
        stmt.setInt(4, p.getId());
        stmt.executeUpdate();
    }
    catch (SQLException u) {
    throw new RuntimeException(u);
    }
    }
    public void selecionar(){String sql = "SELECT nome, quantidade, preco FROM produto";
    try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.getResultSet();
        stmt.execute();
    }
    catch (SQLException u) {
    throw new RuntimeException(u);
    }
    }
     
}


