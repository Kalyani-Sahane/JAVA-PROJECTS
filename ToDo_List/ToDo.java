import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
    private JFrame frame;
    private DefaultListModel<Task> listModel;
    private JList<Task> toDoList;
    private JTextField taskNameField;
    private JTextField dueDateField;

    public ToDo() {
        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        listModel = new DefaultListModel<>();
        toDoList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(toDoList);

        taskNameField = new JTextField(20);
        dueDateField = new JTextField(10);
        JButton addButton = new JButton("Add Task");
        JButton editButton = new JButton("Edit Task");
        JButton deleteButton = new JButton("Delete Task");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Task Name:"));
        inputPanel.add(taskNameField);
        inputPanel.add(new JLabel("Due Date (yyyy-MM-dd):"));
        inputPanel.add(dueDateField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.EAST);
        frame.add(deleteButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addTask() {
        String taskName = taskNameField.getText().trim();
        String dueDateStr = dueDateField.getText().trim();

        if (!taskName.isEmpty() && !dueDateStr.isEmpty()) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dueDate = dateFormat.parse(dueDateStr);
                Task task = new Task(taskName, dueDate);
                listModel.addElement(task);

                // Clear input fields
                taskNameField.setText("");
                dueDateField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid date format. Use yyyy-MM-dd.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Task name and due date are required.");
        }
    }

    private void editTask() {
        int selectedIndex = toDoList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task selectedTask = listModel.getElementAt(selectedIndex);
            String newTaskName = taskNameField.getText().trim();
            String newDueDateStr = dueDateField.getText().trim();

            if (!newTaskName.isEmpty() && !newDueDateStr.isEmpty()) {
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date newDueDate = dateFormat.parse(newDueDateStr);

                    // Update the selected task
                    selectedTask.setTaskName(newTaskName);
                    selectedTask.setDueDate(newDueDate);

                    // Refresh the list
                    listModel.setElementAt(selectedTask, selectedIndex);

                    // Clear input fields
                    taskNameField.setText("");
                    dueDateField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid date format. Use yyyy-MM-dd.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Task name and due date are required.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Select a task to edit.");
        }
    }

    private void deleteTask() {
        int selectedIndex = toDoList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(frame, "Select a task to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDo();
            }
        });
    }
}

class Task {
    private String taskName;
    private Date dueDate;

    public Task(String taskName, Date dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dueDateStr = (dueDate != null) ? dateFormat.format(dueDate) : "N/A";
        return taskName + " (Due Date: " + dueDateStr + ")";
    }
}
