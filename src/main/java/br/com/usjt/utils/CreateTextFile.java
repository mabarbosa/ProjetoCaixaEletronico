package br.com.usjt.utils;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.File;
import javax.swing.*;


import br.com.usjt.model.entidades.AutenticacaoVO;

public class CreateTextFile{

   private Formatter output; // object used to output text to file
// enable user to open file
   public void openFile(String file)
   {

      try
      {
         File arquivo = new File("/arquivo/autenticacao.txt");
         if(arquivo.exists()) {
            if(arquivo.isFile()){
               output = new Formatter(arquivo);
            }
         }
         else{

            output = new Formatter( file );
         }
      } // end try

      catch ( SecurityException securityException )
      {
         System.err.println(
            "You do not have write access to this file." );
         System.exit( 1 );
      } // end catch
      catch ( FileNotFoundException filesNotFoundException )
      {
         System.err.println( "Error creating file." );
         System.exit( 1 );
      } // end catch
      catch ( Exception ex )
      {
         System.err.println( "Error creating file." );
         System.exit( 1 );
      }
   } // end method openFile
// add records to file
   public void addRecords(AutenticacaoVO record)
   {
      try // output values to file
      {

         if (record.getSenha() != null && record.getAgencia() != null &&  record.getConta() != null)
         {
            // write new record
            output.format( "%d %d %s\n",record.getAgencia() ,record.getConta() ,record.getSenha());

            JOptionPane.showMessageDialog( null , "Cadastro realizado com sucesso !");
         } // end if
         else
         {
            System.out.println(
                  "Account number must be greater than 0." );
         }
      }


      catch ( FormatterClosedException formatterClosedException )
      {
         System.err.println( "Error writing to file." );
         return;

      }

      catch ( NoSuchElementException elementException )
      {
         System.err.println( "Invalid input. Please try again." );
      }
      catch ( Exception e )
      {
         System.err.println( e.getStackTrace());
      }

      return;

   } // end method addRecords
// close file
   public void closeFile()
   {
      if ( output != null )
         output.close();
   } // end method closeFile
}



