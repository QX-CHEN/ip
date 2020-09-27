# User Guide

Duke is a desktop app for managing tasks, optimized for use via Command Line Interface (CLI).
It allows users to add different types of task and provides convenient commands to modify and 
view the tasks.

- [Quick start](#Quick-start)
- [Features](#Features)
    - [Adding Todo](#adding-a-todo-task--todo)
    - [Adding Event](#adding-an-event-task--event)
    - [Adding Deadline](#adding-a-deadline-task--deadline)
    - [Displaying tasks](#displaying-tasks--list)
    - [Marking task as done](#changing-status-of-a-task--done)
    - [Removing task](#removing-a-task--delete)
    - [Searching task](#searching-relevant-tasks--find)
    - [Exiting program](#exiting-program--bye)
- [FAQ](#FAQ)
- [Command summary](#Command-summary)

## Quick start

1. Download and install Java 11 in your Computer.

2. Download the latest "Duke.jar" from [here](https://github.com/QX-CHEN/ip/releases/download/A-Jar/Duke.jar).

3. To use existing data file (optional):
    - Create a "data" folder in the same folder as "Duke.jar".
    - Copy existing to "data" folder and name it "Duke.txt".

4. Open terminal/command prompt and run "Duke.jar" with following command:

    `java -jar Duke.jar`

5. Type a command in terminal/command prompt and press Enter to execute it.

6. Refer to the [Features](#features) below for details of each command.

## Features 

### Notes about command format:
- Words in UPPER_CASE are the parameters to be supplied by the user. 
    - e.g. in "todo DESCRIPTION", DESCRIPTION is a parameter which can be used 
      as "todo user guide".
    
- Input date format is dd/MM/yyyy.
    - e.g. 20/02/2020
      
- Input time format is HHmm in 24-hrs.
    - e.g. 1830

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
	
### Saving data to file

Data will be automatically saved after modification commands like 
`todo`, `delete`, `done` and so forth.

## FAQ

## Command summary

Action | Format | Example
------ | ------ | -------
todo | `todo DESCRIPTION` | `todo user guide`
event | `event DESCRIPTION /at DATE START-END` | `event meeting 20/02/2020 1700-1900`
deadline | `deadline DESCRIPTION /by DATE TIME` | `deadline report 24/10/2020 2359`
done | `done INDEX` | `done 1`
delete | `delete INDEX` | `delete 2`
find | `find KEYWORD` | `find meet`
list | `list` | `list`
bye | `bye` | `bye`

