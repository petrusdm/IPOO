/**
 * Uma classe que modela uma mensagem simples de e-mail.
 * A mensagem tem endereços remetente e destinatário e uma mensagem string.
 * 
 * Traduzido por Julio César Alves. 2023.09.22
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Email{
    // O remetente da mensagem
    private String remetente;
    // O destinatário da mensagem
    private String destinatario;
    // O assunto da mensagem
    private String assunto;
    // O texto da mensagem
    private String mensagem;
    // O anexo da mensagem
    private String anexo;

    /**
     * Cria uma mensagem de e-mail do remente para o destinário,
     * contendo a mensagem passada.
     * @param remetente O remetente desta mensagem.
     * @param destinatario O destinatário desta mensagem.
     * @param mensagem O texto da mensagem a ser enviada
     */
    public Email(String remetente, String destinatario, String assunto, String mensagem){
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.anexo = "";
    }
    
    public Email(String remetente, String destinatario, String assunto, String mensagem, String anexo){
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.anexo = anexo;
    }

    /**
     * @return O remetente desta mensagem.
     */
    public String obterRemetente(){
        return remetente;
    }

    /**
     * @return O destinatário desta mensagem.
     */
    public String obterDestinatario(){
        return destinatario;
    }

    public String getSubject(){
        return assunto;
    }
    
    /**
     * @return O texto da mensagem.
     */
    public String obterMensagem(){
        return mensagem;
    }

    public String getAttachments(){
        return anexo;
    }
    
    /**
     * Imprime esta mensagem de e-mail no terminal de texto.
     */
    public void imprimir(){
        if(anexo==""){
            System.out.println("De: " + remetente);
            System.out.println("Para: " + destinatario);
            System.out.println("Assunto: " + assunto);
            System.out.println("Messagem: " + mensagem);
        }
        else{
            System.out.println("De: " + remetente);
            System.out.println("Para: " + destinatario);
            System.out.println("Assunto: " + assunto);
            System.out.println("Messagem: " + mensagem);
            System.out.println("Anexo: " + anexo);
        }
    }
}
