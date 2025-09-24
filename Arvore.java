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

    private void mostraInOrdem(No no){
        if (no != null) {
            mostraInOrdem(no.left);
            System.out.print(no.value + " "); 
            mostraInOrdem(no.right);
        }
    }
    void mostrar(No no){
        mostraInOrdem();
    }

    public int nosMaioresQue50(No p){
        if(p==null){
            return 0;
        } else{
            if(p.chave>50){
                return nosMaioresQue50(p.esq, qtd) + nosMaioresQue50(p.dir, qtd) + 1;
            }else{
                return nosMaioresQue50(p.esq) + nosMaioresQue50(p.dir + 0);
            }
        }
        return qtd;
    }

    public static void nivelNo(No p, int nivel){
        if(p!=null){
            nivelNo(p.esq, nivel+1);
            System.out.print("  " + p.chave + ": " + nivel + "\n");
            nivelNo(p.dir, nivel+1);
        }
    }
    public int somaNivel(No p, int k, int nivel, int soma){
        if(p==null){
            return soma;
        }else{
            if(nivel == k){
                soma += p.chave;
            }else{
                soma = somaNivel(p.esq, k, nivel + 1, soma); 
                soma = somaNivel(p.dir, k, nivel + 1, soma);
            }
        }
        return soma;
    }
    // versão recursiva
    private int totalNos(No p){
        if(p==null){
            return 0;
        }
        else{
            return totalNos(p.esq)+totalNos(p.dir)+1;
        }
    }

    //versão iterativa
    public int contaNos(Arvore arvore){
        No p = raiz;
        int qtd;
        Stack<No> pilha = new Stack<>();
        if (raiz == null) {
            return 0;
        }
        while(p!=null || !pilha.isEmpty()){
            while(p != null){
                pilha.push(p);
                qtd++;
                p = p.esq;
            }
            p=pilha.pop();
            p=p.dir;
        }
        return qtd;
    }

    public static int kEsimoMenor(No raiz, int k) {
        if (raiz == null || k <= 0){ 
            return null;
        }
        Stack<No> pilha = new Stack<>();
        No atual = raiz;
        int contador = 0;
        while(atual != null || !pilha.isEmpty()) {
            // desce até o nó mais à esquerda
            while(atual != null) {
                pilha.push(atual);
                contador++;
                atual = atual.esquerda;
            }
            // pega o nó do topo da pilha
            atual = pilha.pop();
            // se chegamos ao k-ésimo nó visitado
            if (contador == k) {
                return atual.valor;
            }
            // vai para a subárvore da direita
            atual = atual.direita;
        }
        return null; // se k for maior que o número de nós
    }
}