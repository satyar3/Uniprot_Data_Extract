package Service;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import pom.UniProtCustomizedColumns;
import pom.UniProtDownloadPanel;
import pom.UniProtFileUpload;
import pom.UniProtLanding;
import pom.UniProtResults;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataUploaderService {

    public void run(String inputPath, String downloadPath, String outPutPath) {

        try {

            Set<String> fileListToBeUploaded = Files.list(Paths.get(inputPath)).filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());

            DriverService driverService = new DriverService();
            WebDriver driver = driverService.initDriver(downloadPath);
            driverService.goTo(driver);

            UniProtLanding uniProtLanding = new UniProtLanding(driver);
            uniProtLanding.closePrivacy().selectMapping();

            UniProtFileUpload uniProtFileUpload = new UniProtFileUpload(driver);
            uniProtFileUpload.uploadFile(inputPath, fileListToBeUploaded);

            UniProtResults uniProtResults = new UniProtResults(driver);
            uniProtResults.clickOnColumns();

            UniProtCustomizedColumns uniProtCustomizedColumns = new UniProtCustomizedColumns(driver);
            uniProtCustomizedColumns.arrangeColumns();

            UniProtDownloadPanel uniProtDownloadPanel = new UniProtDownloadPanel(driver);

            AtomicInteger counter = new AtomicInteger();

            fileListToBeUploaded.stream().forEach(file ->
                    uploadFileStream(inputPath, downloadPath, outPutPath, downloadPath, uniProtLanding, uniProtFileUpload, uniProtDownloadPanel, counter, file));

        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println("Server Error while performing operation : Please start the again");
        }
    }

    private void uploadFileStream(String inputPath, String downloadPath, String outPutPath, String downloadFilepath, UniProtLanding uniProtLanding, UniProtFileUpload uniProtFileUpload, UniProtDownloadPanel uniProtDownloadPanel, AtomicInteger counter, String file) {
        try {
            System.out.println(counter.incrementAndGet());
            System.out.println("Starting for the File : " + file);
            Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));

            uniProtLanding.selectMapping();
            uniProtFileUpload.uploadFile(inputPath, file);
            uniProtDownloadPanel.download();

            String fileNameInDownloadFolder = Files.list(Paths.get(downloadFilepath)).filter(f -> !Files.isDirectory(f))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .findFirst().get();

            Path fileToMovePath = Paths.get(downloadPath + "/" + fileNameInDownloadFolder);
            Path afterRenameInSource = Paths.get(outPutPath + "/" + file + "_" + fileNameInDownloadFolder);
            Files.move(fileToMovePath, afterRenameInSource);

            System.out.println("Finished for the File : " + file);

        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println("Error while performing operation : Please do it again for File : " + file);
        }
    }
}