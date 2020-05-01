package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        return converter(texto, false, 3);
    }

    @Override
    public String descriptografar(String texto) {
        return converter(texto, true, 3);
    }

    private String converter(String texto, boolean criptografado, int casas){
        verificarTexto(texto);
        String mensagem = texto.toLowerCase();
        String mensagemResultante ="";
        int n;
        int referencia;
        if (criptografado){
            n = -casas;
            referencia = 122;
        }else {
            n = casas;
            referencia = 97;
        }

        for (int i = 0; i < mensagem.length(); i++) {

            if (97 <= mensagem.charAt(i) && mensagem.charAt(i) <= 122) {
                mensagemResultante = mensagemResultante + (char) ((int) ((mensagem.charAt(i)-referencia+n)%26)+referencia);
            } else {
                mensagemResultante = mensagemResultante + mensagem.charAt(i);
            }
        }
        return mensagemResultante;
    }
    private void verificarTexto(String texto){

        if (texto.isEmpty() || texto==null){
            throw new IllegalArgumentException("Texto não pode ser vazio, nem nulo!");
        }

    }

}