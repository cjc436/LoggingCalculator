Logging Calculator
by: Cristos Criniti (cjc436)

Instructions:
To run this program, you will need to different components. You will need to run the server and the client at the same time.
You could just run the client and everything should still work, but this obviously wouldnt't test the logging aspect.
To run the client, run the "main" method in the "LoggingCalculatorClient" class.
To run the server, run the "main" method in the "LoggingCalculatorServer" class.
Both the client and server files are in the same project, but are just in different directories labeled "client" and "Server".
Once the UI appears for the client, you can use the calculator as normal.
If you attempt an operation that would cause an error, a dialog will appear over the display and ask you will need to select "Undo" or "Reset" before continuing.

All resulting expressions will be sent to the server and logged localling in an ArrayList, while outputing them on the command line of the server.
Then if you close the project using the "exit" button on the GUI, it will send an on close event and trigger the server to print all of the logs to the command line together, while outputing a message about the amount of successful logs.

Known Faults:
None with the calculator and logging system.

There possibly might be one since I used JavaFX with Java 11. Every time I run my project using Java 11 it works perfectly fine, but gives me a warning that it probably should be in Java 17.
You should be able to run it in Java 11, but if it doesn't work then maybe switch to Java 17

To be clear, I can run it fine on IntelliJ with Java 11.