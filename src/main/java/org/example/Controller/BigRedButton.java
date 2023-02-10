package org.example.Controller;

import org.example.Database.*;

public class BigRedButton {

    private Logger logger;
    private DataBase dB;
    private boolean isRunning;

    public BigRedButton(DataBase based) {
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

        while (isRunning){
            com = dB.getDisplay().promt("Введите команду или help: ").toUpperCase();
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
                    String tmp = dB.validateId(userInput);
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
                    String temp = dB.validateId(userInput);
                    if (userInput.equals(temp)) {
                        dB.find(userInput);
                        logger.addLog(com,correct);
                    }
                    else {
                        logger.addLog(com, temp);
                    }
                    break;
                case REMOVE:
                    userInput = dB.getDisplay().promt("Введите id: ");
                    String tempo = dB.validateId(userInput);
                    if (userInput.equals(tempo)) {
                        dB.remove(userInput);
                        logger.addLog(com,correct);
                    }
                    else {
                        logger.addLog(com, tempo);
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
