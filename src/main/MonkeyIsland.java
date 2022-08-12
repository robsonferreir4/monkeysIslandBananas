package main;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonkeyIsland {

    public static void main(String[] args) {

        //O algoritmo a ser utilizado é uma variação do algoritmo de busca em largura em grafos. BFS.
        //O algoritmo visita um nó da matriz e seus vizinhos de acordo com a restrição dada: diagonal cima, frente, diagonal baixo
        //Ao ir visitando as possibiilidades, somar e guardar o resultado da soma até não poder mais visitar nós
        //A complexidade calculada foi de O(m,n)+O(m,n) = O(m,n) por simplificação
        //O algoritmo, numa iteração pelas linhas, percorre cada coluna uma vez e guarda numa outra matriz a soma do caminho: O(m,n)
        //Ao final, é feito mais um loop para encontrar o somatório maior na última coluna da matriz de soma: O(m,n)
        System.out.println(getMaxBananas(new long[][]{{1, 3, 3},
                                                      {2, 1, 4},
                                                      {0, 6, 4}}));

        System.out.println(getMaxBananas(new long[][]{  {1, 3, 1, 5},
                                                        {2, 2, 4, 1},
                                                        {5, 0, 2, 3},
                                                        {0, 6, 1, 2}}));

        System.out.println(getMaxBananas(new long[][]{  {10, 33, 13, 15},
                                                        {22, 21, 04, 1},
                                                        { 5,  0,  2, 3},
                                                        { 0,  6, 14, 2}}));

        System.out.println(getMaxBananas(new long[][]{  { 10,  33,   13, 15},
                                                        { 100, 21,   04, 1},
                                                        { 5,   0,    2,  3},
                                                        { 0,   1000, 2,  3},
                                                        { 0,   6,    14, 2}}));
    }

    private static long getMaxBananas(long[][] jungle) {
        if (jungle == null || jungle.length == 0) {
            return 0L;
        }

        // A matriz sums vai guardar os somatórios dos caminhos percorridos. Vamos inicializar somente a primeira coluna. O restante inicia como
        // zero (0L). Aproveitamos para tambem inicializar a fila que sera usada para o BFS.
        // Utilizaremos uma estrutura de dados chamada deque, que é uma fila com possibilidade de saída pela frente ou por trás
        // A fila será de arrays (duas posicoes) de coordenadas na matrix.
        long[][] sums = new long[jungle.length][jungle[0].length];
        Deque<int[]> dq = new ArrayDeque<>();

        for (int row = 0; row < jungle.length; ++row) {
            sums[row][0] = jungle[row][0];
            dq.offer(new int[]{row, 0});
        }

        // Como sempre iremos andar na mesma direção, não precisamos nos preocupar em manter os nós visitados.
        while (!dq.isEmpty()) {
            int[] curr = dq.pop(); //escolhendo próximo da fila
            long currVal = sums[curr[0]][curr[1]]; //valor atual de somatório

            int[] nextRightUp   = new int[]{curr[0] - 1, curr[1] + 1};  //diagonal cima
            int[] nextRight     = new int[]{curr[0], curr[1] + 1};      //direita
            int[] nextRightDown = new int[]{curr[0] + 1, curr[1] + 1};  //diagonal baixo

            // Precisamos checar se não vamos para fora da matriz ao andar nas diagonais ou para direita, caso contrário iremos receber
            // um ArrayOutOfBoundsException.
            //Para cada if, caso seja possível alcançar um nó nas direções, a a matriz de soma será prenchida com o valor
            //maior da soma dos caminhos e será adicionado na fila, o nó escolhido para ser visitado na próxima iteração
            if (nextRightUp[0] >= 0 && nextRightUp[0] < jungle.length && nextRightUp[1] < jungle[0].length) {
                sums[nextRightUp[0]][nextRightUp[1]] = Math.max(sums[nextRightUp[0]][nextRightUp[1]],
                                                        currVal + jungle[nextRightUp[0]][nextRightUp[1]]);

                dq.push(nextRightUp);
            }
            if(nextRight[0] >= 0 && nextRight[0] < jungle.length && nextRight[1] < jungle[0].length){
                sums[nextRight[0]][nextRight[1]] = Math.max(sums[nextRight[0]][nextRight[1]],
                                                        currVal + jungle[nextRight[0]][nextRight[1]]);

                dq.push(nextRight);
            }
            if (nextRightDown[0] < jungle.length && nextRightDown[1] < jungle[0].length) {
                sums[nextRightDown[0]][nextRightDown[1]] = Math.max(sums[nextRightDown[0]][nextRightDown[1]],
                                                        currVal + jungle[nextRightDown[0]][nextRightDown[1]]);

                dq.push(nextRightDown);
            }
        }

        long result = Long.MIN_VALUE;

        // Nas últimas colunas teremos os máximos, agora basta escolher-mos o máximo dos máximos.
        for (long[] sum : sums) {
            result = Math.max(result, sum[sums[0].length - 1]);
        }

        return result;
    }
}