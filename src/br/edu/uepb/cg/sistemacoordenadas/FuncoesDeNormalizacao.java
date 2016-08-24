package br.edu.uepb.cg.sistemacoordenadas;

public class FuncoesDeNormalizacao {

    private static float ndcx;
    private static float ndcy;
    private static float dcx;
    private static float dcy;

    public static float calcularNDCX(float ndh, float dcx) {
        ndcx = (float) dcx / (ndh - 1);
        return ndcx;
    }

    public static float calcularNDCY(float ndv, float dcy) {
        ndcy = (float) (dcy / (ndv - 1));
        return ndcy;
    }

    public static int calcularDCX(float ndh, float ndcx) {
        dcx = ((ndh - 1) * ndcx);
        return (int) Math.round(dcx);
    }

    public static int calcularDCY(float ndv, float ndcy) {
        dcy = ((ndv - 1) * ndcy);
        return (int) Math.round(dcy);
    }

}
