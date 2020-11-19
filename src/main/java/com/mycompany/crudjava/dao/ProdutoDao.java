/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author jr
 */
public class ProdutoDao {

    private Connection con;
    private PreparedStatement smt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Produto> lista = new ArrayList<>();

    public ProdutoDao() {
        con = new ConectionFactory().getConexao();
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (descricao_produto ,preco_produto) VALUES(?,?)";
        try {
            smt = con.prepareStatement(sql);
            smt.setString(1, produto.getDescricao_produto());
            smt.setDouble(2, produto.getPreco_produto());
            smt.execute();
            smt.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
    
    public void alterar(Produto produto) {
        String sql = "UPDATE produto SET descricao_produto = ?, preco_produto=? WHERE codigo_produto = ?";
        try {
            smt = con.prepareStatement(sql);
            smt.setString(1, produto.getDescricao_produto());
            smt.setDouble(2, produto.getPreco_produto());
            smt.setInt(3, produto.getCodigo_produto());
            smt.execute();
            smt.close();
        } catch (Exception ex){
            ex.printStackTrace();
            
        }
    }
    
    public void delete(int valor){
        String sql= "DELETE FROM produto WHERE codigo_produto = " + valor;
        try{
            st = con.createStatement();
            st.execute(sql);
            st.close();
            
        }catch(Exception erro){
           erro.printStackTrace();
            
        }
        
    }
    
    public ArrayList<Produto> listarProdutos(){
        String sql = "SELECT * FROM produto";
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo_produto(rs.getInt("codigo_produto"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                produto.setPreco_produto(rs.getDouble("preco_produto"));
                lista.add(produto);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lista;
            
    }
    public ArrayList<Produto> listarProdutosDecricao(String valor){
        String sql = "SELECT * FROM produto WHERE descricao_produto LIKE '%" + valor +"%' ";
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo_produto(rs.getInt("codigo_produto"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                produto.setPreco_produto(rs.getDouble("preco_produto"));
                lista.add(produto);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lista;
            
    }

}
