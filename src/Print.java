import java.io.*;

public class Print extends Main{
    public static void show_contacts() throws IOException, FileNotFoundException {
        File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");//we get the contact file
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());
        System.out.println(file.exists());
        file.createNewFile();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        boolean first = false;
        String[] fields = new String[0];
        while((currentLine = reader.readLine()) !=null) {//for each line in txt file
            if(!first) {//if it is the first line the line is the fields and we save them into an array
                fields = currentLine.split(",");
                first = true;
            }
            else {//for the rest lines we print the information
                System.out.println("-------------------");
                String[] info=currentLine.split(",");
                for (int i = 0; i < fields.length; i++ ) {
                    System.out.println(fields[i] +": "+ info[i]);
                }
            }
        }
        System.out.println("-------------------");
        reader.close();
    }
}
