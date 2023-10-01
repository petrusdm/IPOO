/**
 * Uma classe que modela um cliente de e-mail simples.
 * O cliente é executado por um usuário específico, e envia e
 * recebe e-mails através de um servidor específico.
 * 
 * Traduzido por Julio César Alves. 2023-09-22
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class ClienteDeEmail{
    // O servidor usar para enviar e receber e-mails.
    private ServidorDeEmail servidor;
    // O usuário que está rodando este cliente.
    private String usuario;

    /**
     * Cria uma execução de cliente de e-mail pelo usuário e 
     * ligado ao servidor passado.
     */
    public ClienteDeEmail(ServidorDeEmail servidor, String usuario){
        this.servidor = servidor;
        this.usuario = usuario;
    }

    /**
     * Retorna a próxima mensagem de e-mail do servidor, se houver.
     */
    public Email obterProximoEmail(){
        return servidor.obterProximoEmail(usuario);
    }

    /**
     * Imprime no terminal de texto a próxima mensagem de e-mail 
     * deste usuário, se houver.
     */
    public void imprimirProximoEmail(){
        Email email = servidor.obterProximoEmail(usuario);
        if(email == null) {
            System.out.println("Não há novos e-mails.");
        }
        else {
            email.imprimir();
        }
    }
    
    public void imprimirTodosEmails(String remetente){
        Email email = servidor.obterProximoEmail(usuario);
        String remetenteEmail = email.obterRemetente();
        int qtdEmails = 0;
        
        if(remetente == null || remetente == ""){
            while(email != null){
                qtdEmails++;
                email.imprimir();
                System.out.println("------------------------------------------");
                email = servidor.obterProximoEmail(usuario);
            }
            System.out.println("Quantidade de e-mails: " + qtdEmails);
        }
        else{
            while(email != null){
                if(remetente.equals(remetenteEmail)){
                    qtdEmails++;
                    email.imprimir();
                    System.out.println("------------------------------------------");
                }
                email = servidor.obterProximoEmail(usuario);
            }
            System.out.println("Quantidade de e-mails: " + qtdEmails);
        }
    }
    
    public void imprimirTodosEmailsPorAssunto(String assunto){
        Email email = servidor.obterProximoEmail(usuario);
        String assuntoEmail = email.getSubject();
        int qtdEmails = 0;
        
        assunto.toLowerCase();
        assuntoEmail.toLowerCase();
        
        while(email != null){
            if(assuntoEmail.contains(assunto)){
                qtdEmails++;
                email.imprimir();
                System.out.println("------------------------------------------");
            }
            email = servidor.obterProximoEmail(usuario);
        }
        System.out.println("Quantidade de e-mails: " + qtdEmails);
    }
    
    /**
     * Envia a mensagem passada para o destinatário passado
     * usando o servidor de e-mail.
     * @param destinatario O destinatário da mensagem.
     * @param messagem O texto da mensagem a ser enviada.
     */
    public void enviarEmail(String destinatario, String assunto, String mensagem){
        Email email = new Email(usuario, destinatario, assunto, mensagem);
        servidor.postar(email);
    }
    
    public void enviarEmail(String destinatario, String assunto, String mensagem, String anexo){
        Email email = new Email(usuario, destinatario, assunto, mensagem,anexo);
        servidor.postar(email);
    }
}
