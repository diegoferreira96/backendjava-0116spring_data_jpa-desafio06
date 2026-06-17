package br.com.alura.screensound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaChatGPT {
    public static String obterInformacao(String texto){
        Dotenv dotenv = Dotenv.load(); // 1. Inicializa o Dotenv (carrega o arquivo .env da raiz por padrão)
        String apiKey = dotenv.get("OPENAI_APIKEY"); // 2. Recupera a chave salva no arquivo

        OpenAiService service = new OpenAiService(System.getenv(apiKey));
        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
