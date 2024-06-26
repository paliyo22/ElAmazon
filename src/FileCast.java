import java.io.*;

public class FileCast {
    public FileCast() {
    }

    public int toFile(String path, Amazon data){
        int message;
        File save= new File(path);
        ObjectOutputStream output;
        try {
            output = new ObjectOutputStream(new FileOutputStream(save,false));
            output.writeObject(data);
            output.close();
            message=0;

        }catch(IOException ex){
            message=1;
        }
        return message;
    }
    public Amazon getFile(String path){
        Amazon aux = null;
        File save= new File(path);
        ObjectInputStream input;
        try{
           input=new ObjectInputStream(new FileInputStream(save));
           aux = (Amazon) input.readObject();
           input.close();

        }catch (IOException ex){
            System.out.println("El archivo no existe o esta dañado");
        } catch (ClassNotFoundException e) {
            System.out.println("Los datos de alrchivo no coinciden con los datos requeridos");
        }
        return aux;
    }
}
