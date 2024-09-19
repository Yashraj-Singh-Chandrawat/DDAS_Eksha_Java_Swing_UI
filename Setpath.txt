import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class SetPath1{
    public void setpath()
    {
        String path[] = {"C:/Users/PCLP/Documents","C:/Users/PCLP/Downloads"};
        String pathseparator = System.getProperty("path.separator");

        String joinedpaths= String.join(pathseparator,path);
        String command = "setx DDAS_DIRECTORIES \"" + joinedpaths+ "\"";
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("setpath.bat"));
            writer.write(command);
            writer.close();
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","start","setpath.bat");
			Process process = pb.start();
			process.waitFor();
            System.out.println("environment path variable set to " + joinedpaths);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
public class Setpath {
    public static void main(String[] args) {
        SetPath1 p = new SetPath1();
        p.setpath();
    }
}