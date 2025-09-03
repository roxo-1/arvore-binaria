public class Arvore{
    No raiz; // fazer o nó depois
    public Arvore () { raiz = null; }
    public void inserir(int valor){
        if(raiz == null){
            raiz = new No(valor);
        }else{
            No p, ant;
            p = raiz; ant = raiz;
            while (p!=null){
                ant = p;
                if(valor<chave){
                    p=p.esquerda;
                }else if(valor > chave){
                    p=p.direita;
                }else{
                    System.out.println("O valor já existe");
                    return;
                }
            }
            if(valor < ant.chave){
                ant.esquerda=novoNo(valor);
            } else{
                ant.direita=novoNo(valor);
            }
        }
    }

    private void mostraInOrdem(){
        if (no != null) {
            mostraInOrdem(no.left);
            System.out.print(no.value + " "); 
            mostraInOrdem(no.right);
        }
    }
    void mostrar(){
        mostraInOrdem();
    }
}