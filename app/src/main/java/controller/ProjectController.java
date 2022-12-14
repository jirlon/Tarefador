/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author jirlo
 */
public class ProjectController {
    
    public void save(Project project){
        String sql = "INSERT INTO projects ("
                + "name,"
                + "description,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao salvar o projeto\n"
                + ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    
    public void update(Project project){
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            
            statement.execute();
        }catch (SQLException ex){
                throw new RuntimeException("Erro ao atualizar o projeto\n" + ex.getMessage(), ex);
        } finally {
                ConnectionFactory.closeConnection(connection, statement);
        }      
    }
    
    
    public void removeById(int projectId) /*throws SQLException*/{
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
        } catch (Exception ex){
            throw new RuntimeException("Erro ao deletar o projeto" + ex.getMessage(), ex);
            } finally {
                ConnectionFactory.closeConnection(conn, statement);
            }
    }
    
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //lista de tarefas que sera devolvida quando a chamada do metodo acontecer
        List<Project> projects = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                projects.add(project);
            }
            
        } catch (Exception ex){
            throw new RuntimeException("Erro ao inserir o projeto" + ex.getMessage(), ex);
            } finally {
                ConnectionFactory.closeConnection(connection, statement, resultSet);
            }
        
        //retornando lista de tarefas do banco de dados
        return projects;
    }
}
