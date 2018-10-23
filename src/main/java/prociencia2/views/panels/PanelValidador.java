
package prociencia2.views.panels;

import prociencia2.logic.core.entities.Ocupacion;

/**
 *
 * @author Klac
 */
public interface PanelValidador {
    public boolean camposVacios();
    public void throwWarning();
    public Ocupacion getOcupacion();
    public String getLugar();
}
