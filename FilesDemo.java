import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Path dirPath = Paths.get("C:/JavaProgramming/gameData");
        Path usersfilePath = Paths.get("Highscores.txt");
        Path settingfilePath = Paths.get("Setting.txt");
        Path users, setting;
        users = checkFiles(dirPath, usersfilePath);
        setting = checkFiles(dirPath, settingfilePath);
        if (users!=null) 
            displayFileStatus(users, setting);
        deleteFile(setting);
    }

    static Path checkFiles(Path dirPath, Path filePath){
        Path absPath = dirPath.resolve(filePath);
        try {
            if(Files.notExists(dirPath))
                Files.createDirectories(dirPath);
            if(Files.notExists(absPath))
                Files.createDirectories(dirPath);
        }   
        catch (IOException x) {
            System.err.println(x);
            return null;
        }
        return absPath;
    }

    static void displayFileStatus(Path users, Path settings) throws IOException{
        System.out.println("Readable: " + Files.isReadable(users));
        System.out.println("Writeable: "+ Files.isWritable(users));
        System.out.println("Executable: "+ Files.isExecutable(users));
        System.out.println("Hidden: "+ Files.isHidden(users));
        System.out.println("Same files: "+ Files.isSameFile(users, settings));
    }

    static void deleteFile(Path filePath){

        try {
            if(Files.exists(filePath)){
                Files.delete(filePath);
                System.out.println(filePath.toString()+ " deleted!");
            }
            else{
                System.out.println(filePath.toString()+ " not found!");
            }
        }
        catch (IOException x) {
            System.err.println(x);
        }
    }
}
