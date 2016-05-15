/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Tipoproducto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author huanc
 */
@Remote
public interface TipoproductoFacadeRemote {

    void create(Tipoproducto tipoproducto);

    void edit(Tipoproducto tipoproducto);

    void remove(Tipoproducto tipoproducto);

    Tipoproducto find(Object id);

    List<Tipoproducto> findAll();

    List<Tipoproducto> findRange(int[] range);

    int count();
    
}
