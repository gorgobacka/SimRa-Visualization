package main.java.com.simra.app.csvimporter.services;

import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * The type Thread controller.
 */
public class ThreadController {

    private static final Logger logger = Logger.getLogger(ThreadController.class);


    private ArrayList<Path> filePaths;
    private ThreadPoolExecutor executor;
    private String type;
    private Float minAccuracy;
    private Double rdpEpsilon;


    /**
     * Instantiates a new Thread controller.
     *
     * @param paths       the paths to import
     * @param type        the type
     * @param minAccuracy the min accuracy
     * @param rdpEpsilon  the rdp epsilon
     */
    public ThreadController(ArrayList<Path> paths, String type, Float minAccuracy, Double rdpEpsilon) {
        this.filePaths = paths;
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        this.type = type;
        this.minAccuracy = minAccuracy;
        this.rdpEpsilon = rdpEpsilon;
    }

    /**
     * Execute file read.
     */
    public void executeFileRead() {

        this.filePaths.forEach(filePath -> {
            if (this.type.contains("r")) {
                RideImportTask rideImportTask = new RideImportTask(filePath, this.minAccuracy, this.rdpEpsilon);
                logger.info("Ride Task Created : " + rideImportTask.getFilePath());
                this.executor.execute(rideImportTask);
            }
            if (this.type.contains("p")) {
                ProfileImportTask profileImportTask = new ProfileImportTask(filePath);
                logger.info("Ride Task Created : " + profileImportTask.getFilePath());
                this.executor.execute(profileImportTask);
            }

        });

        this.executor.shutdown();
        logger.info("File imports done");

    }
}
