/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Paquete;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author huanc
 */
@Remote
public interface PaqueteFacadeRemote {

    void create(Paquete paquete);

    void edit(Paquete paquete);

    void remove(Paquete paquete);

    Paquete find(Object id);

    List<Paquete> findAll();

    List<Paquete> findRange(int[] range);

    int count();
    
}
