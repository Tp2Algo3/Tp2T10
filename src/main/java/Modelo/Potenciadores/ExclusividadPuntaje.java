package Modelo.Potenciadores;

import java.util.ArrayList;

public class ExclusividadPuntaje {

    private int multiplicador;

    public ExclusividadPuntaje(){
        multiplicador = 2;
    }

    private void definirMultiplicador(ArrayList<Boolean> contestaronCorrectamente){
        if(contestaronCorrectamente.stream().allMatch(respCorrecta -> respCorrecta))
            multiplicador = 0;
    }

    public void multiplicarPuntos(ArrayList<Integer> puntajes, ArrayList<Boolean> contestaronCorrectamente){
        definirMultiplicador(contestaronCorrectamente);
        for(int i=0; i < puntajes.size(); i++){
            if(contestaronCorrectamente.get(i)) {
                puntajes.set(i, puntajes.get(i)*multiplicador);
            }
        }
    }
}
