import java.util.List;
import java.util.Scanner;

public class TaskView {
    private TaskController controller;
    private Scanner scanner;

    public TaskView(TaskController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("----- Lista de Tarefas -----");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Concluir tarefa");
        System.out.println("3. Mostrar tarefas não concluídas");
        System.out.println("4. Mostrar todas as tarefas");
        System.out.println("5. Sair");
    }

    public void handleUserInput() {
        int choice = -1;
        while (choice != 5) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (choice) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    controller.addTask(description);
                    break;
                case 2:
                    System.out.print("Digite o número da tarefa a ser concluída: ");
                    int index = scanner.nextInt();
                    controller.markTaskAsCompleted(index);
                    break;
                case 3:
                    List<Task> incompleteTasks = controller.getIncompleteTasks();
                    displayTasks("Tarefas não concluídas", incompleteTasks);
                    break;
                case 4:
                    List<Task> allTasks = controller.getAllTasks();
                    displayTasks("Todas as tarefas", allTasks);
                    break;
                case 5:
                    System.out.println("Saindo do aplicativo.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private void displayTasks(String title, List<Task> tasks) {
        System.out.println("----- " + title + " -----");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(i + ". " + task.getDescription() + " - " + (task.isCompleted() ? "Concluída" : "Não concluída"));
        }
    }
}
