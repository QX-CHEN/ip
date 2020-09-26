# User Guide

## Features 

### Notes about command format:
    - Words in UPPER_CASE are the parameters to be supplied by the user.
      e.g. in "todo DESCRIPTION", DESCRIPTION is a parameter which can be used 
      as "todo user guide".
    
    - Input date format is dd/MM/yyyy.
      e.g. 20/02/2020
      
    - Input time format is HHmm in 24-hrs.
      e.g. 1830

### Adding a Todo task : `todo`

Add a Todo task to the task list and display a message.

Format: `todo DESCRIPTION`

Example of usage: 

`todo user guide`

Expected outcome:

	____________________________________________________________
	 Got it. I've added: this task:
	   [T][X] user guide
	 Now you have 1 task(s) in the list.
	____________________________________________________________

### Adding an Event task : `event`

Add an Event task to the task list and display a message.

Format: `event DESCRIPTION /at DATE START_TIME-END_TIME`

Example of usage: 

`event project meeting /at 20/02/2020 1800-2000`

Expected outcome:

	____________________________________________________________
	 Got it. I've added: this task:
	   [E][X] project meeting (at: 2020-02-20 1800-2000)
	 Now you have 2 task(s) in the list.
	____________________________________________________________

### Adding a Deadline task : `deadline`

Add a Deadline task to the task list and display a message.

Format: `deadline DESCRIPTION /by DATE TIME`

Example of usage: 

`deadline report /by 20/02/2020 2359`

Expected outcome:

	____________________________________________________________
	 Got it. I've added: this task:
	   [D][X] report (by: 2020-02-20 2359)
	 Now you have 3 task(s) in the list.
	____________________________________________________________

### Displaying tasks : `list` 

Display all tasks in the list.

Format: `list`

Example of usage: 

`list`

Expected outcome:

	____________________________________________________________
	 Here are the tasks in your list:
	 1. [T][X] user guide
	 2. [E][X] project meeting (at: 2020-02-20 1800-2000)
	 3. [D][X] report (by: 2020-02-20 2359)
	____________________________________________________________

### Changing status of a task : `done`

Mark a task as done and display a message.

Format: `done INDEX`

Example of usage: 

`done 2`

Expected outcome:

	____________________________________________________________
	 Nice! I've marked this task as done:
	   [E][T] project meeting (at: 2020-02-20 1800-2000)
	____________________________________________________________

### Removing a task : `delete`

Delete a task from the task list.

Format: `delete INDEX`

Example of usage: 

`delete 2`

Expected outcome:

	____________________________________________________________
	 Noted. I've removed this task:
	   [E][T] project meeting (at: 2020-02-20 1800-2000)
	 Now you have 2 task(s) in the list.
	____________________________________________________________

### Searching relevant task(s) : `find`

Find and display task(s) with given keyword.

Format: `find KEYWORD`

Example of usage: 

`find report`

Expected outcome:

	____________________________________________________________
	 Here are the matching task(s) in your list:
	 1. [D][X] report (by: 2020-02-20 2359)
	____________________________________________________________

### Exiting program : `bye`

Display a message and exits the program.

Format: `bye`

Example of usage: 

`bye`

Expected outcome:

	____________________________________________________________
	 Bye. Hope to see you again soon!
	____________________________________________________________
