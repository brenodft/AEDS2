//Algorítmo para remover números ímpares de uma Matriz Flexível
public class RemoverImparesMatrixFlexivel {
    Celulamat y = inicio;
    while(y != null){
        for(Celulamat i = y; i != null; i = i.prox){
            for(Celula j = i.primeiro; j.prox != null; j = j.prox){
                if(j.prox.numero %2 != 0){
                    j.prox = j.prox.prox;
                }
            }
        }
        y = y.inf;
    }
}
