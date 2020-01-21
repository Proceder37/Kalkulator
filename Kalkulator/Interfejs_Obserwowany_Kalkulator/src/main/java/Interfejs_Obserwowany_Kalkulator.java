
import com.mycompany.obserwator.Implementacja_Obserwatora;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio
 */
public interface Interfejs_Obserwowany_Kalkulator {
    void addObserver(Implementacja_Obserwatora observer);
    void removeObserver(Implementacja_Obserwatora observer);
    void notifyObservers();

   
}
