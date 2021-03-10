package aschalew.deskspace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeskAssignments {

    private char[][] floor = null;
    private List<Developer> devs = new ArrayList<>();
    private List<Manager> mgrs = new ArrayList<>();
    private int noOfDevs = 0;
    private int noOfMgrs = 0;
    private int rows = 0;
    private int cols = 0;
    private int noOfDevDesks = 0;
    private int noOfMgrDesks = 0;
    private Developer [] devArr;
    private Manager[] mgrArr;
    private Worker [] workersArr;
    private char[][] output = new char[noOfDevs + noOfMgrs][2];
    List<Developer> allocatedDevs = new ArrayList<>();
    int devCounter = 0;
    Worker[][] workers;
    int devM = 0;
    int _Mgr = 0;

    public static void main(String[] args) {

        String filePath = "src/main/resources/aschalew/desk";

        DeskAssignments da = new DeskAssignments();
        da.readFileAndSetupFloor(filePath);
        int n = 0;
        int m = 0;
        StringBuffer sb = new StringBuffer();
        da.workersArr = new Worker[da.noOfDevs + da.noOfMgrs];
        da.workers = new Worker[da.rows][da.cols];
        //addWorkers(da.workersArr);*/
        da.writeCoordinatesFor("dev",da.noOfDevs,  da, sb);
        da.writeCoordinatesFor("mgr",da.noOfMgrs,  da, sb);
        System.out.println("dev M = " + da.devM);
        System.out.println("_ Mgr = " + da._Mgr);
        System.out.println(sb.toString());


    }

    private  void writeCoordinatesFor(String worker, int noOfWorkers, DeskAssignments da, StringBuffer sb) {
        int noOfWorkerDesks = 0;
        int noOfWorker= 0;

        if (workersArr[0] == null) {
            addWorkers(workersArr);
        }
        //Worker[][] workers = new Worker[rows][cols];
        if ("mgr".equals(worker)){
            noOfWorkerDesks = da.noOfMgrDesks;
        }
        if ("dev".equals(worker)){
            noOfWorkerDesks = da.noOfDevDesks;
        }
        for (int i = 0; i < da.rows; i++){
            boolean noPos = true;
            String line = "";
            for (int j = 0; j < da.cols; j++) {
                if (da.floor[i][j] == '#' && noPos) {
                    /*if (j == da.cols - 1 && noPos){
                        line = "X";
                    }*/
                    continue;
                } else if((da.floor[i][j] == '_' && "dev".equals(worker))){// || (da.floor[i][j] == 'M' && "mgr".equals(worker))) {
                    noPos = false;
                    // Developer dev = (Developer)da.choose(da.allocatedDevs, da.devArr, j, i );
                    //canAllocateDeskToWorker(workers, j, i);
                    Worker wrkr = canAllocateDeskToWorker(workers, j, i, worker, sb);
                    int m = 0;


                    //Developer dev = (Developer) canAllocateDeskToWorker(workers, j, i);
                    if (wrkr instanceof Developer){
                        wrkr = (Developer)wrkr;
                    }else  if (wrkr instanceof Manager){
                        wrkr =(Manager)wrkr;
                    }

                    if(wrkr != null) {       //a.choose(da.allocatedDevs, da.devArr, j, i ) != null) {
                        line = j + " " + i;
                        workers[i][j] = wrkr;
                        noOfDevDesks--;
                    } else {
                        line ="X";
                        workers[i][j] = null;
                    }
                    sb.append(line + "\n");
                    int coordRow = sb.toString().split("\n").length;
                    /*while (coordRow < devCounter){
                        // m = devCounter - (sb.toString().split("\n").length );
                        line ="X";
                        sb.append(line + "\n");
                        coordRow++;
                    }*/
                }  else if(da.floor[i][j] == '_' && "mgr".equals(worker)) {
                    line ="X";
                    sb.append(line + "\n");
                    devCounter++;
                    _Mgr++;
                } else if(da.floor[i][j] == 'M' && "mgr".equals(worker)) {
                    Manager mgr= (Manager) canAllocateDeskToWorker(workers, j, i, worker, sb);
                    /*if (devCounter < (sb.toString().split("\n").length )){
                        line ="X";
                        sb.append(line + "\n");
                    }*/
                    if (mgr != null){
                        line = j + " " + i;
                        workers[i][j] = mgr;
                        noOfMgrDesks--;
                    } else {
                        line ="X";
                        workers[i][j] = null;
                    }

                    da.noOfMgrs--;
                    sb.append(line + "\n");
                    int coordRow = sb.toString().split("\n").length;
                    /*while (coordRow < devCounter){
                        // m = devCounter - (sb.toString().split("\n").length );
                        line ="X";
                        sb.append(line + "\n");
                        coordRow++;
                    }*/
                }  else if(da.floor[i][j] == 'M' && "dev".equals(worker)) {
                    line ="X";
                    sb.append(line + "\n");
                    devCounter++;
                    devM++;
                }
                /*if ("mgr".equals(worker)){
                    noOfWorker = da.noOfMgrs;
                }
                if ("dev".equals(worker)){
                    noOfWorker = da.noOfDevs;
                }*/

                /*if(noOfDevDesks == 0 && "dev".equals(worker)){
                    devCounter++;
                    line = "X";
                    sb.append(line + "\n");
                }
                if(noOfMgrDesks == 0 && "mgr".equals(worker)){
                    devCounter++;
                    line = "X";
                    sb.append(line + "\n");
                }*/
               /* if (devCounter < (sb.toString().split("\n").length )){
                    line ="X";
                    sb.append(line + "\n");
                }*/
                /*if(i == da.rows-1 && j == da.cols-1 && noOfWorker > 0){
                    for (int n = 0; n <= noOfWorker-1; n++){
                        line = "X";
                        sb.append(line + "\n");
                    }
                }*/
                // if (checkAllXs(i, j, da.rows, da.cols, noOfWorkerDesks))
            }
        }
    }

    private void addWorkers(Worker[] workers){ //, List<Developer> devs) {
        for (int i = 0; i < devs.size(); i++){
            workers[i] = devs.get(i);
        }
        for (int i = 0; i < mgrs.size(); i++){
            workers[i+devs.size()] = mgrs.get(i);
        }
    }

    private void addMgrs(Worker[] workers) { //, List<Manager> mgrs) {
        for (int i = devs.size(); i < mgrs.size(); i++){
            workers[i] = mgrs.get(i);
        }
    }

    private  Worker canAllocateDeskToWorker(Worker[][] workers, int col, int row, String workerType, StringBuffer sb) {
        int counter = 0;
        int limit = 0;
        if ("dev".equals(workerType)){
            limit = noOfDevs;
        } else {
            limit = workersArr.length;
        }
        for (counter = devCounter; counter < limit; counter++) {
            if (!seatLeft(workers, col, row) && !seatRight(workers, col, row) && !seatBack(workers, col, row)) {
                devCounter++;
                //addLine(sb, col, row);
                return workersArr[counter];
            }
            if (seatLeft(workers, col, row)) {
                Worker workerAtLeft = workers[row][col - 1];
                //for (counter = devCounter + 1; counter < limit; i++) {
                if (workerAtLeft.getCompany().equals(workersArr[counter].getCompany())) {
                    devCounter++;
                    //addLine(sb, col, row);
                    return workersArr[counter];
                } else if(sb.toString().split("\n").length < devCounter){
                    sb.append("X" + "\n");
                }
                // }
            }
            if (seatRight(workers, col, row)) {
                Worker workerAtRight = workers[row][col + 1];
                // for (int i = devCounter + 1; i < limit; i++) {
                if (workerAtRight.getCompany().equals(workersArr[counter].getCompany())) {
                    devCounter++;
                    //addLine(sb, col, row);
                    return workersArr[counter];
                } else if(sb.toString().split("\n").length < devCounter){
                    sb.append("X" + "\n");
                }
                // }
            }
            if (seatBack(workers, col, row)) {
                Worker workerAtBack = workers[row - 1][col];
                //for (int i = devCounter + 1; i < limit; i++) {
                if (workerAtBack.getCompany().equals(workersArr[counter].getCompany())) {
                    devCounter++;
                    //addLine(sb, col, row);
                    return workersArr[counter];
                } else if(sb.toString().split("\n").length < devCounter){
                    sb.append("X" + "\n");
                }
                //}
            }
        }
        //sb.append("X" + "\n");
        devCounter++;
        return null;
    }

    private void addLine(StringBuffer sb, int col, int row) {
        String line = "";
        line = col + " " + row;
        sb.append(line + "\n");
    }

    private boolean seatLeft(Worker[][] workers, int col, int row){
        //col > 0 && workerAtLeft != null && workerAtLeft.getCompany().equals(devArr[]
        if (col > 0 && workers[row][col-1] != null){
            return true;
        } else {
            return false;
        }
    }
    private boolean seatRight(Worker[][] workers, int col, int row){
        if (col+1 < cols && workers[row][col+1] != null){
            return true;
        } else {
            return false;
        }
    }

    private boolean seatBack(Worker[][] workers, int col, int row){
        if (row > 0 && workers[row-1][col] != null) {
            return true;
        } else {
            return false;
        }
    }
    private boolean canSitFront(){

        return false;
    }
    private  Worker choose(List<Developer> allocatedDevs, Developer[] devArr, int col, int row) {
        boolean ok = false;
        int size = allocatedDevs.size();
        if (size == 0){
            allocatedDevs.add(devArr[0]);
            //devArr[0] = null;
            removeElement(devArr, 0);
            //ok = true;
            return devArr[0];
        }else {
            Developer dev = allocatedDevs.get(size-1);
            // if(checkLeft(col-1, row, dev));
            for (int i = allocatedDevs.size(); i < devArr.length; i++){
                if (dev.getCompany().equals(devArr[i].getCompany())){
                    allocatedDevs.add(devArr[i]);
                    //devArr[i] = null;
                    removeElement(devArr, i);
                    //ok = true;
                    return devArr[i];
                }
            }
        }
        return null;
    }

    private boolean checkLeft(int i, int row, Developer dev) {
        if(!(floor[i][row] == '#')){
            //Developer leftDev =

        }
        return true;
    }

    public int removeElement(Developer[]devs, int index){
        int n = devs.length;

        for (int i = 0; i < devs.length; i++){
            if (i == index){
                devs = copyArr(devs, i);
                i--;
            }
        }
        return devs.length;
    }

    private Developer[] copyArr(Developer[]devs, int index){
        Developer[] newArr = new Developer[devs.length - 1];
        System.arraycopy(devs, 0, newArr, 0, index);
        System.arraycopy(devs, index + 1, newArr, index, devs.length - index - 1);
        return newArr;
    }


    private void readFileAndSetupFloor(String filePath) {

        Scanner scanner;
        try{
            scanner = new Scanner(new File(filePath));
            int counter = 0;
            boolean isFloorSetup = false;
            boolean isDevNrProcessed = false;
            boolean isDevsProcessed = false;
            boolean isDMgrNrProcessed = false;
            boolean isMgrsProcessed = false;


            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");
                if (Character.isDigit(fields[0].charAt(0)) && fields.length == 2) {
                    cols = Integer.valueOf(fields[0]);
                    rows = Integer.valueOf(fields[1]);
                    floor = new char[rows][cols];
                    continue;
                }
                if (fields[0].length() == cols && !isFloorSetup){
                    for (int i = 0; i < cols; i++){
                        floor[counter][i] = fields[0].charAt(i);
                        if (fields[0].charAt(i) == '_'){
                            noOfDevDesks++;
                        }
                        if (fields[0].charAt(i) == 'M'){
                            noOfMgrDesks++;
                        }
                    }
                    counter++;
                    if (rows == counter){
                        isFloorSetup = true;
                        counter = 0;
                    }
                    continue;
                }
                if (fields.length == 1 && !isDevNrProcessed){
                    noOfDevs = Integer.valueOf(fields[0]);
                    devArr = new Developer[noOfDevs];
                    isDevNrProcessed = true;
                    continue;
                }
                if (fields.length > 3 && isDevNrProcessed){
                    Developer dev = new Developer();
                    dev.setCompany(fields[0]);
                    dev.setBonusPotential(fields[1]);
                    int noOfSkills = Integer.valueOf(fields[2]);
                    List<String> skills = new ArrayList<>();
                    for (int n = 3; n < (noOfSkills+3); n++) {
                        skills.add(fields[n]);
                    }
                    dev.setSkillList(skills);
                    devs.add(dev);
                    devArr[counter] = dev;
                    counter++;
                    if (counter == noOfDevs){
                        isDevsProcessed = true;
                        counter = 0;
                    }
                    continue;
                }
                if (fields.length == 1 && isDevsProcessed){
                    noOfMgrs = Integer.valueOf(fields[0]);
                    mgrArr = new Manager[noOfMgrs];
                    isDMgrNrProcessed = true;
                    continue;
                }
                if (!Character.isDigit(fields[0].charAt(0))  && fields.length > 1){
                    Manager mgr = new Manager();
                    mgr.setCompany(fields[0]);
                    mgr.setBonusPotential(fields[1]);

                    mgrs.add(mgr);
                    mgrArr[counter] = mgr;
                    counter++;
                    if (counter == noOfMgrs){
                        isMgrsProcessed = true;
                        counter = 0;
                    }

                }
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
