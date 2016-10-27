
package DaoPlayer;

import VO.Player;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DaoPlayer {
    //1. Referencia a la fuente de datos
    private File player;
    
    public DaoPlayer() throws IOException{
        this.player = new File("xxx.txt");
        if(!this.player.exists()){
            this.player.createNewFile();
        }        
    }
    
    public boolean write(ArrayList<Player> player) throws FileNotFoundException{
        PrintStream salida = new PrintStream(this.player);
        for(Player p : player){
            salida.print(p.getName()+ " " + p.getEmail() );
        }
        salida.close();
        return true;
    }
    
    public ArrayList<Player> read() throws FileNotFoundException{
        Scanner lectura = new Scanner (this.player);
        ArrayList<Player> resultado = new ArrayList<>();
        while(lectura.hasNext()){
            String name = lectura.next();
            String email = lectura.next();
            Player p = new Player(name, email);
            resultado.add(p);
        }
        lectura.close();
        return resultado;
    }
}
