package ejemplosliistener.modelo;

import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;

public class MiModelo extends AbstractListModel<Persona> {


   private static final long serialVersionUID = 1L;
   List<Persona> listaPersonas;

   public MiModelo(List<Persona> listaPersonas) {

       this.listaPersonas = listaPersonas;
   }

   public void add(Persona persona) {
       if (listaPersonas.add(persona)) {
           fireContentsChanged(this, 0, getSize());
       }
   }

   public void clear() {
       listaPersonas.clear();
       fireContentsChanged(this, 0, getSize());
   }

   public boolean contains(Persona element) {
       return listaPersonas.contains(element);
   }

   public Iterator<Persona> iterator() {
       return listaPersonas.iterator();
   }

   public boolean removeElement(Persona persona) {
       boolean removed = listaPersonas.remove(persona);
       if (removed) {
           fireContentsChanged(this, 0, getSize());
       }
       return removed;
   }

   @Override
   public int getSize() {
       // TODO Auto-generated method stub
       return listaPersonas.size();
   }

   @Override
   public Persona getElementAt(int index) {
       // TODO Auto-generated method stub
       return listaPersonas.get(index);
   }

}