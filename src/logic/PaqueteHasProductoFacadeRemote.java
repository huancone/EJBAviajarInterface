/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.PaqueteHasProducto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author huanc
 */
@Remote
public interface PaqueteHasProductoFacadeRemote {

    void create(PaqueteHasProducto paqueteHasProducto);

    void edit(PaqueteHasProducto paqueteHasProducto);

    void remove(PaqueteHasProducto paqueteHasProducto);

    PaqueteHasProducto find(Object id);

    List<PaqueteHasProducto> findAll();

    List<PaqueteHasProducto> findRange(int[] range);

    int count();
    
}
