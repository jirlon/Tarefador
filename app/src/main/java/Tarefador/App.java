/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Tarefador;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

public class App {

    public static void main(String[] args) {
        ProjectController projectController = new ProjectController();
        
        /*Project project = new Project();
        project.setName("Projeto teste1");
        project.setDescription("primeiro projeto do app tarefador");
        projectController.save(project);*/
        
        /*Project project2 = new Project();
        project2.setId(2);
        project2.setName("alterando o nome de projeto");
        project2.setDescription("alterando a descri��o");*/
        
        //projectController.update(project2);
        
        //projectController.removeById(1);
        
        /*List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos: " + projects.size());*/
        
        /*TaskController taskController = new TaskController();
        
        Task t = new Task();
        t.setIdProject(2);
        t.setName("criar telas da aplica��o");
        t.setDescription("criar tela de cadastros");
        t.setNotes("sem notas");
        t.setIsCompleted(false);
        t.setDeadline(new Date());
        
        //taskController.save(t);
        t.setName("Alterar tela da aplica��o");
        t.setId(3);
        taskController.update(t);
        List<Task> tasks = taskController.getAll(2);
        System.out.println("Total de tarefas: " + tasks.size());
        taskController.removeById(1);*/
    }
}
