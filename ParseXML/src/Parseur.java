import java.io.*;

import org.jdom.*;
import org.jdom.input.*;
import org.jdom.filter.*;
import java.util.List;
import java.util.Iterator;

public class Parseur
{
   static org.jdom.Document document;
   static Element racine;

   public static void main(String[] args)
   {
      //On crée une instance de SAXBuilder
      SAXBuilder sxb = new SAXBuilder();
      try
      {
         //On crée un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est terminé ;)
    	 
    	 File f = new File("/home/ceytec/workspace/parseur/src/test.xml");
         document = sxb.build(f);
      }
      catch(Exception e){System.out.println("problem du fichier");}

      //On initialise un nouvel élément racine avec l'élément racine du document.
      racine = document.getRootElement();

      System.out.println(document.getRootElement().getName());
   }
}