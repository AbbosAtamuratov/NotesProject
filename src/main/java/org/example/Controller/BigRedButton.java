package org.example.Controller;

import org.example.Database.Based;
import org.example.View.Display;

public class BigRedButton {

    private Logger logger;
    private Based dB;
    private boolean isRunning;

    public BigRedButton(Based based) {
        this.dB = based;
        this.logger = Logger.getLogger();
        this.isRunning = true;
    }

    public void setRunning(boolean running) { isRunning = running; }

    public void run(){

        String correct = "программа сработала корректно";
        dB.getDisplay().greet();
        Command command = Command.NONE;
        String com = new String();
        String userInput = new String();
        Validator val = new Validator();

        while (isRunning){
            com = dB.getDisplay().promt("Введите команду: ").toUpperCase();
            command = Command.valueOf(com);
            switch (command){
                case EXIT:
                    setRunning(false);
                    dB.getDisplay().okBye();
                    logger.addLog(com, correct);
                    logger.saveLogs();
                    break;
                case LOGS:
                    logger.addLog(com, correct);
                    logger.showLogs();
                    break;
                case CREATE:
                    dB.create();
                    logger.addLog(com, correct);
                    break;
                case EDIT:
                    userInput = dB.getDisplay().promt("Введите id: ");
                    String tmp = val.validateId(userInput);
                    if (userInput.equals(tmp)) {
                        dB.edit(userInput);
                        logger.addLog(com,correct);
                    }
                    else {
                        logger.addLog(com, tmp);
                    }
                    break;
                case FIND:
                    userInput = dB.getDisplay().promt("Введите id: ");
                    String temp = val.validateId(userInput);
                    if (userInput.equals(temp)) {
                        dB.find(userInput);
                        logger.addLog(com,correct);
                    }
                    else {
                        logger.addLog(com, temp);
                    }
                    break;
                default:
                    dB.getDisplay().wtf();
                    logger.addLog(com, "Неопознано");
                    break;
            }
        }
    }
}
