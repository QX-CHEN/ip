package common;

/**
 * Message class contains messages to be printed by Ui class.
 */
public class Message {
    public static final String HORIZONTAL_LINE = "\t______________________________" +
            "______________________________";
    public static final String GREET_MESSAGE = "\t Hello! I'm Duke" + System.lineSeparator() +
            "\t What can I do for you?";
    public static final String BYE_MESSAGE = "\t Bye. Hope to see you again soon!";
    public static final String ADD_MESSAGE = "\t Got it. I've added: this task:";
    public static final String LIST_MESSAGE = "\t Here are the tasks in your list:";
    public static final String FIND_MESSAGE = "\t Here are the matching tasks in your list:";
    public static final String DELETE_MESSAGE = "\t Noted. I've removed this task:";
    public static final String MARK_AS_DONE_MESSAGE = "\t Nice! I've marked this task as done:";
    public static final String INVALID_TASK_NUMBER_MESSAGE = "\t Invalid task number!";
    public static final String TASK_ALREADY_DONE_MESSAGE = "\t Task already done!";
    public static final String INVALID_COMMAND_MESSAGE = "\t Check command format!";
    public static final String UNKNOWN_COMMAND_MESSAGE = "\t Check command word!";
}
