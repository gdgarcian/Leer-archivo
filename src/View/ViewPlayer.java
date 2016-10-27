
package View;

import DaoPlayer.DaoPlayer;
import VO.Player;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ViewPlayer {
    private DaoPlayer dao;
    private ArrayList<Player> player = new ArrayList<Player>();
    
    public ViewPlayer(){
        try{
            this.dao = new DaoPlayer();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
        }
        
    }
    
    public void menu(){
      String opcion = JOptionPane.showInputDialog(null, "1. Crear\n2.Guardar\n3.leer");
      if(opcion.equals("1")){
          String name = JOptionPane.showInputDialog(null, "Name: ");
          String email = JOptionPane.showInputDialog(null, "Email: ");
          Player player = new Player (name, email);
          this.player.add(player);
      }else if (opcion.equals("2")){
          try{
              this.dao.write(player);
          }catch (FileNotFoundException e){
              JOptionPane.showMessageDialog(null, "Error escritura");
          }
      }else if(opcion.equals("3")){
          try{
              ArrayList<Player> players = this.dao.read();
              for(Player p : players){
                  System.out.println(p);
              }
          }catch(FileNotFoundException ex){
              JOptionPane.showMessageDialog(null, "Error lectura");
          }
      }
      
    }
}
