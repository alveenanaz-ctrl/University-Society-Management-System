import java.io.*;
import java.util.ArrayList;
public class FileHandler 
{
   private static final String SOCIETIES_FILE = System.getProperty("user.home") + File.separator + "societies.dat";

    // Save all societies to file
    public static void saveSocieties(ArrayList<Society> societies) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SOCIETIES_FILE))) {
            oos.writeObject(societies);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load societies from file
    @SuppressWarnings("unchecked")
    public static ArrayList<Society> loadSocieties() {
        File file = new File(SOCIETIES_FILE);
        if (!file.exists()) {
            System.out.println("No previous data found. Starting fresh.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SOCIETIES_FILE))) {
            ArrayList<Society> societies = (ArrayList<Society>) ois.readObject();
            System.out.println("Data loaded successfully. " + societies.size() + " societies found.");
            return societies;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    } 
}
