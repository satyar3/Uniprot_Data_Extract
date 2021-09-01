import Service.DataUploaderService;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) throws IOException {
        System.out.println("######################################");
        System.out.println("Developed By : Parameswari Behera");
        System.out.println("######################################");
        DataUploaderService dataUploaderService = new DataUploaderService();

        //Path input = Files.createDirectory(Paths.get(System.getProperty("user.dir")+System.getProperty("file.separator")+"Input"));
        Path downloads = null, output = null;
        try {
            downloads = Files.createDirectory(Paths.get(System.getProperty("user.dir") + System.getProperty("file.separator") + "Downloads"));
            output = Files.createDirectory(Paths.get(System.getProperty("user.dir") + System.getProperty("file.separator") + "Output"));
        } catch (FileAlreadyExistsException e) {
            System.out.println("Skipping Directory Creation as it's already Exists");
            downloads = Paths.get(System.getProperty("user.dir") + System.getProperty("file.separator") + "Downloads");
            output = Paths.get(System.getProperty("user.dir") + System.getProperty("file.separator") + "Output");
        }

        dataUploaderService.run(Paths.get(System.getProperty("user.dir") + System.getProperty("file.separator") + "Input").toAbsolutePath().toString(),
                downloads.toAbsolutePath().toString(),
                output.toAbsolutePath().toString());

    }

}
