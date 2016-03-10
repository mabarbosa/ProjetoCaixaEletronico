package br.com.usjt.utils;

public class BuscaBinaria
{
   public static int executar(String[] vetor, long busca)
   {
      int inicio, meio, fim, resultado;

      inicio = 0;
      fim = vetor.length-1;
      resultado = -1;

      while(inicio <= fim)
      {
         meio = (inicio + fim)/2;

         if(Long.parseLong(vetor[meio].substring(0, 8)) == busca)
         {
            resultado = meio;
            inicio = (fim + 1);
         }
         else
         {
            if(Long.parseLong(vetor[meio].substring(0, 8)) > busca)
            {
               fim = meio - 1;
            }
            else
            {
               inicio = meio + 1;
            }
         }
      }

      return resultado;
   }
}
