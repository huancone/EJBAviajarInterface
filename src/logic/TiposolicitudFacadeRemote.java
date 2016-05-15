/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Tiposolicitud;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author huanc
 */
@Remote
public interface TiposolicitudFacadeRemote {

    void create(Tiposolicitud tiposolicitud);

    void edit(Tiposolicitud tiposolicitud);

    void remove(Tiposolicitud tiposolicitud);

    Tiposolicitud find(Object id);

    List<Tiposolicitud> findAll();

    List<Tiposolicitud> findRange(int[] range);

    int count();
    
}
